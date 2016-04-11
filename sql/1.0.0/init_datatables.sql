-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema blogads
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `blog` DEFAULT CHARACTER SET utf8 ;
USE `blog` ;

-- -----------------------------------------------------
-- Table `bglogin`.`Article`
-- -----------------------------------------------------
CREATE table Article
(
ARTICLE_ID int NOT NULL AUTO_INCREMENT primary key,
A_TITLE varchar(50),
A_BODY varchar(500),
A_DATA DATE,
A_AUTHOR varchar(30)
)

-- -----------------------------------------------------
-- Table `bglogin`.`Comment`
-- -----------------------------------------------------
CREATE table Comment
(
COMMENT_ID int NOT NULL AUTO_INCREMENT primary key,
C_BODY varchar(300),
C_AUTHOR varchar(30),
C_EMAIL varchar(30),
C_ARTICLE_ID int,
CONSTRAINT C_ARTICLE_ID FOREIGN KEY (C_ARTICLE_ID) REFERENCES Article(ARTICLE_ID)
    ON DELETE CASCADE ON UPDATE CASCADE
)

-- -----------------------------------------------------
-- Table `bglogin`.`Tag`
-- -----------------------------------------------------
CREATE table Tag
(
TAG_ID int NOT NULL AUTO_INCREMENT primary key,
T_NAME varchar(30) NOT NULL UNIQUE
)

-- -----------------------------------------------------
-- Table `bglogin`.`Article_Tag`
-- -----------------------------------------------------
CREATE table Article_Tag
(
ID int NOT NULL AUTO_INCREMENT primary key,
ARTICLE_ID int NOT NULL,
TAG_ID int NOT NULL,
CONSTRAINT `FK_ARTICLE_ID` FOREIGN KEY (`ARTICLE_ID`) REFERENCES `Article` (`ARTICLE_ID`),
CONSTRAINT `FK_TAG_ID` FOREIGN KEY (`TAG_ID`) REFERENCES `Tag` (`TAG_ID`)
)


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;