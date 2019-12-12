DROP DATABASE IF EXISTS `open_user`;

CREATE DATABASE `open_user`;

USE `open_user`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` VARCHAR(20) NOT NULL,
  `username` VARCHAR(32) NOT NULL,
  `password` VARCHAR(16) NOT NULL,
  `createTime` DATETIME  NOT NULL,
  `updateTime` DATETIME  NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;