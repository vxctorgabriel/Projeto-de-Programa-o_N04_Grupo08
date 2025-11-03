CREATE TABLE IF NOT EXISTS evento (
                                      id VARCHAR(36) PRIMARY KEY,
    titulo VARCHAR(255),
    descricao TEXT
    );

CREATE TABLE IF NOT EXISTS participante (
                                            id VARCHAR(36) PRIMARY KEY,
    nome VARCHAR(255),
    tipo VARCHAR(32)
    );

CREATE TABLE IF NOT EXISTS feedback (
                                        id VARCHAR(36) PRIMARY KEY,
    evento_id VARCHAR(36),
    autor_id VARCHAR(36),
    avaliacao INTEGER,
    comentario TEXT,
    sentiment VARCHAR(16),
    denunciado BOOLEAN,
    criado_em TIMESTAMP,
    FOREIGN KEY(evento_id) REFERENCES evento(id),
    FOREIGN KEY(autor_id) REFERENCES participante(id)
    );

CREATE UNIQUE INDEX IF NOT EXISTS ux_feedback_evento_autor ON feedback(evento_id, autor_id);
