ALTER TABLE paciente
ADD ativo BOOLEAN;

UPDATE paciente
SET ativo = true;

ALTER TABLE paciente
ALTER COLUMN ativo SET NOT NULL;


