DELETE FROM databasechangelog;

-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    user_id bigint NOT NULL,
    user_name character varying(255) COLLATE pg_catalog."default",
    version integer NOT NULL,
    token_token_id bigint,
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    CONSTRAINT fkpagtcxr7xo3clvdif9grb08y FOREIGN KEY (token_token_id)
        REFERENCES public.token (token_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;