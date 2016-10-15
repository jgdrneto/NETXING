-- MySQL Script generated by MySQL Workbench
-- Sex 07 Out 2016 19:31:47 BRT
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema netxing
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema netxing
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `netxing` DEFAULT CHARACTER SET utf8 ;
USE `netxing` ;

-- -----------------------------------------------------
-- Table `netxing`.`USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `netxing`.`USUARIO` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `netxing`.`CATEGORIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `netxing`.`CATEGORIA` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `netxing`.`SERIE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `netxing`.`SERIE` (
  `idSerie` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSerie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `netxing`.`VIDEO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `netxing`.`VIDEO` (
  `idVideo` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `descricao` VARCHAR(300) NULL,
  `CATEGORIA_idCategoria` INT NOT NULL,
  `ano` INT NULL,
  `diretor` VARCHAR(45) NULL,
  `atorPrincipal` VARCHAR(100) NULL,
  `faixaEtaria` INT NOT NULL,
  `SERIE_idSerie` INT NOT NULL,
  `temporada` VARCHAR(45) NULL,
  `arquivoVideo` LONGBLOB NOT NULL,
  `extensao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idVideo`),
  INDEX `fk_FILMES_Categorias1_idx` (`CATEGORIA_idCategoria` ASC),
  INDEX `fk_VIDEOS_SERIES1_idx` (`SERIE_idSerie` ASC),
  CONSTRAINT `fk_FILMES_Categorias1`
    FOREIGN KEY (`CATEGORIA_idCategoria`)
    REFERENCES `netxing`.`CATEGORIA` (`idCategoria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_VIDEOS_SERIES1`
    FOREIGN KEY (`SERIE_idSerie`)
    REFERENCES `netxing`.`SERIE` (`idSerie`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `netxing`.`VIDEOFAVORITO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `netxing`.`VIDEOFAVORITO` (
  `idVideoFavorito` INT NOT NULL AUTO_INCREMENT,
  `VIDEO_idVideo` INT NOT NULL,
  `USUARIO_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idVideoFavorito`),
  INDEX `fk_USUARIOS_has_FILMES_FILMES1_idx` (`VIDEO_idVideo` ASC),
  INDEX `fk_USUARIOS_has_FILMES_USUARIOS1_idx` (`USUARIO_idUsuario` ASC),
  CONSTRAINT `fk_USUARIOS_has_FILMES_USUARIOS1`
    FOREIGN KEY (`USUARIO_idUsuario`)
    REFERENCES `netxing`.`USUARIO` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_USUARIOS_has_FILMES_FILMES1`
    FOREIGN KEY (`VIDEO_idVideo`)
    REFERENCES `netxing`.`VIDEO` (`idVideo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `netxing`.`SERIEFAVORITA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `netxing`.`SERIEFAVORITA` (
  `idSerieFavorita` INT NOT NULL AUTO_INCREMENT,
  `USUARIO_idUsuario` INT NOT NULL,
  `SERIE_idSerie` INT NOT NULL,
  PRIMARY KEY (`idSerieFavorita`),
  INDEX `fk_USUARIOS_has_SERIES_SERIES1_idx` (`SERIE_idSerie` ASC),
  INDEX `fk_USUARIOS_has_SERIES_USUARIOS1_idx` (`USUARIO_idUsuario` ASC),
  CONSTRAINT `fk_USUARIOS_has_SERIES_USUARIOS1`
    FOREIGN KEY (`USUARIO_idUsuario`)
    REFERENCES `netxing`.`USUARIO` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_USUARIOS_has_SERIES_SERIES1`
    FOREIGN KEY (`SERIE_idSerie`)
    REFERENCES `netxing`.`SERIE` (`idSerie`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Inserindo usuário de administrador e usuário de testes
-- -----------------------------------------------------
INSERT INTO USUARIO (login,senha, idade)
VALUES ('adm','123', 50);

INSERT INTO USUARIO (login,senha, idade)
VALUES ('jackson','mani', 21);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
