ALTER TABLE medicos ADD COLUMN telefone VARCHAR(20) DEFAULT 'Sem numero informado';
ALTER TABLE medicos ALTER COLUMN telefone SET NOT NULL;


