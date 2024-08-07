create database IF NOT EXISTS proyecto_restaurante;

CREATE TABLE `proyecto_restaurante`.`CLIENTE` (
    `CLIENTE_ID` VARCHAR(50) ,
    `NOMBRE_CLIENTE` VARCHAR(50) ,
    `CLIENTE_DNI` VARCHAR(50) ,
    `DIRECCION_CLIENTE` VARCHAR(50) ,
    `TELEFONO_CLIENTE` VARCHAR(50),
    `EMAIL_CLIENTE` VARCHAR(50),
    `PUNTOS_CLIENTE` INT ,
    PRIMARY KEY (`CLIENTE_ID`)
); 

CREATE TABLE `proyecto_restaurante`.`EMPLEADO` (
    `EMPLEADO_ID` VARCHAR(50) ,
    `NOMBRE_EMPLEADO` VARCHAR(50) ,
    `EMPLEADO_DNI` VARCHAR(50) ,
    `DIRECCION_EMPLEADO` VARCHAR(50) ,
    `TELEFONO_EMPLEADO` VARCHAR(50),
    `EMAIL_EMPLEADO` VARCHAR(50),
    `ROL_EMPLEADO` VARCHAR(50) ,
    `SALARIO_EMPLEADO` DOUBLE ,
    PRIMARY KEY (`EMPLEADO_ID`)
); 

CREATE TABLE `proyecto_restaurante`.`PRODUCTO` (
    `PRODUCTO_ID` VARCHAR(50),
    `NOMBRE_PRODUCTO`  VARCHAR(50),
    `CANTIDAD_STOCK` INT,
    `PRECIO_VENTA_PRODUCTO` DOUBLE,
    PRIMARY KEY (`PRODUCTO_ID`)
);

CREATE TABLE `proyecto_restaurante`.`PEDIDO` (
    `PEDIDO_ID` VARCHAR(50),
    `CLIENTE_ID` VARCHAR(50),
    `PRODUCTO_ID`  VARCHAR(50),
    `METODO_PAGO` VARCHAR(50),
    `NOMBRE_PRODUCTO_SOLICITADO`  VARCHAR(50),
    `CANTIDAD_PRODUCTO_SOLICITADO` INT,
    `TOTAL_TICKET_PEDIDO` DOUBLE,
    PRIMARY KEY (`PEDIDO_ID`),
    FOREIGN KEY (`CLIENTE_ID`) REFERENCES `CLIENTE`(`CLIENTE_ID`),
    FOREIGN KEY (`PRODUCTO_ID`) REFERENCES `PRODUCTO`(`PRODUCTO_ID`)    
);

CREATE TABLE `proyecto_restaurante`.`DETALLE_PEDIDO` (
    `DETALLE_PEDIDO_ID` VARCHAR(50),
    `CLIENTE_ID` VARCHAR(50),
    `PEDIDO_ID`  VARCHAR(50),
    `EMPLEADO_ID`  VARCHAR(50),
    `DESCRIPCION` VARCHAR(500),
    PRIMARY KEY (`DETALLE_PEDIDO_ID`),
    FOREIGN KEY (`CLIENTE_ID`) REFERENCES `CLIENTE`(`CLIENTE_ID`),
    FOREIGN KEY (`EMPLEADO_ID`) REFERENCES `EMPLEADO`(`EMPLEADO_ID`),
    FOREIGN KEY (`PEDIDO_ID`) REFERENCES `PEDIDO`(`PEDIDO_ID`)  ON DELETE CASCADE
);
 
CREATE TABLE `proyecto_restaurante`.`PROVEEDOR` (
    `PROVEEDOR_ID` VARCHAR(50),
    `PRODUCTO_ID`  VARCHAR(50),
    `NOMBRE_PROVEEDOR`  VARCHAR(50),
    `TELEFONO_PROVEEDOR` VARCHAR(50),
    `EMAIL_PROVEEDOR` VARCHAR(50),
    `PRECIO_COMPRA_PRODUCTO` DOUBLE,
    `CANTIDAD_COMPRA_PRODUCTO` INT,
    PRIMARY KEY (`PROVEEDOR_ID`) , 
	-- FOREIGN KEY (`PRODUCTO_ID`) REFERENCES `PRODUCTO`(`PRODUCTO_ID`) 
    CONSTRAINT `FK_PRODUCTO_ID`
        FOREIGN KEY (`PRODUCTO_ID`)
        REFERENCES `PRODUCTO` (`PRODUCTO_ID`)
        ON DELETE CASCADE
);

INSERT INTO `proyecto_restaurante`.`cliente` (`CLIENTE_ID`, `NOMBRE_CLIENTE`, `CLIENTE_DNI`, `DIRECCION_CLIENTE`, `TELEFONO_CLIENTE`, `EMAIL_CLIENTE`, `PUNTOS_CLIENTE`) VALUES ('asdfa34R', 'Jose Martin', '43534245R', 'calle finlandia, 4','432434356', 'pepito@hotmail.com',  '10');
INSERT INTO `proyecto_restaurante`.`cliente` (`CLIENTE_ID`, `NOMBRE_CLIENTE`, `CLIENTE_DNI`, `DIRECCION_CLIENTE`, `TELEFONO_CLIENTE`, `EMAIL_CLIENTE`, `PUNTOS_CLIENTE`) VALUES ('hrehTe45', 'Jorge Sierra', '87654897J', 'calle marruecos, 8', '678765432', 'jorgito@gmail.com', '20');
INSERT INTO `proyecto_restaurante`.`cliente` (`CLIENTE_ID`, `NOMBRE_CLIENTE`, `CLIENTE_DNI`, `DIRECCION_CLIENTE`, `TELEFONO_CLIENTE`, `EMAIL_CLIENTE`, `PUNTOS_CLIENTE`) VALUES ('asTfa34R', 'prueba', '55555555r', 'calle 555, 4','555555555', 'pruebao@prueba.com',  '10');

INSERT INTO `proyecto_restaurante`.`empleado` (`EMPLEADO_ID`, `NOMBRE_EMPLEADO`, `EMPLEADO_DNI`, `DIRECCION_EMPLEADO`, `TELEFONO_EMPLEADO`, `EMAIL_EMPLEADO`, `ROL_EMPLEADO`, `SALARIO_EMPLEADO`) VALUES ('345werRF', 'Julio Martinez', '43216808N', 'calle belgica, 5', '765436896', 'julito@yahoo.es', 'Recepcionista', '1200.0');
INSERT INTO `proyecto_restaurante`.`empleado` (`EMPLEADO_ID`, `NOMBRE_EMPLEADO`, `EMPLEADO_DNI`, `DIRECCION_EMPLEADO`, `TELEFONO_EMPLEADO`, `EMAIL_EMPLEADO`, `ROL_EMPLEADO`, `SALARIO_EMPLEADO`) VALUES ('46475TRN', 'Sergio Gutierrez', '45678865R', 'calle alemania, 8', '456379765', 'sergio@hotmail.com', 'Cocinero', '1500.0');

INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg156', 'Pizza Margarita', '10', '12.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg256', 'Pizza 4 Quesos', '10', '12.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg356', 'Pizza Barbacoa', '10', '12.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg456', 'Pizza Anchoas', '10', '12.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg151', 'Ternera', '10', '10.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg252', 'Pollo', '10', '10.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg353', 'Vegetal', '10', '10.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg454', 'Pescado', '10', '10.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg111', 'Normal', '10', '8.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg222', 'Pavo', '10', '8.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg333', 'Salchicha Blanca', '10', '8.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg444', 'Picante', '10', '8.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('1HGdg111', 'Espaguetis', '10', '9.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('2HGdg222', 'Macarrones', '10', '9.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('3HGdg333', 'Tortelinis', '10', '9.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('4HGdg444', 'Tallarines', '10', '9.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGd1111', 'Mediterranea', '10', '5.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGd2222', 'Cesar', '10', '5.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGd3333', 'Campera', '10', '5.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGd4444', 'Ensaladilla Rusa', '10', '5.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg15', 'Agua', '10', '2.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg276', 'CocaCola', '10', '2.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg386', 'Naranja', '10', '2.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHGdg496', 'Limon', '10', '2.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('e8gdg15', 'Yogurt', '10', '3.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHddg276', 'Helado', '10', '3.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHhdg386', 'Flan', '10', '3.00');
INSERT INTO `proyecto_restaurante`.`producto` (`PRODUCTO_ID`, `NOMBRE_PRODUCTO`, `CANTIDAD_STOCK`, `PRECIO_VENTA_PRODUCTO`) VALUES ('eHjdg496', 'Tarta', '10', '3.00');

INSERT INTO `proyecto_restaurante`.`pedido` (`PEDIDO_ID`, `CLIENTE_ID`, `PRODUCTO_ID`, `METODO_PAGO`,  `NOMBRE_PRODUCTO_SOLICITADO`, `CANTIDAD_PRODUCTO_SOLICITADO`, `TOTAL_TICKET_PEDIDO`) VALUES ('wertdg45', 'asdfa34R', 'eHGdg156', 'EFECTIVO', 'Pizza Margarita', '4', '88');

INSERT INTO `proyecto_restaurante`.`detalle_pedido` (`DETALLE_PEDIDO_ID`, `CLIENTE_ID`, `PEDIDO_ID`, `EMPLEADO_ID`, `DESCRIPCION`) VALUES ('asd234TT', 'hrehTe45', 'wertdg45', '345werRF', 'Nombre del Producto: Pizza Margarita');

INSERT INTO `proyecto_restaurante`.`proveedor` (`PROVEEDOR_ID`, `PRODUCTO_ID`, `NOMBRE_PROVEEDOR`, `TELEFONO_PROVEEDOR`, `EMAIL_PROVEEDOR`, `PRECIO_COMPRA_PRODUCTO`, `CANTIDAD_COMPRA_PRODUCTO`) VALUES ('456fgdsh', 'eHGdg456', 'Suministros Carlos', '654326789', 'pizzas@pizzacarlos.com', '10.00', '10');
INSERT INTO `proyecto_restaurante`.`proveedor` (`PROVEEDOR_ID`, `PRODUCTO_ID`, `NOMBRE_PROVEEDOR`, `TELEFONO_PROVEEDOR`, `EMAIL_PROVEEDOR`, `PRECIO_COMPRA_PRODUCTO`, `CANTIDAD_COMPRA_PRODUCTO`) VALUES ('856fgdsh', 'eHGdg256', 'Suministros Carlos', '654326789', 'pizzas@pizzacarlos.com', '10.00', '10');
INSERT INTO `proyecto_restaurante`.`proveedor` (`PROVEEDOR_ID`, `PRODUCTO_ID`, `NOMBRE_PROVEEDOR`, `TELEFONO_PROVEEDOR`, `EMAIL_PROVEEDOR`, `PRECIO_COMPRA_PRODUCTO`, `CANTIDAD_COMPRA_PRODUCTO`) VALUES ('756fgdsh', 'eHGdg356', 'Suministros Carlos', '654326789', 'pizzas@pizzacarlos.com', '10.00', '10');
INSERT INTO `proyecto_restaurante`.`proveedor` (`PROVEEDOR_ID`, `PRODUCTO_ID`, `NOMBRE_PROVEEDOR`, `TELEFONO_PROVEEDOR`, `EMAIL_PROVEEDOR`, `PRECIO_COMPRA_PRODUCTO`, `CANTIDAD_COMPRA_PRODUCTO`) VALUES ('656fgdsh', 'eHGdg456', 'Suministros Carlos', '654326789', 'pizzas@pizzacarlos.com', '10.00', '10');
INSERT INTO `proyecto_restaurante`.`proveedor` (`PROVEEDOR_ID`, `PRODUCTO_ID`, `NOMBRE_PROVEEDOR`, `TELEFONO_PROVEEDOR`, `EMAIL_PROVEEDOR`, `PRECIO_COMPRA_PRODUCTO`, `CANTIDAD_COMPRA_PRODUCTO`) VALUES ('256fgdsh', 'eHGdg15', 'Bebidas Dominguez', '654326489', 'bebidas@bebidasdominguez.com', '1.00', '10');
INSERT INTO `proyecto_restaurante`.`proveedor` (`PROVEEDOR_ID`, `PRODUCTO_ID`, `NOMBRE_PROVEEDOR`, `TELEFONO_PROVEEDOR`, `EMAIL_PROVEEDOR`, `PRECIO_COMPRA_PRODUCTO`, `CANTIDAD_COMPRA_PRODUCTO`) VALUES ('236fgdsh', 'eHGdg276', 'Bebidas Dominguez', '654326489', 'bebidas@bebidasdominguez.com', '1.00', '10');
INSERT INTO `proyecto_restaurante`.`proveedor` (`PROVEEDOR_ID`, `PRODUCTO_ID`, `NOMBRE_PROVEEDOR`, `TELEFONO_PROVEEDOR`, `EMAIL_PROVEEDOR`, `PRECIO_COMPRA_PRODUCTO`, `CANTIDAD_COMPRA_PRODUCTO`) VALUES ('266fgdsh', 'eHGdg386', 'Bebidas Dominguez', '654326489', 'bebidas@bebidasdominguez.com', '1.00', '10');
INSERT INTO `proyecto_restaurante`.`proveedor` (`PROVEEDOR_ID`, `PRODUCTO_ID`, `NOMBRE_PROVEEDOR`, `TELEFONO_PROVEEDOR`, `EMAIL_PROVEEDOR`, `PRECIO_COMPRA_PRODUCTO`, `CANTIDAD_COMPRA_PRODUCTO`) VALUES ('276fgdsh', 'eHGdg496', 'Bebidas Dominguez', '654326489', 'bebidas@bebidasdominguez.com', '1.00', '10');
INSERT INTO `proyecto_restaurante`.`proveedor` (`PROVEEDOR_ID`, `PRODUCTO_ID`, `NOMBRE_PROVEEDOR`, `TELEFONO_PROVEEDOR`, `EMAIL_PROVEEDOR`, `PRECIO_COMPRA_PRODUCTO`, `CANTIDAD_COMPRA_PRODUCTO`) VALUES ('eygdg15', 'eHGdg456', 'Postres Juan', '655326789', 'postres@postresjuan.com', '1.00', '10');
INSERT INTO `proyecto_restaurante`.`proveedor` (`PROVEEDOR_ID`, `PRODUCTO_ID`, `NOMBRE_PROVEEDOR`, `TELEFONO_PROVEEDOR`, `EMAIL_PROVEEDOR`, `PRECIO_COMPRA_PRODUCTO`, `CANTIDAD_COMPRA_PRODUCTO`) VALUES ('efddg276', 'eHGdg456', 'Postres Juan', '655326789', 'postres@postresjuan.com', '1.00', '10');
INSERT INTO `proyecto_restaurante`.`proveedor` (`PROVEEDOR_ID`, `PRODUCTO_ID`, `NOMBRE_PROVEEDOR`, `TELEFONO_PROVEEDOR`, `EMAIL_PROVEEDOR`, `PRECIO_COMPRA_PRODUCTO`, `CANTIDAD_COMPRA_PRODUCTO`) VALUES ('euhdg386', 'eHGdg456', 'Postres Juan', '655326789', 'postres@postresjuan.com', '1.00', '10');
INSERT INTO `proyecto_restaurante`.`proveedor` (`PROVEEDOR_ID`, `PRODUCTO_ID`, `NOMBRE_PROVEEDOR`, `TELEFONO_PROVEEDOR`, `EMAIL_PROVEEDOR`, `PRECIO_COMPRA_PRODUCTO`, `CANTIDAD_COMPRA_PRODUCTO`) VALUES ('eijdg496', 'eHGdg456', 'Postres Juan', '655326789', 'postres@postresjuan.com', '1.00', '10');
