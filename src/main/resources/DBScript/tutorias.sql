-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 08-02-2018 a las 17:57:49
-- Versión del servidor: 5.7.19
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tutorias`
--
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

DROP TABLE IF EXISTS `alumno`;
CREATE TABLE IF NOT EXISTS `alumno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` tinytext COLLATE utf8_spanish_ci NOT NULL,
  `nombre` tinytext COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` tinytext COLLATE utf8_spanish_ci NOT NULL,
  `foto` tinytext COLLATE utf8_spanish_ci NOT NULL,
  `correo` tinytext COLLATE utf8_spanish_ci NOT NULL,
  `tutor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id`, `matricula`, `nombre`, `apellidos`, `foto`, `correo`, `tutor_id`) VALUES
(1, '2013020196', 'Gustavo', 'Blizzardi', '2013020196Gustavo.jpg', 'tavo.destructo@hotmail', 0),
(3, '2013020197', 'Carlos', 'Hernandez', '2013020197Carlos.jpg', 'goliath@gmail.com', 0),
(6, '2013020200', 'Adrian', 'Gonzales', '2013020200Adrian.jpg', 'ad.gon@gmail.com', 0),
(7, '2013020201', 'Fernando', 'Garcia  Velasco', '2013020201Fernando.jpg', 'fer.vel@hotmail.com', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificaciones`
--

DROP TABLE IF EXISTS `calificaciones`;
CREATE TABLE IF NOT EXISTS `calificaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_materia` int(11) NOT NULL,
  `id_alumno` int(11) NOT NULL,
  `nombre` tinytext COLLATE utf8_spanish_ci NOT NULL,
  `P1` float DEFAULT NULL,
  `P2` float DEFAULT NULL,
  `P3` float DEFAULT NULL,
  `FINAL` float DEFAULT NULL,
  `EX1` float DEFAULT NULL,
  `EX2` float DEFAULT NULL,
  `ES` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_materia` (`id_materia`),
  KEY `id_alumno` (`id_alumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

DROP TABLE IF EXISTS `materia`;
CREATE TABLE IF NOT EXISTS `materia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` tinytext COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`id`, `nombre`) VALUES
(2, 'Programacion Estructurada'),
(3, 'Calculo Integral');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

DROP TABLE IF EXISTS `profesor`;
CREATE TABLE IF NOT EXISTS `profesor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` tinytext COLLATE utf8_spanish_ci NOT NULL,
  `usuario` tinytext COLLATE utf8_spanish_ci NOT NULL,
  `correo` tinytext COLLATE utf8_spanish_ci NOT NULL,
  `instituto` tinytext COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`id`, `nombre`, `usuario`, `correo`, `instituto`) VALUES
(1, 'Carlos', 'Exe1', 'goliath@gmail', 'Computacion'),
(3, 'Andrea Martinez Hernandez', 'andy', 'and.her@gmail.com', 'Fisica y Matematicas');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `calificaciones`
--
ALTER TABLE `calificaciones`
  ADD CONSTRAINT `calificaciones_ibfk_1` FOREIGN KEY (`id_materia`) REFERENCES `materia` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `calificaciones_ibfk_2` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
