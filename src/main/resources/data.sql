create table person (
  id integer not null,
  name varchar(255) not null,
  location varchar(255),
  birth_date timestamp,
  primary key(id)
);

insert into person (id, name, location, birth_date)
values (10001, 'Józsi', 'Ferihegy', sysdate());

insert into person (id, name, location, birth_date)
values (10002, 'Feri', 'Máriakálnok', sysdate());

insert into person (id, name, location, birth_date)
values (10003, 'Gabi', 'Kálmánháza', sysdate());

insert into person (id, name, location, birth_date)
values (10004, 'Jani', 'Nyíregyháza', sysdate());

insert into person (id, name, location, birth_date)
values (10005, 'Tibi', 'Sóstóhegy', sysdate());

insert into course(id, name)
values (2, 'Feri');