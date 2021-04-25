
create database AutomationTest
use AutomationTest
create table AppUser (
                         id int identity,
                         user_id int,
                         name nvarchar(400),
                         email varchar(400),
                         gender varchar(10),
                         status varchar(30),
                         created_at varchar(400),
                         update_at varchar(400)
                             primary key (id)
);