CREATE TABLE landMark (
id serial,
name varchar(50) NOT NULL,
description varchar NOT NULL,
img varchar,
operatingDays varchar NOT NULL, 
openingTime time NULL, 
closingTime time NULL,
venueType varchar,
location varchar NOT NULL,
rating int,
constraint pk_id primary key (id)
);