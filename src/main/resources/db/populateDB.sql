DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;


INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (userid, description,datetime, calories) VALUES
  (100000, 'Завтрак',(TIMESTAMP '2018-03-20T07:36:38'), 500),
  (100000, 'Обед',(TIMESTAMP '2018-03-20T15:36:38'), 1000),
  (100000, 'Ужин', (TIMESTAMP '2018-03-20T20:36:38'),450),
  (100001, 'Завтрак',(TIMESTAMP '2018-03-20T07:36:38'), 500),
  (100001, 'Обед',(TIMESTAMP '2018-03-20T15:36:38'), 1000),
  (100001, 'Ужин',(TIMESTAMP '2018-03-20T20:36:38'), 550);