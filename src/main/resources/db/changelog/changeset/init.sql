--liquibase formatted sql
--changeset user:Mike
--preconditions onFail:CONTINUE onError:CONTINUE

create table if not exists books
(
    id          int primary key generated always as identity,
    book_title  varchar(255) not null,
    book_author varchar(255) not null,
    book_price  numeric      not null
);

-- CREATE TABLE IF NOT EXISTS version_release
-- (
--     id          serial PRIMARY KEY,
--     start_date  date,
--     finish_date date
-- );
--
-- CREATE TABLE IF NOT EXISTS projectPostRequestDto
-- (
--     id   serial PRIMARY KEY,
--     name varchar(60)
-- );
--
-- CREATE TABLE IF NOT EXISTS board
-- (
--     id         serial PRIMARY KEY,
--     project_id int REFERENCES projectPostRequestDto
-- );
--
-- CREATE TABLE IF NOT EXISTS task
-- (
--     id                 serial PRIMARY KEY,
--     name               varchar(255),
--     status             character varying,
--     author_id          int REFERENCES employee,
--     developer_id       int REFERENCES employee,
--     version_release_id int REFERENCES version_release,
--     board_id           int REFERENCES board
-- );

--rollback drop table employee, version_release, projectPostRequestDto, board, task;
