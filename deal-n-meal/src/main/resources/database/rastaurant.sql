create table restaurant(
                           restaurant_id serial primary key,
                           restaurant_name varchar(50) not null unique,
                           restaurant_description text,
                           restaurant_address text not null,
                           restaurant_phone varchar(20) not null,
                           restaurant_email varchar(50) not null,
                           owner_id integer not null references users(user_id)
);

create table tag(
                    tag_id serial primary key,
                    tag_name varchar(50) not null unique
);

create table restaurants_tags(
                                 restaurant_id integer not null references restaurant(restaurant_id),
                                 tag_id integer not null references tag(tag_id)
);

create table restaurant_menu(
                                menu_id serial primary key,
                                menu_type varchar(50) not null,
                                restaurant_id integer not null references restaurant(restaurant_id)
);

create table menu_item(
                          menu_item_id serial primary key,
                          menu_id integer not null references restaurant_menu(menu_id),
                          menu_item_name text not null,
                          menu_item_description text,
                          menu_item_price numeric(10,2) not null,
                          menu_item_weight text
);

create table comment(
                        comment_id serial not null,
                        header text not null,
                        body text not null,
                        rate integer not null,
                        publication_date date not null,
                        restaurant_id integer not null references restaurant(restaurant_id),
                        author_id integer not null references users(user_id)
);

