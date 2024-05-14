--SET UPDATE RULE AND DELETE RULE OF SUBJECT TO CASCADE
--SET DELETE RULE OF ACCOUNT PK TO CASCADE

drop database enrollment
create database enrollment

use enrollment

create table ACCOUNT(
	UserID int primary key identity(1, 1),
	Username varchar(30),
	UserPassword varchar(30),
	UserBlocked varchar(10) default 'false',
	Email varchar(50),
	UserDeleted varchar(10) default 'false',
	UserType varchar(30)

	constraint usertype_chk CHECK (userType in ('student', 'professor', 'dean', 'administrator'))
)

create table FORGOT_PASSWORD(
	UserID int,
	SecurityQuestion varchar(90),
	Answer varchar(90)

	constraint fo_userid_fk foreign key (UserID) references ACCOUNT(UserID)
)

create table COLLEGE(
	ColCode varchar(30) primary key,
	ColName varchar(90)
)

create table COURSE(
	CourseID varchar(30) primary key,
	CourseName varchar(90),
	Curriculum varchar(50),
	ColCode varchar(30),

	constraint col_colcode_fk foreign key (ColCode) references COLLEGE(ColCode)
)

create table STUDENT(
	StudID int primary key identity (2024000001, 1),
	FName varchar(30),
	MName varchar(30),
	LName varchar(30),
	YearLevel int default '1',
	Section varchar(30),
	EnrollmentStatus varchar(30) default 'unenrolled',
	Campus varchar(50),
	UserID int,
	CourseID varchar(30)

	constraint st_userid_fk foreign key(UserID) references ACCOUNT(UserID),
	constraint st_courseid_fk foreign key(CourseID) references COURSE(CourseID)
)

create table ENROLLMENT(
	EnrollmentID int primary key identity(20240001, 1),
	EnrollmentDate datetime2,
	StudID int,
	CourseID varchar(30),
	
	constraint en_studid_fk foreign key (StudID) references STUDENT(StudID),
	constraint en_courseid_fk foreign key (CourseID) references COURSE(CourseID)
)

create table FACULTY(
	EmpID int primary key identity(8001, 1),
	FName varchar(30),
	MName varchar(30),
	LName varchar(30),
	Position varchar(30),
	EmpRank varchar(50),
	SupervisorID int,
	ColCode varchar(30),
	UserID int

	constraint fa_supervisorid_fk foreign key(SupervisorID) references FACULTY(EmpID),
	constraint fa_userid_fk foreign key(UserID) references ACCOUNT(UserID),
	constraint fa_colcode_fk foreign key(ColCode) references COLLEGE(ColCode)
)

create table COURSE_SUBJECT(
	SubjectCode varchar(30) primary key,
	SubjectTitle varchar(90),
	Lecture int,
	Lab int,
	Credit int,
	Schedule varchar(90),
	CourseID varchar(30)

	constraint cs_courseid_fk foreign key (CourseID) references COURSE(CourseID)
)

create table ENROLLED_SUBJECT(
	StudID int,
	SubjectCode varchar(30)

	constraint ensu_studid_subjectcode_pk primary key(StudID, SubjectCode),
	constraint ensu_userid_fk foreign key (StudID) references STUDENT(StudID),
	constraint ensu_subjectcode_fk foreign key (SubjectCode) references COURSE_SUBJECT(SubjectCode)
)

create table FACULTY_SUBJECT(
    EmpID int,
    SubjectCode varchar(30),
	SupervisorID int

	constraint fs_pk primary key (EmpID, SubjectCode, SupervisorID),
    constraint fs_empid_fk foreign key (EmpID) references FACULTY(EmpID),
    constraint fs_subjectcode_fk foreign key (SubjectCode) references COURSE_SUBJECT(SubjectCode),
	constraint cs_supervisorid_fk foreign key (SupervisorID) references FACULTY(EmpID)
);

create table USER_LOG(
	ActionID int primary key identity(1, 1),
	UserID int,
	UserAction varchar(90),
	ActionDate datetime2,

	constraint ul_userId_fk foreign key(UserID) references ACCOUNT(UserID)
)

insert into ACCOUNT (username, userPassword, userType, userBlocked)
values ('jad', 'jad', 'administrator', 'false'),
('test', 'test', 'student', 'true'),
('1', '1', 'dean', 'false'),
('2', '2', 'professor', 'false'),
('3', '3', 'professor', 'false'),
('4', '4', 'professor', 'false'),
('5', '5', 'professor', 'false'),
('6', '6', 'professor', 'false')

/*
insert into ACCOUNT values
('a', 'a', 'false', 'a@a.com', 'false', 'student'),
('w', 'w', 'false', 'w@w.com', 'false', 'student'),
('e', 'e', 'true', 'e@e.com', 'false', 'student')
*/

insert into ACCOUNT (Username, UserPassword, UserBlocked, Email, UserType) values
('mora', 'mora', 'false', 'mora@mora.com', 'administrator')

insert into COLLEGE
values ('CICT', 'College of Information and Communications Technology'),
('CON', 'College of Nursing')

insert into COURSE
values ('BSIT', 'Bacherlor of Science in Information Technology', 'BSIT (2021-2023)', 'CICT'),
('BSIS', 'Bacherlor of Science in Information System', 'BSIS (2018-2020)', 'CICT')

insert into FACULTY (FName) values
('Leon'),
('Cheska'),
('Mario'),
('Susan'),
('Anthony'),
('John')

update FACULTY set 
MName = 'Zachary', LName = 'Limenedes', Position = 'Dean', EmpRank = 'Prof V', SupervisorID = '8002', ColCode = 'CICT', UserID = '3'
where EmpID = '8001'

update FACULTY set 
MName = 'Evangelista', LName = 'De Jesus', Position = 'Asst Dean', EmpRank = 'Prof IV', SupervisorID = '8001', ColCode = 'CICT', UserID = '4'
where EmpID = '8002'

update FACULTY set 
MName = 'Bautista', LName = 'Manlapaz', Position = 'Faculty', EmpRank = 'Instructor IV', SupervisorID = '8001', ColCode = 'CICT', UserID = '5'
where EmpID = '8003'

update FACULTY set 
MName = 'Roque', LName = 'Cruz', Position = 'Faculty', EmpRank = 'Instructor I', SupervisorID = '8001', ColCode = 'CICT', UserID = '6'
where EmpID = '8004'

update FACULTY set 
MName = 'Santos', LName = 'Lopez', Position = 'Faculty', EmpRank = 'Instructor II', SupervisorID = '8001', ColCode = 'CICT', UserID = '7'
where EmpID = '8005'

update FACULTY set 
MName = 'Quervo', LName = 'Rodriguez', Position = 'Faculty', EmpRank = 'Instructor III', SupervisorID = '8001', ColCode = 'CICT', UserID = '8'
where EmpID = '8006'

/*
insert into FACULTY (FName, MName, LName, Position, EmpRank, SupervisorID, ColCode, userID)
values 
('Cheska', 'Evangelista', 'De Jesus', 'Asst Dean', 'Prof IV', 1001, 'CICT', '7'),
('Leon', 'Zachary', 'Limenedes', 'Dean', 'Prof V', 1002, 'CICT', '8'),
('Mario', 'Bautista', 'Manlapaz', 'Faculty', 'Instructor IV', 1005, 'CICT', '4'),
('Susan', 'Roque', 'Cruz', 'Faculty', 'Instructor I', 1005, 'CICT', '5'),
('Anthony', 'Santos', 'Lopez', 'Faculty', 'Instructor II', 1005, 'CICT', '6'),
('John', 'Quervo', 'Rodriguez', 'Faculty', 'Instructor III', 1005, 'CICT', '3')
*/

insert into COURSE_SUBJECT
values ('IT-206', 'Advanced Database Systems', '2', '1', '3', 'T 1:00 PM - 4:00 PM', 'BSIT'),
('IT-207', 'Object Oriented Programming', '2', '1', '3', 'F 10:00 AM - 1:00 PM', 'BSIT'),
('IT-208', 'Platform Technologies', '2', '1', '3', 'F 7:00 AM - 10:00 AM', 'BSIT'),
('IT-209', 'Interactive Systems and Technologies', '2', '1', '3', 'TH 2:00 PM - 5:00 PM', 'BSIT'),
('IT-210', 'Networking 2', '2', '1', '3', 'TH 10:00 AM - 1:00 PM', 'BSIT')

insert into FACULTY_SUBJECT values
('8001', 'IT-206', '8001'),
('8002', 'IT-206', '8001'),
('8002', 'IT-207', '8001'),
('8003', 'IT-207', '8001'),
('8004', 'IT-208', '8001'),
('8002', 'IT-209', '8001'),
('8003', 'IT-209', '8001'),
('8004', 'IT-209', '8001'),
('8005', 'IT-210', '8001')


select * from ACCOUNT
select * from STUDENT
select * from FORGOT_PASSWORD
select * from COURSE_SUBJECT
	
select * from ACCOUNT
delete from account where userid = 13

select CS.SubjectCode, CS.SubjectTitle, CS.Lecture, CS.Lab, CS.Credit, CS.Schedule from 
FACULTY_SUBJECT FS inner join FACULTY FA
on FS.SupervisorID = FA.EmpID inner join COURSE_SUBJECT CS
on CS.SubjectCode = FS.SubjectCode
where CS.CourseID = 'BSIT'

select distinct CS.SubjectCode, CS.SubjectTitle, CS.Lecture, CS.Lab, CS.Credit, CS.Schedule from 
COURSE_SUBJECT CS inner join FACULTY_SUBJECT FS 
on CS.SubjectCode = FS.SubjectCode inner join FACULTY FA 
on FS.SupervisorID = FA.EmpID 
where CS.CourseID = 'BSIT' 
AND FA.EmpID = '8001';

select * from STUDENT
select * from ENROLLED_SUBJECT

select * from ACCOUNT
select * from FACULTY
	
select * from FACULTY_SUBJECT

update ACCOUNT set UserDeleted = 'true' where UserID= 10;
update COURSE_SUBJECT set SubjectCode = 'meowski' where SubjectCode = 'nyawski 201'

select CourseID from 
COURSE_SUBJECT CS inner join FACULTY_SUBJECT FS
on CS.SubjectCode = FS.SubjectCode inner join FACULTY FA
on FS.EmpID = FA.EmpID
where FS.SupervisorID = '8001' AND FA.UserID = '3'

--where SubjectCode =  ''(select distinct SubjectCode from FACULTY_SUBJECT where SupervisorID = '8001')

select distinct CS.SubjectCode, CS.SubjectTitle, CS.Lecture, CS.Lab, CS.Credit, CS.Schedule from 
FACULTY FA inner join FACULTY_SUBJECT FS
on FA.EmpID = FS.SupervisorID inner join COURSE_SUBJECT CS
on FS.SubjectCode = CS.SubjectCode

select CourseID, SupervisorID from COURSE_SUBJECT where SupervisorID = (select EmpID from FACULTY where UserID = 3)



select section
from STUDENT S inner join ENROLLED_SUBJECT E
on S.StudID = E.StudID


select FS.SubjectCode, CS.SubjectTitle, CS.Lecture, CS.Lecture, CS.Lab, CS.Schedule
from FACULTY_SUBJECT FS inner join COURSE_SUBJECT CS
on FS.SubjectCode = CS.SubjectCode
where EmpID = 8002

update account set UserDeleted = 'false' where userId = 16
select UserID from ACCOUNT where UserDeleted = 'true'

select * from ACCOUNT
select * from STUDENT
select * from ENROLLMENT
select * from ENROLLED_SUBJECT

select studid from STUDENT where studid = (select StudID from ENROLLED_SUBJECT)
select * from COURSE_SUBJECT where SupervisorID = (select EmpID from FACULTY where UserID = 3)

select * from COLLEGE
select * from COURSE
select * from COURSE_SUBJECT
select * from ACCOUNT
select UserID from ACCOUNT where UserType = 'student' and UserDeleted = 'false'
delete from ACCOUNT where UserID = '15'
select StudID, FName, MName, LName, YearLevel, Section, EnrollmentStatus, Campus, CourseID from STUDENT
select * from STUDENT
select * from USER_LOG
select * from USER_LOG where UserAction like '%log%'
SELECT * FROM sys.dm_exec_sessions WHERE database_id = DB_ID('enrollment');

UPDATE ACCOUNT set UserDeleted = 'false' WHERE UserID = '1'
UPDATE ACCOUNT set UserDeleted = 'false' WHERE UserID = '12'

UPDATE ACCOUNT set userBlocked = 'true' WHERE username = 'test'
UPDATE ACCOUNT set userBlocked = 'false' WHERE username = 'jad'

delete from ACCOUNT where UserID = 6

alter table USER_LOG
drop column failCount