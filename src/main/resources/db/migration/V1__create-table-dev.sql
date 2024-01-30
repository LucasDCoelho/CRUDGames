create table dev (
        id bigint not null auto_increment,
        nome varchar(100) not null,
        dataFundacao Date not null,
        website varchar(255) not null,
        sede varchar(100) not null,

        primary key(id)
);