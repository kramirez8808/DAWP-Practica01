/*Drops en caso necesario */
/*drop schema if exists practica;
drop user if exists usuario_prueba;*/

/*Creación de DB */
CREATE SCHEMA practica;

/*Creación de User y Pass*/
create user 'usuario_practica'@'%' identified by 'la_Clave';

/*Se asignan los prvilegios de la DB al usuario creado*/
grant all privileges on practica.* to 'usuario_practica'@'%';
flush privileges;

/*Creación de tabla arbol*/
create table practica.arbol (
  id_arbol INT NOT NULL AUTO_INCREMENT,
  nombre_cientifico VARCHAR(50) NOT NULL,
  edad INT,
  ruta_imagen varchar(1024),
  frutal bool,
  PRIMARY KEY (id_arbol))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
