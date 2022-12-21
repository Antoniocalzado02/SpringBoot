create database miPrimerSpringCalzadoAntonio;

GRANT ALL PRIVILEGES ON miPrimerSpringCalzadoAntonio.* TO 'calzadoAntonio'@'%' identified by 'calzadoAntonio';

CREATE TABLE miPrimerSpringCalzadoAntonio.USUARIO (
username VARCHAR(50) PRIMARY KEY,
contrasena VARCHAR(50),
nombre VARCHAR(50),
email VARCHAR(50),
es_admin VARCHAR(50)
);


CREATE TABLE miPrimerSpringCalzadoAntonio.PEDIDO(
id int AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50),
    fecha DATETIME,
    iva int,
CONSTRAINT FK1 FOREIGN KEY (username) REFERENCES USUARIO(username) ON DELETE CASCADE
);


CREATE TABLE miPrimerSpringCalzadoAntonio.CATEGORIA(
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(40),
descripcion VARCHAR(500)
);


CREATE TABLE miPrimerSpringCalzadoAntonio.ARTICULO (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50),
description TEXT,
price DECIMAL(5,2),
    stock int,
id_categoria INT,
CONSTRAINT FK_ARTICLES FOREIGN KEY (id_categoria) REFERENCES miTiendaSpringGomezJavi.CATEGORIA(id) ON DELETE CASCADE
);


CREATE TABLE miPrimerSpringCalzadoAntonio.PEDIDO_ARTICULO(
id_pedido int,
id_articulo int,
cantidad int,
CONSTRAINT PK_PEDIDO_ARTICULO PRIMARY KEY (id_pedido,id_articulo),
CONSTRAINT FK1_PEDIDO_ARTICULO FOREIGN KEY (id_pedido) REFERENCES PEDIDO(id) ON DELETE CASCADE,
CONSTRAINT FK2_PEDIDO_ARTICULO FOREIGN KEY (id_articulo) REFERENCES ARTICULO(id) ON DELETE CASCADE
);
