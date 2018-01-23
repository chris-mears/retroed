DELETE FROM items;
DELETE FROM sections;
DELETE FROM retros;

INSERT INTO retros (name, body) VALUES ('Test Retro 1', 'This is a test Retro');
INSERT INTO retros (name, body) VALUES ('Test Retro 2', 'This is the second test Retro');

INSERT INTO sections (retro_id, title, notes) VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 1'), 'Test Section 1', 'These are some notes');
INSERT INTO sections (retro_id, title, notes) VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 1'), 'Test Section 2', 'These are some notes');
INSERT INTO sections (retro_id, title, notes) VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 2'), 'Test Section 1', 'These are some notes');
INSERT INTO sections (retro_id, title, notes) VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 2'), 'Test Section 2', 'These are some notes');

INSERT INTO items (retro_id, section_id, title, body, item_type)
    VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 1'), (SELECT section_id from sections JOIN retros ON sections.retro_id = retros.retro_id WHERE sections.title = 'Test Section 1' AND retros.name = 'Test Retro 1'), 'Test Note 1', 'This is a note', 'note');
INSERT INTO items (retro_id, section_id, title, body, item_type)
VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 1'), (SELECT section_id from sections JOIN retros ON sections.retro_id = retros.retro_id WHERE sections.title = 'Test Section 1' AND retros.name = 'Test Retro 1'), 'Test Task 1', 'This is a task', 'task');

INSERT INTO items (retro_id, section_id, title, body, item_type)
VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 1'), (SELECT section_id from sections JOIN retros ON sections.retro_id = retros.retro_id WHERE sections.title = 'Test Section 2' AND retros.name = 'Test Retro 1'), 'Test Note 2', 'This is a note', 'note');
INSERT INTO items (retro_id, section_id, title, body, item_type)
VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 1'), (SELECT section_id from sections JOIN retros ON sections.retro_id = retros.retro_id WHERE sections.title = 'Test Section 2' AND retros.name = 'Test Retro 1'), 'Test Task 2', 'This is a task', 'task');

INSERT INTO items (retro_id, section_id, title, body, item_type)
VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 2'), (SELECT section_id from sections JOIN retros ON sections.retro_id = retros.retro_id WHERE sections.title = 'Test Section 1' AND retros.name = 'Test Retro 2'), 'Test Note 1', 'This is a note', 'note');
INSERT INTO items (retro_id, section_id, title, body, item_type)
VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 2'), (SELECT section_id from sections JOIN retros ON sections.retro_id = retros.retro_id WHERE sections.title = 'Test Section 1' AND retros.name = 'Test Retro 2'), 'Test Task 1', 'This is a task', 'task');

INSERT INTO items (retro_id, section_id, title, body, item_type)
VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 2'), (SELECT section_id from sections JOIN retros ON sections.retro_id = retros.retro_id WHERE sections.title = 'Test Section 2' AND retros.name = 'Test Retro 2'), 'Test Note 2', 'This is a note', 'note');
INSERT INTO items (retro_id, section_id, title, body, item_type)
VALUES ((SELECT retro_id from retros WHERE name = 'Test Retro 2'), (SELECT section_id from sections JOIN retros ON sections.retro_id = retros.retro_id WHERE sections.title = 'Test Section 2' AND retros.name = 'Test Retro 2'), 'Test Task 2', 'This is a task', 'task');
