create table if not exists subscription
(
    id                  uuid default gen_random_uuid() primary key,
    name                varchar(255) not null,
    level               integer not null
);

create table if not exists users
(
    id                  uuid default gen_random_uuid() primary key,
    name                varchar(255) not null,
    email               varchar(255) not null,
    subscription_id     varchar(255) not null,
    date_registered     date not null
);

create table if not exists trainings
(
    id                  uuid default gen_random_uuid() primary key,
    name                varchar(255) not null,
    type                varchar(255) not null,
    subscription_level  integer not null,
    date                date not null
);
