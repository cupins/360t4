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
    password varchar(50),
    email varchar(50),
    userid serial primary key,
    Fname varchar(50),
    Lname varchar(50),
    utype varchar(1)
);

create table shops (
    cid serial primary key,    
    coffee_name varchar(50),
    city varchar(30),
    stat varchar(30),
    zip varchar(20),
    phone varchar(13),
    opentime int,
    clostime int
);

create table reviews(
    date timestamp,
    text varchar(160),
    rating integer,
    cid integer,
    userid integer,
    rid serial primary key
);

create table share(
    name varchar(50),
    city varchar(30),
    state varchar(30),
    zip varchar(10),
    phone varchar(13),
    opentime int,
    closetime int,
    sid serial primary key
);
    