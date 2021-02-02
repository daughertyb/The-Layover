create table daysopen (
daysId serial,
landmarkid int,
monday varchar not null,
tuesday varchar not null,
wednesday varchar not null,
thursday varchar not null,
friday varchar not null,
saturday varchar not null,
sunday varchar not null,
constraint pk_daysid primary key(daysId),
Foreign key (landmarkid) references landmark(id)
);

insert into daysopen (landmarkid
,monday, tuesday, wednesday, thursday, friday,saturday, sunday)
values ((select id from landmark where name='Motown Museum'),
'open','open','open','open','open','close','close');   

insert into daysopen (landmarkid
,monday, tuesday, wednesday, thursday, friday,saturday, sunday)
values ((select id from landmark where name='Detroit Institute of Arts'),
'close','close','close','open','open','open','open');
