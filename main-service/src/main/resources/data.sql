INSERT INTO "organizations" ("name")
VALUES ('МГТУ Станкин');

INSERT INTO "organizations" ("name")
VALUES ('НИИ Арбуз');

INSERT INTO "organizations" ("name")
VALUES ('Научная контора');


INSERT INTO "users" ("email", "password", "name", "organization_id")
VALUES ('ivanov@yandex.ru', '$2a$10$dbgbu3GVTfcMpriZl7l9.OGrTPspkBPgGhnOKIW68BBVTfNC24MBy', 'Ivan Ivanov', 1);

INSERT INTO "users" ("email", "password", "name", "organization_id")
VALUES ('petrov@yandex.ru', 'test', 'Petr Petrov', 2);

INSERT INTO "users" ("email", "password", "name")
VALUES ('sidorov@yandex.ru', 'test', 'Sidor Sidorov');