CREATE TABLE subscription
(
    id                  uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name                VARCHAR NOT NULL,
    subscription_level  INTEGER NOT NULL
);

CREATE TABLE users
(
    id                  uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name                VARCHAR NOT NULL,
    email               VARCHAR NOT NULL,
    subscription_id     UUID NOT NULL,
    date_registered     TIMESTAMP without TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE trainings
(
    id                  uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name                VARCHAR NOT NULL,
    type                VARCHAR NOT NULL,
    subscription_level  INTEGER NOT NULL,
    training_date       TIMESTAMP without TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
