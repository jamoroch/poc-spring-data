create sequence hibernate_sequence start 1 increment 1
create table foo (foo_id int4 not null, foo_name varchar(255), createdDate timestamp not null, primary key (foo_id))
create table foo_bar (foo_id int4 not null, bar_id uuid, primary key(bar_id, foo_id))
alter table foo_bar add constraint foo_fk foreign key (foo_id) references foo
