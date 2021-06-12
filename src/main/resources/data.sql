INSERT INTO TB_EVENTS (name,description,start_date, end_date,start_time,end_time,email) VALUES ('nereu','aaaa','2004-01-12','2009-02-09','04:00:00','12:00:00','nereu@hotmail.com');
INSERT INTO TB_EVENTS(name,description,start_date, end_date,start_time,end_time,email) VALUES ('derik','bbbb','2001-03-08','2011-07-09','19:00:00','22:00:00','derik.gu@hotmail.com');
INSERT INTO TB_EVENTS (name,description,start_date, end_date,start_time,end_time,email) VALUES ('carlos','cccc','2011-03-29','2013-05-21','07:00:00','13:00:00','carlos.gu@hotmail.com');

INSERT INTO TB_PLACE  (address, name) VALUES ('rua 15 de junho','extra');
INSERT INTO TB_PLACE  (address, name) VALUES ('rua joao de almeida','mc donalds');
INSERT INTO TB_PLACE  (address, name) VALUES ('rua barao de tatui','iguatemi');

--ADMIN
INSERT INTO TB_BASE (email, name) VALUES ('zyx@gmail.com','igor');
INSERT INTO TB_BASE  (email, name) VALUES ('tereza@hotmail.com','tereza');
INSERT INTO TB_BASE  (email, name) VALUES ('yago@gmail.com','yago');

--Attendess
INSERT INTO TB_BASE (email, name) VALUES ('atten@gmail.com','atten');
INSERT INTO TB_BASE  (email, name) VALUES ('atten123@','atten123');
INSERT INTO TB_BASE  (email, name) VALUES ('att234@gmail.com','att234');

INSERT INTO TB_ADMIN (phone_number,USERBASE_ID) VALUES('15974018866',1);
INSERT INTO TB_ADMIN (phone_number,USERBASE_ID) VALUES('15974017451',2);
INSERT INTO TB_ADMIN (phone_number,USERBASE_ID) VALUES('15974044184',3);

INSERT INTO TB_ATTENDESS (balance, USERBASE_ID) VALUES(50,4);
INSERT INTO TB_ATTENDESS (balance, USERBASE_ID) VALUES(130,5);
INSERT INTO TB_ATTENDESS (balance, USERBASE_ID) VALUES(458,6);