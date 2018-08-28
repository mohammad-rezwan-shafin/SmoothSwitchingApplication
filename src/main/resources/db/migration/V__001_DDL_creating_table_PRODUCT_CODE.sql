-- Table: product_code

-- DROP TABLE product_code;

CREATE TABLE product_code
(
  prod_code character varying(2) NOT NULL,
  description character varying(50),
  discount_code character varying(2) NOT NULL,
  CONSTRAINT product_code_pkey PRIMARY KEY (prod_code)
);
ALTER TABLE product_code OWNER TO ssapp;
