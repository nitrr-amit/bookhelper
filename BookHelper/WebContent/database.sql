drop table BookHelper_user_table;
create table BookHelper_user_table(
      name varchar2(20) not null,
	  mobile varchar2(15) not null,
	  email_id varchar2(30),
	  password varchar2(20) not null,
	  constraint user_pk1 primary key(email_id)
);

insert into BookHelper_user_table(name,mobile,email_id,password) values('amit','9031513545','amitkumarbargaway123@gmail.com','123');
commit;
----**************---------------------------------------
create table bh_book_table(
       id number(10) not null,
	  book_name varchar2(30) not null,
	  book_author varchar2(30)not null,
	 constraint bh_book_pk primary key(id)
);

-------------------
create sequence bh_seq start with 100;

insert into  bh_book_table(id,book_name,book_author) values(bh_seq.nextval,'cc','hc verma');
create table bh_book_table2(
       id number(10) not null,
	   email_id varchar2(30) not null,
	   price number(10,2) not null,
	  when_added date not null,
		approved varchar2(5) not null,
		rating number(2) not null,
	 constraint bh_book_fk foreign key(id) references bh_book_table(id),
	 constraint bh_user_fk foreign key(email_id) references BookHelper_user_table(email_id)
);

insert into  bh_book_table2(id,email_id,price,qnty,when_added) values(101,'amit',20.5,4,sysdate);




--------------------------
query

select email_id from bh_book_table2 where id=(select id from bh_book_table where book_name='cc1');


------------------------------------------------------------------
create table bh_image_table(
      id number(10),
	  email_id varchar2(30),
	  image1 blob,
	  image2 blob,
	  image3 blob,
	  constraint bh_image_fk1 foreign key(id) references bh_book_table(id),
	 constraint bh_image_fk2 foreign key(email_id) references BookHelper_user_table(email_id)
);




