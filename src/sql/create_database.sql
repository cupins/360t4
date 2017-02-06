/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  wlloyd
 * Created: Feb 4, 2017
 */

create table users (
    name varchar(40),
    age integer,
    userid serial primary key
);

create table messages (
    messageid serial primary key,
    userid integer,
    message varchar(255),
    dateadded timestamp
);

