CREATE DATABASE ecommerce WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'es_PE.UTF-8';


ALTER DATABASE ecommerce OWNER TO postgres;

\connect ecommerce

CREATE TABLE users{
	id serial PRIMARY KEY,
	user VARCHAR ( 50 ) UNIQUE NOT NULL,
	password VARCHAR ( 50 ) NOT NULL,
}


INSERT INTO public.users (id, usr, password) VALUES (1, 'Julian', 'J2021');
INSERT INTO public.users (id, usr, password) VALUES (3, 'Luisa', 'M2021');
INSERT INTO public.users (id, usr, password) VALUES (4, 'benito', 'B2021');
INSERT INTO public.users (id, usr, password) VALUES (5, 'Maria', 'E2021');
INSERT INTO public.users (id, usr, password) VALUES (2, 'Jose', 'pepe');
