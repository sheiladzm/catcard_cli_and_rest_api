BEGIN TRANSACTION;

DROP TABLE IF EXISTS catcards;

CREATE TABLE catcards (
  id serial PRIMARY KEY,
  name varchar(256) NOT NULL,    -- cat name
  img_url varchar(256) NOT NULL,   -- image URL
  fact varchar(1000) NOT NULL,       -- Cat Fact
  caption varchar(256) NOT NULL    -- User-provided caption
);

insert into catcards(name, img_url, fact, caption)
values ('Garfield',
'https://www.tuxedo-cat.co.uk/wp-content/uploads/2020/02/garfield.jpg?ezimgfmt=rs:256x349/rscb1/ng:webp/ngcb1',
'likes lasagna',
'Garfield with crossed arms');

insert into catcards(name, img_url, fact, caption)
values('Chesire Cat',
'https://static.wikia.nocookie.net/disney/images/e/e1/Cheshire_Cat_KHREC.png/revision/latest?cb=20140609163354',
'can turn invisible',
'chesire flying'
);

insert into catcards(name, img_url, fact, caption)
values (
'Tardar Sauce',
'https://media.wired.com/photos/5cdefc28b2569892c06b2ae4/master/w_2560%2Cc_limit/Culture-Grumpy-Cat-487386121-2.jpg',
'knows how to frown',
'grumpy cat'
);

COMMIT TRANSACTION;
