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
address varchar,
latitude decimal,
longitude decimal,
thumbsup int,
thumbsdown int,
constraint pk_id primary key (id)
);



insert into landmark (name, description, img, operatingdays, openingtime, closingtime, 
venuetype, location, address, latitude, longitude, thumbsup, thumbsdown )
values ('Motown Museum', 
'the nickname given to Motowns first headquarters. 
A former photographers studio located at 2648 West Grand Boulevard in Detroit', 
'motownmuseum.jpg', 
'Monday -Friday', 
'10:00:00', 
'18:00:00',
'Museum', 
'Detroit',  
'2648 W Grand Blvd, Detroit, MI 48208',
'42.364141', '-83.088346', 12, 5);

insert into landmark (name, description, img, operatingdays, openingtime, closingtime, 
venuetype, location, address, latitude, longitude, thumbsup, thumbsdown )
values 
('Detroit Institute of Arts', 
'The Detroit Institute of Arts, located in Midtown Detroit, Michigan, 
has one of the largest and most significant art collections in the United States.', 
'detroitinstitute.jpg', 
'Wednesday -Sunday', 
'09:00:00', 
'18:00:00',
'Museum', 
'Detroit',
'5200 Woodward Ave, Detroit, MI 48202',
'42.3594', 
'-83.0645', 10, 3);     

insert into landmark (name, description, img, operatingdays, openingtime, closingtime, 
venuetype, location, address, latitude, longitude, thumbsup, thumbsdown )
values 
('Columbus Zoo and Aquarium', 
'Columbus Zoo and Aquarium is home to animals representing various species from around the globe. 
It is a recreational and education destination that includes Zoombezi Bay water 
park and a 18-hole safari golf club.', 
'columbuszoo.jpg', 
'Monday -Sunday', 
'10:00:00', 
'16:00:00',
'Zoo', 
'Columbus',
'4850 W Powell Rd, Powell, OH 43065',
'40.1538', 
'-83.1177', 49, 2);  


insert into landmark (name, description, img, operatingdays, openingtime, closingtime, 
venuetype, location, address, latitude, longitude, thumbsup, thumbsdown )
values 
('Franklin Park Conservatory and Botanical Gardens', 
'Franklin Park Conservatory and Botanical Gardens is a 
botanical garden and conservatory located in Columbus, Ohio. 
It is open daily and an admission fee is charged. Today, it is a
 horticultural and educational institution showcasing exotic plant 
collections, special exhibitions, and Dale Chihuly artworks. 
The conservatory contains more than 400 plant species.', 
'franklinpark.jpg', 
'Monday -Sunday', 
'10:00:00', 
'19:00:00',
'Park', 
'Columbus',
'1777 E Broad St, Columbus, OH 43203',
'39.965869', 
'-82.952827', 44, 5);  

insert into landmark (name, description, img, operatingdays, openingtime, closingtime, 
venuetype, location, address, latitude, longitude, thumbsup, thumbsdown )
values 
('Liberty Bell', 
'The Liberty Bell, previously called the State House 
Bell or Old State House Bell, is an iconic symbol of American independence, 
located in Philadelphia, Pennsylvania. Once placed in the steeple of the 
Pennsylvania State House, the bell today is located across the street in 
the Liberty Bell Center in Independence National Historical Park. ', 
'libertybell.jpg', 
'Monday -Sunday', 
'09:00:00', 
'19:00:00',
'Park', 
'Philadelphia',
'526 Market St, Philadelphia, PA 19106',
'39.94961', 
'-75.150282', 231, 3);  


insert into landmark (name, description, img, operatingdays, openingtime, closingtime, 
venuetype, location, address, latitude, longitude, thumbsup, thumbsdown )
values 
('The Franklin Institute', 
'The Franklin Institute is a science and technology center 
that primarily focuses on promoting public understanding of science. 
The institute operates a science museum, which displays exhibits on 
subjects such as science and industry, physics, astronomy, and 
history and The Tuttleman IMAX Theater.', 
'franklininstitute.jpg', 
'Monday -Sunday', 
'10:00:00', 
'19:00:00',
'Museum', 
'Philadelphia',
'222 N 20th St, Philadelphia, PA 19103',
'39.9580', 
'-75.1724', 144, 2);  


