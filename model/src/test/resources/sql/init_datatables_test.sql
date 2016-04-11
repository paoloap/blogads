--CREATE SCHEMA IF NOT EXISTS `blog` DEFAULT CHARACTER SET utf8 ;
--USE `blog` ;

-- -----------------------------------------------------
-- Table `blog`.`Article`
-- -----------------------------------------------------
CREATE table Article
(
ARTICLE_ID int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
A_TITLE varchar(50),
A_BODY varchar(500),
A_DATA DATE,
A_AUTHOR varchar(30)
);

-- -----------------------------------------------------
-- Table `bglogin`.`Comment`
-- -----------------------------------------------------
CREATE table Comment
(
COMMENT_ID int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
C_BODY varchar(300),
C_AUTHOR varchar(30),
C_EMAIL varchar(30),
C_ARTICLE_ID int,
CONSTRAINT C_ARTICLE_ID FOREIGN KEY (C_ARTICLE_ID) REFERENCES Article(ARTICLE_ID)
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `bglogin`.`Tag`
-- -----------------------------------------------------
CREATE table Tag
(
TAG_ID int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
T_NAME varchar(30) NOT NULL UNIQUE
);

-- -----------------------------------------------------
-- Table `bglogin`.`Article_Tag`
-- -----------------------------------------------------
CREATE table Article_Tag
(
ID int NOT NULL  PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
ARTICLE_ID int NOT NULL,
TAG_ID int NOT NULL,
CONSTRAINT FK_ARTICLE_ID FOREIGN KEY (ARTICLE_ID) REFERENCES Article (ARTICLE_ID),
CONSTRAINT FK_TAG_ID FOREIGN KEY (TAG_ID) REFERENCES Tag (TAG_ID)
);
