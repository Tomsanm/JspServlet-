CREATE DATABASE blog;

USE blog;

create table tb_user(
userName varchar(20) not null unique primary key,
passWorld varchar(50) not null ,
sex  enum('男','女') not null default '男',
QQ varchar(50) ,
email varchar(50) ,
lastLoginTime datetime ,
birthday datetime ,
state varchar(50) 
)ENGINE=INNODB DEFAULT CHARSET=UTF8;


create table tb_article_type(
id int ,
type_name varchar(50) ,
describle varchar(50) 
)ENGINE=INNODB DEFAULT CHARSET=UTF8;


create table tb_article_info(
id int,
title varchar(50) ,
openData datetime ,
keyWord varchar(50) ,
text1 text ,
type1 int    
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

create table tb_article_comment(
id int primary key,
commentName varchar(50) not null,
commentAim varchar(20) not null,
commentTime datetime not null,
commentText text 
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

create table tb_friends(
id int primary key,
friendName varchar(50) not null,
gypeLink varchar(100) not null,
addTime datetime not null
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

create table tb_friend_photo(
id int primary key,
photo_name varchar(20) not null,
describe_it varchar(50)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;





