--MySQL数据库建库建表
--显示所有数据库
show databases;
--删除已有数据库 fxwt
--drop database  if exists fxwt;
--如果不存在数据库fxwt，则创建
create database fxwt character set utf8 if not exists fxwt;
--转到数据库 fxwt
use fxwt;
--显示所有表格
show tables;
--删除已有 user表格
--drop table user if exists;
--创建user表格
create table user(
	userName String PRIMARY KEY,
	ID
	
	
	);