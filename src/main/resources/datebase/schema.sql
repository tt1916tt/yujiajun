create database yujiajun DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;
create table user
(
    id                 bigint  primary key,
    user_no           char(19)   not null comment '用户编号 ',
    user_name         varchar(32)   not null comment '用户姓名 ',
    gmt_create         datetime     null,
    gmt_modified       datetime     null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

create table user_passwd
(
    id                 bigint  primary key,
    user_no           char(19)   not null comment '用户编号 ',
    passwd         varchar(32)   not null comment '用户密码 ',
    gmt_create         datetime     null,
    gmt_modified       datetime     null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表密码表';



create index idx_name
    on performer (name);

alter table performer
    add primary key (id);

create table test
(
    id           bigint                             not null comment '编号',
    gmt_create   datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    gmt_modified datetime default CURRENT_TIMESTAMP null comment '修改时间',
    constraint test_id_uindex
        unique (id)
)
    comment '测试表' collate = utf8mb4_bin;







