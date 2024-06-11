ALTER TABLE medicos
ADD ativo BOOLEAN;

UPDATE medicos
SET ativo = true;

ALTER TABLE medicos
ALTER COLUMN ativo SET NOT NULL;


