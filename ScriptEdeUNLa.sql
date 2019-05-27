-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bd-hibernate-edeunla
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bd-hibernate-edeunla` ;

-- -----------------------------------------------------
-- Schema bd-hibernate-edeunla
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd-hibernate-edeunla` DEFAULT CHARACTER SET latin1 ;
USE `bd-hibernate-edeunla` ;

-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`inspector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`inspector` (
  `idInspector` INT(11) NOT NULL AUTO_INCREMENT,
  `dni` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefonoMovil` INT(11) NOT NULL,
  PRIMARY KEY (`idInspector`, `dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefonoFijo` INT(11) NOT NULL,
  `telefonoMovil` INT(11) NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`zona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`zona` (
  `idZona` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idZona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`medidor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`medidor` (
  `idMedidor` INT(11) NOT NULL AUTO_INCREMENT,
  `idCliente` INT(11) NOT NULL,
  `nroSerie` INT(11) NOT NULL,
  `domicilioMedidor` VARCHAR(45) NOT NULL,
  `esBaja` BIT(1) NULL DEFAULT b'0',
  `idZona` INT(11) NOT NULL,
  PRIMARY KEY (`idMedidor`),
  CONSTRAINT `fk_medidor_cliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `bd-hibernate-edeunla`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medidor_zona`
    FOREIGN KEY (`idZona`)
    REFERENCES `bd-hibernate-edeunla`.`zona` (`idZona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `medidor_cliente_idx` ON `bd-hibernate-edeunla`.`medidor` (`idCliente` ASC);

CREATE INDEX `fk_medidor_zona_idx` ON `bd-hibernate-edeunla`.`medidor` (`idZona` ASC);


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`lectura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`lectura` (
  `idLectura` INT(11) NOT NULL AUTO_INCREMENT,
  `idInspector` INT(11) NOT NULL,
  `fecha` DATE NOT NULL,
  `idMedidor` INT(11) NOT NULL,
  PRIMARY KEY (`idLectura`, `idInspector`, `idMedidor`),
  CONSTRAINT `lectura_inspector`
    FOREIGN KEY (`idInspector`)
    REFERENCES `bd-hibernate-edeunla`.`inspector` (`idInspector`),
  CONSTRAINT `lectura_medidor`
    FOREIGN KEY (`idMedidor`)
    REFERENCES `bd-hibernate-edeunla`.`medidor` (`idMedidor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `lectura_medidor_idx` ON `bd-hibernate-edeunla`.`lectura` (`idMedidor` ASC);

CREATE INDEX `lectura_inspector_idx` ON `bd-hibernate-edeunla`.`lectura` (`idInspector` ASC);


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`altademanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`altademanda` (
  `idAltaDemanda` INT(11) NOT NULL,
  `consumoHorasValle` INT(11) NOT NULL,
  `consumoHorasPico` INT(11) NOT NULL,
  `consumoHorasResto` INT(11) NOT NULL,
  PRIMARY KEY (`idAltaDemanda`),
  CONSTRAINT `altaDemanda_lectura`
    FOREIGN KEY (`idAltaDemanda`)
    REFERENCES `bd-hibernate-edeunla`.`lectura` (`idLectura`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`bajademanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`bajademanda` (
  `idBajaDemanda` INT(11) NOT NULL,
  `consumo` INT(11) NOT NULL,
  PRIMARY KEY (`idBajaDemanda`),
  CONSTRAINT `bajaDemanda_lectura`
    FOREIGN KEY (`idBajaDemanda`)
    REFERENCES `bd-hibernate-edeunla`.`lectura` (`idLectura`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`tarifa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`tarifa` (
  `idTarifa` INT(11) NOT NULL AUTO_INCREMENT,
  `servicio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTarifa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`tarifaalta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`tarifaalta` (
  `idTarifaAlta` INT(11) NOT NULL,
  `tensionContratada` VARCHAR(2) NOT NULL,
  `limite` INT(11) NOT NULL,
  PRIMARY KEY (`idTarifaAlta`),
  CONSTRAINT `tarifaAlta_tarifa`
    FOREIGN KEY (`idTarifaAlta`)
    REFERENCES `bd-hibernate-edeunla`.`tarifa` (`idTarifa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`detallealta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`detallealta` (
  `idDetalleAlta` INT(11) NOT NULL AUTO_INCREMENT,
  `idTarifaAlta` INT(11) NOT NULL,
  `detalleConcepto` VARCHAR(45) NOT NULL,
  `unidad` VARCHAR(45) NOT NULL,
  `superarLimite` BIT(1) NULL DEFAULT b'0',
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`idDetalleAlta`, `idTarifaAlta`),
  CONSTRAINT `detalleAlta_tarifaAlta`
    FOREIGN KEY (`idTarifaAlta`)
    REFERENCES `bd-hibernate-edeunla`.`tarifaalta` (`idTarifaAlta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `detalleAlta_tarifaAlta_idx` ON `bd-hibernate-edeunla`.`detallealta` (`idTarifaAlta` ASC);


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`tarifabaja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`tarifabaja` (
  `idTarifaBaja` INT(11) NOT NULL,
  PRIMARY KEY (`idTarifaBaja`),
  CONSTRAINT `tarifaBaja_tarifa`
    FOREIGN KEY (`idTarifaBaja`)
    REFERENCES `bd-hibernate-edeunla`.`tarifa` (`idTarifa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`detallebaja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`detallebaja` (
  `idDetalleBaja` INT(11) NOT NULL AUTO_INCREMENT,
  `idTarifaBaja` INT(11) NOT NULL,
  `detalleConcepto` VARCHAR(45) NOT NULL,
  `unidad` VARCHAR(45) NOT NULL,
  `desde` INT(11) NOT NULL,
  `hasta` INT(11) NOT NULL,
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`idDetalleBaja`, `idTarifaBaja`),
  CONSTRAINT `detalleBaja_tarifaBaja`
    FOREIGN KEY (`idTarifaBaja`)
    REFERENCES `bd-hibernate-edeunla`.`tarifabaja` (`idTarifaBaja`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `detalleBaja_tarifaBaja_idx` ON `bd-hibernate-edeunla`.`detallebaja` (`idTarifaBaja` ASC);


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`factura` (
  `idFactura` INT(11) ZEROFILL UNSIGNED NOT NULL AUTO_INCREMENT,
  `datosCliente` VARCHAR(250) NOT NULL,
  `fecha` DATE NOT NULL,
  `observaciones` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idFactura`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`inspectorxzona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`inspectorxzona` (
  `idInspector` INT(11) NOT NULL,
  `idZona` INT(11) NOT NULL,
  PRIMARY KEY (`idInspector`, `idZona`),
  CONSTRAINT `fk_Inspector_has_Zona_Inspector`
    FOREIGN KEY (`idInspector`)
    REFERENCES `bd-hibernate-edeunla`.`inspector` (`idInspector`),
  CONSTRAINT `fk_Inspector_has_Zona_Zona1`
    FOREIGN KEY (`idZona`)
    REFERENCES `bd-hibernate-edeunla`.`zona` (`idZona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `fk_Inspector_has_Zona_Zona1_idx` ON `bd-hibernate-edeunla`.`inspectorxzona` (`idZona` ASC);

CREATE INDEX `fk_Inspector_has_Zona_Inspector_idx` ON `bd-hibernate-edeunla`.`inspectorxzona` (`idInspector` ASC);


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`itemfactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`itemfactura` (
  `idItemFactura` INT(11) NOT NULL AUTO_INCREMENT,
  `detalle` VARCHAR(45) NOT NULL,
  `precioUnitario` DOUBLE NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `unidad` VARCHAR(45) NOT NULL,
  `nroMedidor` INT NOT NULL,
  `idTarifa` INT(11) NOT NULL,
  `idLectura` INT(11) NOT NULL,
  `idFactura` INT(11) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`idItemFactura`, `idTarifa`, `idLectura`, `idFactura`),
  CONSTRAINT `itemFactura_factura`
    FOREIGN KEY (`idFactura`)
    REFERENCES `bd-hibernate-edeunla`.`factura` (`idFactura`),
  CONSTRAINT `itemFactura_lectura`
    FOREIGN KEY (`idLectura`)
    REFERENCES `bd-hibernate-edeunla`.`lectura` (`idLectura`),
  CONSTRAINT `itemFactura_tarifa`
    FOREIGN KEY (`idTarifa`)
    REFERENCES `bd-hibernate-edeunla`.`tarifa` (`idTarifa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `itemFactura_lectura_idx` ON `bd-hibernate-edeunla`.`itemfactura` (`idLectura` ASC);

CREATE INDEX `itemFactura_factura_idx` ON `bd-hibernate-edeunla`.`itemfactura` (`idFactura` ASC);

CREATE INDEX `itemFactura_tarifa_idx` ON `bd-hibernate-edeunla`.`itemfactura` (`idTarifa` ASC);


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`personafisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`personafisica` (
  `idPersonaFisica` INT(11) NOT NULL,
  `dni` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPersonaFisica`, `dni`),
  CONSTRAINT `personaFisica_cliente`
    FOREIGN KEY (`idPersonaFisica`)
    REFERENCES `bd-hibernate-edeunla`.`cliente` (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`personajuridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`personajuridica` (
  `idPersonaJuridica` INT(11) NOT NULL,
  `cuit` INT(11) NOT NULL,
  `razonSocial` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPersonaJuridica`, `cuit`),
  CONSTRAINT `personaJuridica_cliente`
    FOREIGN KEY (`idPersonaJuridica`)
    REFERENCES `bd-hibernate-edeunla`.`cliente` (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
