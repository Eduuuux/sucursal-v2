-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2025 a las 10:16:16
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sucursal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE `personal` (
  `id_personal` int(11) NOT NULL,
  `apellido_personal` varchar(100) NOT NULL,
  `correo_personal` varchar(100) NOT NULL,
  `nombre_personal` varchar(100) NOT NULL,
  `rut_personal` varchar(100) NOT NULL,
  `telefono_personal` varchar(25) NOT NULL,
  `id_sucursal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`id_personal`, `apellido_personal`, `correo_personal`, `nombre_personal`, `rut_personal`, `telefono_personal`, `id_sucursal`) VALUES
(3, 'López', 'clopez@example.com', 'Carlos', '13.456.789-0', '5551000003', 2),
(4, 'Rodríguez', 'arodriguez@example.com', 'Ana', '14.567.890-1', '5551000004', 2),
(5, 'Hernández', 'jhernandez@example.com', 'Jorge', '15.678.901-2', '5551000005', 3),
(6, 'Martínez', 'vmartinez@example.com', 'Valeria', '16.789.012-3', '5551000006', 3),
(7, 'Sánchez', 'dsanchez@example.com', 'Diego', '17.890.123-4', '5551000007', 3),
(8, 'Ramírez', 'framirez@example.com', 'Fernanda', '18.901.234-5', '5551000008', 4),
(9, 'Torres', 'ltorres@example.com', 'Luis', '19.012.345-6', '5551000009', 4),
(10, 'Flores', 'aflores@example.com', 'Andrea', '20.123.456-7', '5551000010', 5),
(11, 'Cruz', 'ncruz@example.com', 'Natalia', '21.234.567-8', '5551000011', 6),
(12, 'Ortiz', 'rortiz@example.com', 'Ricardo', '22.345.678-9', '5551000012', 7),
(13, 'Morales', 'mmorales@example.com', 'Manuel', '23.456.789-0', '5551000013', 7),
(14, 'Vargas', 'svargas@example.com', 'Sofía', '24.567.890-1', '5551000014', 8),
(15, 'Castro', 'jcastro@example.com', 'Javiera', '25.678.901-2', '5551000015', 9),
(17, 'Péasdasdrez', 'jperez@example.com', 'asdasdasasdasdasd', 'wuwuwuuwwuuw', '5551000001', 2),
(18, 'aasdas', 'brua@example.com', 'bryan', '123123123', '93939393', 3),
(19, 'aaaaaaaaaaaaasdas', 'brua@example.com', 'bryasdan', '1123', '93939393', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `correo_proveedor` varchar(100) NOT NULL,
  `direccion_proveedor` varchar(100) NOT NULL,
  `nombre_proveedor` varchar(100) NOT NULL,
  `producto_proveedor` varchar(100) NOT NULL,
  `rut_proveedor` varchar(15) NOT NULL,
  `telefono_proveedor` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id_proveedor`, `correo_proveedor`, `direccion_proveedor`, `nombre_proveedor`, `producto_proveedor`, `rut_proveedor`, `telefono_proveedor`) VALUES
(1, 'contacto@alimentosdelnorte.com', 'Av. Las Torres 123, CDMX', 'Alimentos del Norte', 'Granos y cereales', '76.543.210-1', '5511122233'),
(2, 'ventas@equiposmedicos.mx', 'Calle Salud 456, Guadalajara', 'Equipos Médicos MX', 'Material quirúrgico', '65.432.109-2', '3312345678'),
(3, 'info@limpiezamax.com', 'Blvd. Higiene 789, Monterrey', 'Limpieza Max', 'Artículos de limpieza', '54.321.098-3', '8189988776'),
(4, 'proveedor@papeleriasigloxxi.com', 'Calle Documentos 101, Puebla', 'Papelería Siglo XXI', 'Papelería y oficina', '43.210.987-4', '2223456789'),
(5, 'ventas@tecnored.com', 'Av. Tecnología 202, Querétaro', 'TecnoRed', 'Redes y telecomunicaciones', '32.109.876-5', '4421234567'),
(6, 'suministros@acerosfuerte.com', 'Calle Metal 303, León', 'Aceros Fuerte', 'Material de construcción', '21.098.765-6', '4779876543'),
(7, 'servicios@biofarmaceutica.com', 'Blvd. Salud 404, Mérida', 'BioFarmacéutica SA', 'Productos farmacéuticos', '10.987.654-7', '9992345678'),
(8, 'compras@frutasdelcampo.com', 'Ruta 505, Tijuana', 'Frutas del Campo', 'Frutas y verduras', '09.876.543-8', '6643456789'),
(9, 'logistica@transportestotal.com', 'Autopista Norte KM 23, SLP', 'Transportes Total', 'Logística y transporte', '08.765.432-9', '4444567890'),
(10, 'contacto@aguapura.mx', 'Manantial 123, Cancún', 'Agua Pura MX', 'Agua embotellada', '07.654.321-0', '9987654321');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE `sucursal` (
  `id_sucursal` int(11) NOT NULL,
  `ciudad_sucursal` varchar(25) NOT NULL,
  `codigo_postal_sucursal` int(11) NOT NULL,
  `direccion_sucursal` varchar(100) NOT NULL,
  `horario_entrada` time(6) NOT NULL,
  `horario_salida` time(6) NOT NULL,
  `nombre_sucursal` varchar(100) NOT NULL,
  `politicas_locales` varchar(250) NOT NULL,
  `telefono_sucursal` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`id_sucursal`, `ciudad_sucursal`, `codigo_postal_sucursal`, `direccion_sucursal`, `horario_entrada`, `horario_salida`, `nombre_sucursal`, `politicas_locales`, `telefono_sucursal`) VALUES
(2, 'Guadalajara', 44100, 'Av. Juárez 567', '09:00:00.000000', '18:00:00.000000', 'Sucursal Minerva', 'Prohibido fumar en interiores', '3336547890'),
(3, 'Monterrey', 64000, 'Calle Zaragoza 89', '08:30:00.000000', '17:30:00.000000', 'Sucursal Monterrey Centro', 'No se permite ingreso con mascotas', '8187654321'),
(4, 'Puebla', 72000, 'Blvd. Hermanos Serdán 321', '10:00:00.000000', '19:00:00.000000', 'Sucursal Angelópolis', 'Acceso solo con identificación', '2221122334'),
(5, 'Querétaro', 76000, 'Av. 5 de Febrero 1001', '07:00:00.000000', '16:00:00.000000', 'Sucursal Querétaro Norte', 'Área libre de humo', '4429988776'),
(6, 'Mérida', 97000, 'Calle 60 No. 456', '09:00:00.000000', '18:00:00.000000', 'Sucursal Mérida Centro', 'Desinfección obligatoria al entrar', '9991239876'),
(7, 'Tijuana', 22000, 'Av. Revolución 888', '08:00:00.000000', '17:00:00.000000', 'Sucursal Zona Centro', 'Prohibido el ingreso sin cita', '6647654321'),
(8, 'León', 37000, 'Blvd. López Mateos 345', '09:00:00.000000', '18:00:00.000000', 'Sucursal León Oriente', 'Estacionamiento exclusivo para clientes', '4771112233'),
(9, 'San Luis Potosí', 78000, 'Calle Universidad 77', '08:00:00.000000', '17:00:00.000000', 'Sucursal San Luis Centro', 'Respetar el aforo máximo', '4445678901'),
(10, 'Cancún', 77500, 'Av. Tulum 987', '10:00:00.000000', '19:00:00.000000', 'Sucursal Cancún Zona Hotelera', 'Prohibido uso de celulares en ventanilla', '9982345678'),
(11, 'Ciudad de concep', 1111000, 'Av. lot a1 124', '08:00:00.000000', '17:00:00.000000', 'Sucursal lota', 'ser lotino', '5551234567'),
(12, 'Ciuuasdasduuuuuuu', 1, 'a', '03:00:00.000000', '14:00:00.000000', 'a1111', 'ser lasdasotino', '512317'),
(13, 'Ciuuuuuuuuu', 1, 'a', '03:00:00.000000', '14:00:00.000000', 'a', 'ser aaaaaaaaaaaaa', '512317'),
(14, 'Ciu', 111100022, 'Av. lot a1 asasdasdasdas124', '08:00:00.000000', '17:00:00.000000', 'Sucursal coroasaaasdassdassdnel', 'ser aaaaaaaaaaaaaaaaa', '5551234as567');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal_proveedor`
--

CREATE TABLE `sucursal_proveedor` (
  `id` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `id_sucursal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `sucursal_proveedor`
--

INSERT INTO `sucursal_proveedor` (`id`, `id_proveedor`, `id_sucursal`) VALUES
(3, 3, 2),
(4, 4, 4),
(5, 4, 4),
(6, 5, 5),
(7, 6, 6),
(8, 3, 7),
(9, 7, 8),
(10, 2, 9);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`id_personal`),
  ADD UNIQUE KEY `UKkbreffxplu04uukhaodbxy9rd` (`rut_personal`),
  ADD KEY `FKlr64ufrs9epawqi3rnpoqrvk2` (`id_sucursal`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_proveedor`),
  ADD UNIQUE KEY `UKhj8h1wqt99t2ftcj9q82uaqh6` (`rut_proveedor`);

--
-- Indices de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD PRIMARY KEY (`id_sucursal`);

--
-- Indices de la tabla `sucursal_proveedor`
--
ALTER TABLE `sucursal_proveedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtha157yaiv1kiwqsarwmqltiq` (`id_proveedor`),
  ADD KEY `FK23ascv4ywiahpdn4hsa9bsnt3` (`id_sucursal`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `personal`
--
ALTER TABLE `personal`
  MODIFY `id_personal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  MODIFY `id_sucursal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `sucursal_proveedor`
--
ALTER TABLE `sucursal_proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `personal`
--
ALTER TABLE `personal`
  ADD CONSTRAINT `FKlr64ufrs9epawqi3rnpoqrvk2` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`);

--
-- Filtros para la tabla `sucursal_proveedor`
--
ALTER TABLE `sucursal_proveedor`
  ADD CONSTRAINT `FK23ascv4ywiahpdn4hsa9bsnt3` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`),
  ADD CONSTRAINT `FKtha157yaiv1kiwqsarwmqltiq` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
