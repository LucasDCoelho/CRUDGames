create table console (
                     id bigint not null auto_increment,
                     nome varchar(100) not null,
                     dataLancamento Date not null,
                     empresa varchar(255) not null,
                     ativo tinyint default 1,

                     primary key(id)
);