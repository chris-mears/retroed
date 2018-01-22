create table retros
(
   retro_id SERIAL PRIMARY KEY,
   name varchar(255) not null,
   body TEXT
);

create table sections
(
  section_id SERIAL PRIMARY KEY,
  retro_id INTEGER NOT NULL REFERENCES retros(retro_id),
  title varchar(255) NOT NULL,
  notes TEXT
);

CREATE TYPE kind AS ENUM ('note', 'task');
CREATE TABLE items
(
  item_id SERIAL PRIMARY KEY,
  retro_id INTEGER NOT NULL REFERENCES  retros(retro_id),
  section_id INTEGER NOT NULL REFERENCES sections(section_id),
  title VARCHAR(255) NOT NULL,
  body TEXT,
  item_type kind,
  due_date TIMESTAMP WITH TIME ZONE
);