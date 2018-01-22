INSERT INTO retros (name, body) VALUES ('Test Retro 1', 'This is a test Retro');
INSERT INTO retros (name, body) VALUES ('Test Retro 2', 'This is the second test Retro');

/* INSERT INTO column_1 ( val_1, val_from_other_table ) 
VALUES('val_1', (SELECT  val_2 FROM table_2 WHERE val_2 = something)) */

INSERT INTO sections (retro_id, title, notes) VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 1'), 'Test Section 1', 'These are some notes');
INSERT INTO sections (retro_id, title, notes) VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 1'), 'Test Section 2', 'These are some notes');
INSERT INTO sections (retro_id, title, notes) VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 2'), 'Test Section 1', 'These are some notes');
INSERT INTO sections (retro_id, title, notes) VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 2'), 'Test Section 2', 'These are some notes');
