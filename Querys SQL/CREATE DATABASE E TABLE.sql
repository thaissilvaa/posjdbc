CREATE DATABASE `posjava` 

CREATE TABLE `userposjava` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `telefoneuser` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `numero` varchar(255) NOT NULL,
  `usuariopessoa` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `usuariopessoa` (`usuariopessoa`),
  CONSTRAINT `telefoneuser_ibfk_1` FOREIGN KEY (`usuariopessoa`) REFERENCES `userposjava` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
