insert into profile(id, graduation, stream, cgpa)
values (1, 'Bachelors Degree', 'IT', 7.8);
insert into profile(id, graduation, stream, cgpa)
values (2, 'Bachelors Degree', 'CSA', 8.2);
insert into profile(id, graduation, stream, cgpa)
values (3, 'Post Graduation', 'Computer Science', 9.0);

insert into student (id, status, name, profile_id)
values (1,1,'Dave',1);
insert into student (id, status, name, profile_id)
values (2,1,'Marcus', 2);
insert into student (id, status, name, profile_id)
values (3,1,'Johnathan', 3);

SELECT s.ID, s.NAME, p.GRADUATION, p.CGPA, p.STREAM FROM STUDENT s inner join PROFILE p on s.PROFILE_ID=p.ID where s.STATUS=1;
