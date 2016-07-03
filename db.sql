
create sequence seq_users;
create sequence seq_message;
drop table users;
drop table message;

create table users (id number,uname varchar2(10),psd varchar2(10),birth date,grade number(2));
create table message (id number,title varchar2(10),content varchar2(900),u_id number,m_id number);

select * from users;
select * from message;

select m.id id,m.title title,u.uname uname from message m,users u where m.u_id=u.id
