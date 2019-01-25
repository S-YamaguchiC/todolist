create table users(
  id SERIAL NOT NULL UNIQUE ,
  userid varchar(16) NOT NULL UNIQUE PRIMARY KEY ,
  passwd varchar(32) NOT NULL
);

create table todos(
  userid varchar(16) REFERENCES users(userid) ON UPDATE CASCADE ON DELETE CASCADE ,
  title varchar(128) NOT NULL ,
  detail varchar(1024) ,
  post_time timestamp without time zone,
  last_update_time timestamp without time zone
);