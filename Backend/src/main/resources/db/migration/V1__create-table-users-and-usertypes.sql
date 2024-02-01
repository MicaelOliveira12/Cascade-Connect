    CREATE TABLE usertypes(
    id int NOT NULL auto_increment,
    type varchar (20),
    primary key (id));

    INSERT INTO usertypes (type) VALUES ('Administrator'),('Supervisor'),('Operator');

    CREATE TABLE users(
    id bigint not null auto_increment,
    user_name varchar (100) not null,
    user_email varchar(100) not null unique,
    user_password varchar(50) not null,
    user_type int not null,
    active_inactive ENUM ('ACTIVE','INACTIVE'),
    primary key (id),
    foreign key (user_type) references usertypes(id)
    );