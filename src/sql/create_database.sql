/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  wlloyd
 * Created: Feb 4, 2017
 * 
 * Modified 2/27/2017
 * Author: Reid Stuberg
 */

create table users (
    username varchar(50),
    passwd varchar(50),
    email varchar(50),
    userid serial primary key,
    Fname varchar(50),
    Lname varchar(50)
);

create table shops (
    cid serial primary key,
    coffee_name varchar(50),
    coffee_address varchar(100),
    raw_review integer,
    phone varchar(20),
    website varchar(512)
);

create table review(
    date timestamp,
    text varchar(160),
    rating integer,
    cid integer,
    userid integer
);
