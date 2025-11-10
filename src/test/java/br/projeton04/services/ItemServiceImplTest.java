package com.projeton04.service;

import br.projeto.n04.model.Item;
import br.projeto.n04.persistence.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ItemServiceImplTest {
    private Repository<Item> repo;
    private ItemServiceImpl service;

    @BeforeEach
    void setup() {
        repo = Mockito.mock(Repository.class);
        service = new ItemServiceImpl(repo);
    }

    @Test
    void listar_devolve_todos() {
        when(repo.findAll()).thenReturn(List.of(new Item("1","a","d")));
        var lista = service.listar();
        assertThat(lista).hasSize(1);
        verify(repo, times(1)).findAll();
    }

    @Test
    void salvar_cria_id_quando_nulo() {
        Item i = new Item(null, "nome", "desc");
        doAnswer(invocation -> { return null; }).when(repo).save(any());
        service.salvar(i);
        assertThat(i.getId()).isNotNull();
        verify(repo, times(1)).save(i);
    }

    @Test
    void buscarPorId_retorna_item() {
        Item i = new Item("abc", "n", "d");
        when(repo.findById("abc")).thenReturn(Optional.of(i));
        var found = service.buscarPorId("abc");
        assertThat(found).isPresent().get().isEqualTo(i);
    }

    @Test
    void remover_delega_para_repo() {
        service.remover("x");
        verify(repo, times(1)).delete("x");
    }
}
