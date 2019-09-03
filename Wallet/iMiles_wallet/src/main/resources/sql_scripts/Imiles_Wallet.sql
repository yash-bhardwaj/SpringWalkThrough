-- Table: public.imiles_wallet

-- DROP TABLE public.imiles_wallet;

CREATE TABLE public.imiles_wallet
(
    imiles_id bigint NOT NULL,
    creation_date timestamp without time zone,
    created_by character varying(20) COLLATE pg_catalog."default",
    last_updation_by character varying(20) COLLATE pg_catalog."default",
    last_updation_date timestamp without time zone,
    creditted_or_debitted character varying(255) COLLATE pg_catalog."default",
    gcid character varying(255) COLLATE pg_catalog."default" NOT NULL,
    imiles_count bigint,
    is_archive boolean DEFAULT false,
    is_deleted boolean DEFAULT false,
    is_latest boolean DEFAULT false,
    ride_id bigint,
    status character varying(255) COLLATE pg_catalog."default",
    total_imiles double precision,
    vin character varying(255) COLLATE pg_catalog."default" NOT NULL,
    is_expired boolean DEFAULT false,
    CONSTRAINT imiles_wallet_pkey PRIMARY KEY (imiles_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.imiles_wallet
    OWNER to postgres;
	
	
-- SEQUENCE: public.imiles_wallet_id_seq

-- DROP SEQUENCE public.imiles_wallet_id_seq;

CREATE SEQUENCE public.imiles_wallet_id_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.imiles_wallet_id_seq
    OWNER TO postgres;