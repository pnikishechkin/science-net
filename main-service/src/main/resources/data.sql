INSERT INTO "organizations" ("name")
VALUES ('МГТУ Станкин');

INSERT INTO "organizations" ("name")
VALUES ('НИИ Арбуз');

INSERT INTO "organizations" ("name")
VALUES ('Научная контора');


INSERT INTO "users" ("email", "name", "organization_id")
VALUES ('ivanov@yandex.ru', 'Ivan Ivanov', 1);

INSERT INTO "users" ("email", "name", "organization_id")
VALUES ('petrov@yandex.ru', 'Petr Petrov', 2);

INSERT INTO "users" ("email", "name")
VALUES ('sidorov@yandex.ru', 'Sidor Sidorov');