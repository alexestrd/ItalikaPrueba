-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-10-2023 a las 15:36:00
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cotizacion_italika`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` bigint(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `celular` int(13) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `costo`
--

CREATE TABLE `costo` (
  `id_costo` bigint(20) NOT NULL,
  `precio_iva` int(20) NOT NULL,
  `precio` int(20) NOT NULL,
  `gastos_administrativos` int(20) NOT NULL,
  `costo_accesorios` int(20) NOT NULL,
  `seguro_vehiculo` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cotizacion`
--

CREATE TABLE `cotizacion` (
  `id_cotizacion` bigint(20) NOT NULL,
  `fecha_cotizacion` varchar(25) NOT NULL,
  `id_cliente` bigint(20) NOT NULL,
  `id_moto` bigint(20) NOT NULL,
  `id_costo` bigint(20) NOT NULL,
  `id_proyeccion` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `moto`
--

CREATE TABLE `moto` (
  `id_moto` bigint(20) NOT NULL,
  `Modelo` varchar(30) NOT NULL,
  `version` varchar(30) NOT NULL,
  `id_costo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyeccion`
--

CREATE TABLE `proyeccion` (
  `id_proyeccion` bigint(20) NOT NULL,
  `duracion` int(20) NOT NULL,
  `tasa_fija` int(20) NOT NULL,
  `mensualidades` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `costo`
--
ALTER TABLE `costo`
  ADD PRIMARY KEY (`id_costo`);

--
-- Indices de la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  ADD PRIMARY KEY (`id_cotizacion`),
  ADD KEY `FK_cotizacion_cliente` (`id_cliente`),
  ADD KEY `FK_cotizacion_moto` (`id_moto`),
  ADD KEY `FK_cotizacion_costo` (`id_costo`),
  ADD KEY `FK_cotizacion_proyeccion` (`id_proyeccion`);

--
-- Indices de la tabla `moto`
--
ALTER TABLE `moto`
  ADD PRIMARY KEY (`id_moto`);

--
-- Indices de la tabla `proyeccion`
--
ALTER TABLE `proyeccion`
  ADD PRIMARY KEY (`id_proyeccion`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  ADD CONSTRAINT `FK_cotizacion_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`Id_cliente`),
  ADD CONSTRAINT `FK_cotizacion_costo` FOREIGN KEY (`id_costo`) REFERENCES `costo` (`id_costo`),
  ADD CONSTRAINT `FK_cotizacion_moto` FOREIGN KEY (`id_moto`) REFERENCES `moto` (`id_moto`),
  ADD CONSTRAINT `FK_cotizacion_proyeccion` FOREIGN KEY (`id_proyeccion`) REFERENCES `proyeccion` (`id_proyeccion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
