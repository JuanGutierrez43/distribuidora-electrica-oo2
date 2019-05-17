-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bd-hibernate-edeunla
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd-hibernate-edeunla
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd-hibernate-edeunla` DEFAULT CHARACTER SET latin1 ;
USE `bd-hibernate-edeunla` ;

-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`Zona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`Zona` (
  `idZona` INT(11) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idZona`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`Cliente` (
  `idCliente` INT(11) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefonoFijo` INT(11) NOT NULL,
  `telefonoMovil` INT(11) NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`Medidor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`Medidor` (
  `idMedidor` INT(11) NOT NULL AUTO_INCREMENT,
  `nroSerie` INT(11) NOT NULL,
  `idCliente` INT(11) NOT NULL,
  `idZona` INT(11) NOT NULL,
  `esBaja` BIT(1) NULL DEFAULT b'0',
  `domicilioMedidor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMedidor`, `idZona`, `idCliente`),
  INDEX `medidor_zona_idx` (`idZona` ASC),
  INDEX `medidor_cliente_idx` (`idCliente` ASC),
  CONSTRAINT `medidor_zona`
    FOREIGN KEY (`idZona`)
    REFERENCES `bd-hibernate-edeunla`.`Zona` (`idZona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `medidor_cliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `bd-hibernate-edeunla`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`Inspector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`Inspector` (
  `idInspector` INT(11) NOT NULL,
  `dni` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefonoMovil` INT(11) NOT NULL,
  PRIMARY KEY (`idInspector`, `dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`Lectura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`Lectura` (
  `idLectura` INT(11) NOT NULL AUTO_INCREMENT,
  `idInspector` INT(11) NOT NULL,
  `fecha` DATE NOT NULL,
  `idMedidor` INT(11) NOT NULL,
  PRIMARY KEY (`idLectura`, `idInspector`, `idMedidor`),
  INDEX `lectura_medidor_idx` (`idMedidor` ASC),
  INDEX `lectura_inspector_idx` (`idInspector` ASC),
  CONSTRAINT `lectura_medidor`
    FOREIGN KEY (`idMedidor`)
    REFERENCES `bd-hibernate-edeunla`.`Medidor` (`idMedidor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `lectura_inspector`
    FOREIGN KEY (`idInspector`)
    REFERENCES `bd-hibernate-edeunla`.`Inspector` (`idInspector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`AltaDemanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`AltaDemanda` (
  `idAltaDemanda` INT(11) NOT NULL,
  `consumoHorasValle` INT NOT NULL,
  `consumoHorasPico` INT NOT NULL,
  `consumoHorasResto` INT NOT NULL,
  PRIMARY KEY (`idAltaDemanda`),
  CONSTRAINT `altaDemanda_lectura`
    FOREIGN KEY (`idAltaDemanda`)
    REFERENCES `bd-hibernate-edeunla`.`Lectura` (`idLectura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`BajaDemanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`BajaDemanda` (
  `idBajaDemanda` INT(11) NOT NULL,
  `consumo` INT NOT NULL,
  PRIMARY KEY (`idBajaDemanda`),
  CONSTRAINT `bajaDemanda_lectura`
    FOREIGN KEY (`idBajaDemanda`)
    REFERENCES `bd-hibernate-edeunla`.`Lectura` (`idLectura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`PersonaFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`PersonaFisica` (
  `idPersonaFisica` INT(11) NOT NULL,
  `dni` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPersonaFisica`, `dni`),
  CONSTRAINT `personaFisica_cliente`
    FOREIGN KEY (`idPersonaFisica`)
    REFERENCES `bd-hibernate-edeunla`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`PersonaJuridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`PersonaJuridica` (
  `idPersonaJuridica` INT(11) NOT NULL,
  `cuit` INT(11) NOT NULL,
  `razonSocial` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPersonaJuridica`, `cuit`),
  CONSTRAINT `personaJuridica_cliente`
    FOREIGN KEY (`idPersonaJuridica`)
    REFERENCES `bd-hibernate-edeunla`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`Factura` (
  `idFactura` INT(11) NOT NULL,
  `cliente` VARCHAR(45) NOT NULL,
  `fecha` DATE NOT NULL,
  `observaciones` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFactura`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`Tarifa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`Tarifa` (
  `idTarifa` INT(11) NOT NULL,
  `servicio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTarifa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`ItemFactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`ItemFactura` (
  `idItemFactura` INT(11) NOT NULL,
  `detalle` VARCHAR(45) NOT NULL,
  `precioUnitario` DOUBLE NOT NULL,
  `cantidad` INT NOT NULL,
  `unidad` VARCHAR(45) NOT NULL,
  `nroMedidor` INT NOT NULL,
  `idTarifa` INT(11) NOT NULL,
  `idLectura` INT(11) NOT NULL,
  `idFactura` INT(11) NOT NULL,
  PRIMARY KEY (`idItemFactura`, `idLectura`, `idFactura`, `idTarifa`),
  INDEX `itemFactura_lectura_idx` (`idLectura` ASC),
  INDEX `itemFactura_factura_idx` (`idFactura` ASC),
  INDEX `itemFactura_tarifa_idx` (`idTarifa` ASC),
  CONSTRAINT `itemFactura_lectura`
    FOREIGN KEY (`idLectura`)
    REFERENCES `bd-hibernate-edeunla`.`Lectura` (`idLectura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `itemFactura_factura`
    FOREIGN KEY (`idFactura`)
    REFERENCES `bd-hibernate-edeunla`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `itemFactura_tarifa`
    FOREIGN KEY (`idTarifa`)
    REFERENCES `bd-hibernate-edeunla`.`Tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`InspectorXZona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`InspectorXZona` (
  `idInspector` INT(11) NOT NULL,
  `idZona` INT(11) NOT NULL,
  PRIMARY KEY (`idInspector`, `idZona`),
  INDEX `fk_Inspector_has_Zona_Zona1_idx` (`idZona` ASC),
  INDEX `fk_Inspector_has_Zona_Inspector_idx` (`idInspector` ASC),
  CONSTRAINT `fk_Inspector_has_Zona_Inspector`
    FOREIGN KEY (`idInspector`)
    REFERENCES `bd-hibernate-edeunla`.`Inspector` (`idInspector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inspector_has_Zona_Zona1`
    FOREIGN KEY (`idZona`)
    REFERENCES `bd-hibernate-edeunla`.`Zona` (`idZona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`TarifaBaja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`TarifaBaja` (
  `idTarifaBaja` INT(11) NOT NULL,
  PRIMARY KEY (`idTarifaBaja`),
  CONSTRAINT `tarifaBaja_tarifa`
    FOREIGN KEY (`idTarifaBaja`)
    REFERENCES `bd-hibernate-edeunla`.`Tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`TarifaAlta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`TarifaAlta` (
  `idTarifaAlta` INT(11) NOT NULL,
  `tensionContratada` VARCHAR(2) NOT NULL,
  `limite` INT NOT NULL,
  PRIMARY KEY (`idTarifaAlta`),
  CONSTRAINT `tarifaAlta_tarifa`
    FOREIGN KEY (`idTarifaAlta`)
    REFERENCES `bd-hibernate-edeunla`.`Tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`DetalleBaja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`DetalleBaja` (
  `idDetalleBaja` INT(11) NOT NULL,
  `idTarifaBaja` INT(11) NOT NULL,
  `detalleConcepto` VARCHAR(45) NOT NULL,
  `unidad` VARCHAR(45) NOT NULL,
  `desde` INT NOT NULL,
  `hasta` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`idDetalleBaja`, `idTarifaBaja`),
  INDEX `detalleBaja_tarifaBaja_idx` (`idTarifaBaja` ASC),
  CONSTRAINT `detalleBaja_tarifaBaja`
    FOREIGN KEY (`idTarifaBaja`)
    REFERENCES `bd-hibernate-edeunla`.`TarifaBaja` (`idTarifaBaja`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-hibernate-edeunla`.`DetalleAlta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-edeunla`.`DetalleAlta` (
  `idDetalleAlta` INT(11) NOT NULL,
  `idTarifaAlta` INT(11) NOT NULL,
  `detalleConcepto` VARCHAR(45) NOT NULL,
  `unidad` VARCHAR(45) NOT NULL,
  `superarLimite` BIT(1) NULL DEFAULT b'0',
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`idDetalleAlta`, `idTarifaAlta`),
  INDEX `detalleAlta_tarifaAlta_idx` (`idTarifaAlta` ASC),
  CONSTRAINT `detalleAlta_tarifaAlta`
    FOREIGN KEY (`idTarifaAlta`)
    REFERENCES `bd-hibernate-edeunla`.`TarifaAlta` (`idTarifaAlta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
