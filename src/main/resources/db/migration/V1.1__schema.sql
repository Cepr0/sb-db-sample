create sequence global_sequence increment by 10;

create table people (
  id      integer     not null constraint people_pkey primary key,
  version integer,
  name    varchar(32) not null,
  email   varchar(32) not null constraint uk_people_email unique,
  address jsonb       not null
);

create table cars (
  id        integer     not null constraint cars_pkey primary key,
  version   integer,
  brand     varchar(16) not null,
  model     varchar(16) not null,
  plate_num varchar(16) not null constraint uk_cars_plate_num unique,
  person_id integer     not null constraint fk_cars_person_id references people
);


