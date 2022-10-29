CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
create table if not exists flyway_schema_history
(
    installed_rank uuid default uuid_generate_v4() not null
        constraint flyway_schema_history_pk
            primary key,
    version varchar(50),
    description varchar(200) not null,
    type varchar(20) not null,
    script varchar(1000) not null,
    checksum integer,
    installed_by varchar(100) not null,
    installed_on timestamp default now() not null,
    execution_time integer not null,
    success boolean not null
);



create index if not exists flyway_schema_history_s_idx
    on flyway_schema_history (success);



create table if not exists contacts
(
    id uuid default uuid_generate_v4() not null
        constraint contacts_pk
            primary key,
    index integer,
    name varchar(255),
    data varchar(255)
);

insert into contacts(id, index, name, data) values ('295c4a70-f4ca-4e49-8cd7-3542c53f4925', 1, 'PHONE','+7 (962) 595-73-09');
insert into contacts(id, index, name, data) values ('57ebe16d-f03c-4042-8383-af34d6eb5797', 2, 'TELEGRAM','@Vladimir_Ykm');
insert into contacts(id, index, name, data) values ('2873a8ec-cbdd-4d3c-947f-f78d598862fc', 3, 'E-MAIL','yakimovvn@bk.ru');
insert into contacts(id, index, name, data) values ('5f90ff46-8310-498f-824c-cc4acdb1d056', 4, 'ADDRESS','Moscow, Russia');

create table if not exists messages
(
    id uuid default uuid_generate_v4() not null
            constraint messages_pk
                primary key,
    index integer,
    user_name varchar(255),
    email varchar(255),
    topic varchar(255),
    message varchar(1000)
);

create table if not exists jobs(
    id uuid default uuid_generate_v4() not null
            constraint jobs_pk
                primary key,
    index integer,
    name varchar(255),
    title varchar(255),
    work_date varchar(255),
    description varchar(1000),
    responsibilities varchar(4000)
);

insert into jobs(index, name, title, work_date, description, responsibilities) values (
    1,
    'Sberbank - Technologies',
    'HEAD ENGINEER',
     'AUGUST 2020 - PRESENT', 'I work on a project that is actively used in the bank to access big data. The main task of the service is to overwrite, encrypt and tokenize fields to which the user does not have access. At the moment, the cluster is deployed on 120 hosts and proxies petabytes of data every day. On the project I am involve in:',
     'Creation of complex features that affect the global behavior of the system. As well as features with a critical priority level.;Team management, creation, distribution and supervision of tasks, conduction of Code reviews, mentorship of interns. Task planning, labour cost estimation.;Replacement of team leader during his absence.;Management of releases in Jira. Conduction of acceptance test meetings, protection of the implementation of features from the Cyber Security Experts. Supervision of release installation.;Brief analysis of critical incidents. (If necessary, we roll out the hotfix release in two hours.);Load testing procedures;Creation of ansible pipeline.;Writing of docker files for functional testing environment.'
);

insert into jobs(index, name, title, work_date, description, responsibilities) values (
    2,
    'ELAR Corporation',
    'DEVELOPER',
    'January 2020 - August 2020',
    null,
   'Development of the Elar-context system (monolith).;Setting up and maintaining a context based on Tomcat with an environment (Elasticsearch, postgresql, OracleDb) on OS Linux.;Support, refinement of the Spring backend of the National Electronic Library.'
);

insert into jobs(index, name, title, work_date, description, responsibilities) values (
    3,
    'Radius',
    'DEVELOPER',
    'August 2019 - December 2019',
    null,
    'Development of a batch data loading framework.;Writing modules for launching data upload processes using Spark, Hive, Sqoop.'
);

create table if not exists skills
(
    id uuid default uuid_generate_v4() not null
        constraint skills_pk
            primary key,
    index integer,
    skill_name varchar(255)
);

insert into skills(index, skill_name) values (1, 'Java'),
                                       (2, 'Hadoop, Spark, Hive, Claudera'),
                                       (3, 'Spring: Boot, Security, Web, JPA'),
                                       (4, 'Jenkins, Ansible'),
                                       (5, 'SQL, PostgreSQL, Flyway'),
                                       (6, 'OOP, SOLID, REST, SOUP'),
                                       (7, 'JUnit, Mockito '),
                                       (8, 'Linux, bash, Python scripts'),
                                       (9, 'Kubernetes, Docker'),
                                       (10, 'Git, Maven, Jira, JProfiler'),
                                       (11, 'Team management'),
                                       (12, 'Task scheduling');


create table if not exists languages
(
    id uuid default uuid_generate_v4() not null
        constraint languages_pk
            primary key,
    index integer,
    language_name varchar(255)
);

insert into languages(index, language_name) values (1, 'Russian - native'),
                                            (2, 'English - B1(intermediate), fluent');

create table if not exists educations
(
    id uuid default uuid_generate_v4() not null
        constraint educations_pk
            primary key,
    index integer,
    education varchar(255)
);

insert into educations(index, education) values (1, 'National Research Mordovian State University named after N.P. Ogarova, Saransk, Faculty of Electronic Engineering, Automated systems data processing and control. (2005 - 2010), Master');



