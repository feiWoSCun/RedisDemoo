INSERT INTO final_ssm.description (id, description, likes) VALUES (1, '哈哈哈哈我在学redis', 6);
INSERT INTO final_ssm.description (id, description, likes) VALUES (2, '哈哈哈我在学mysql', 4);
INSERT INTO final_ssm.description (id, description, likes) VALUES (3, '哈哈哈我在偷偷玩偷偷摆烂', 2);
INSERT INTO final_ssm.description (id, description, likes) VALUES (4, '我在学Java', 2);
create table if not exists description
(
    id          int          not null,
    description varchar(600) null,
    likes       int          not null
);

create table if not exists user
(
    id       int         not null,
    username varchar(10) null
);

