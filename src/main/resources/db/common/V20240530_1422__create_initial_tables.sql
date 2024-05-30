create table subscription
(
    id                  uuid default gen_random_uuid() primary key,
    name                varchar(255) not null,
    subscription_level  integer not null
);

create table users
(
    id                  uuid default gen_random_uuid() primary key,
    name                varchar(255) not null,
    email               varchar(255) not null,
    subscription_id     UUID not null,
    date_registered     timestamp without time zone default current_timestamp
);

create table trainings
(
    id                  uuid default gen_random_uuid() primary key,
    name                varchar(255) not null,
    type                varchar(255) not null,
    subscription_level  integer not null,
    training_date       timestamp without time zone default current_timestamp
);
