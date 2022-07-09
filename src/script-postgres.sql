CREATE TABLE prodcuto (
	id SERIAL NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	precio FLOAT NOT NULL, 
	fecha_creacion DATE NOT NULL, 
	imagen VARCHAR(100) NULL DEFAILT NULL,
	codigo VARCHAR(7) NOT NULL, 
	PRIMARY KEY(id),
);
ALTER TABLE producto ADD CONSTRAINT  UN_producto_codigo unique (codigo);