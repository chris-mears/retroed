INSERT INTO retros (name, body) VALUES ('Test Retro 1', 'This is a test Retro');
INSERT INTO retros (name, body) VALUES ('Test Retro 2', 'This is the second test Retro');

INSERT INTO sections (retro_id, title, notes)
VALUES (SELECT retro_id from retros WHERE name = 'Test Retro 1', '')