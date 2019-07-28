-- Profile Table --
insert into profile (id, status, cgpa, stream)
values (1001,1,7.8,'IT');
insert into profile (id, status, cgpa, stream)
values (1002,1,5.1,'EEE');
insert into profile (id, status, cgpa, stream)
values (1003,1,7.9,'IT');
insert into profile (id, status, cgpa, stream)
values (1004,1,9.0,'CSE');

-- Student Table --
insert into student (id, status, name, profile_id)
values (1,1,'Dave', 1001);
insert into student (id, status, name, profile_id)
values (2,1,'Remus', 1002);
insert into student (id, status, name, profile_id)
values (3,1,'Shane', 1003);
insert into student (id, status, name, profile_id)
values (4,1,'Jenna', 1004);

-- Course Table --
insert into course (id, name)
values (1, 'Code Java');
insert into course (id, name)
values (2, 'Spring');
