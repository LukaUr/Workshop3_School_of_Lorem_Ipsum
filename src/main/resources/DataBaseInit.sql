CREATE DATABASE Workshop3_school CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use Workshop3_school;

create table users_groups(
                             id int(11) auto_increment primary key ,
                             name varchar(256)
);

create table users(
                      id int(11) primary key auto_increment,
                      username varchar(255),
                      email varchar(255) unique ,
                      password varchar(245),
                      user_group_id int(11),
                      foreign key (user_group_id) references users_groups(id)
);

create table exercises(
                          id int(11) primary key auto_increment,
                          title varchar(255),
                          description text
);

create table solutions(
                          id int(11) auto_increment primary key ,
                          created datetime,
                          updated datetime,
                          description text,
                          exercise_id int(11) not null ,
                          user_id int(11) not null ,
                          foreign key (exercise_id) references exercises(id),
                          foreign key (user_id) references users(id)
);
