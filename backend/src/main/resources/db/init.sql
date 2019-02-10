create table foo( foo_id integer, foo_name varchar(255), primary key(foo_id));
create table foo_bar(foo_id integer, bar_id uuid, primary key(foo_id, bar_id));

alter table foo_bar add constraint foo_fk foreign key (foo_id) references foo (foo_id) ON DELETE CASCADE;