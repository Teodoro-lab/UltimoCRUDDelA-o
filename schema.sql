CREATE DATABASE IF NOT EXISTS nomina;
USE nomina;

CREATE TABLE `empleado` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL DEFAULT '',
  `salario` int(11) NOT NULL DEFAULT 0,
  `horas_laboradas` int(11) NOT NULL DEFAULT 0,
  `rango` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;