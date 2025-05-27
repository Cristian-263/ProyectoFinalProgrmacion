-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-05-2025 a las 22:28:57
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
-- Base de datos: `dragon_ball`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `ObtenerAtaquesPorPersonaje` (IN `personajeID` INT)   BEGIN
    SELECT 
        Ataques.nombre, 
        Ataques.daño_total, 
        Ataques.daño_parcial, 
        Ataques.daño_fallo
    FROM 
        Ataques
    INNER JOIN 
        Ataques_Personaje ON Ataques.id = Ataques_Personaje.ataque_id
    WHERE 
        Ataques_Personaje.personaje_id = personajeID;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ataques`
--

CREATE TABLE `ataques` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `daño_total` int(11) DEFAULT NULL,
  `daño_parcial` int(11) DEFAULT NULL,
  `daño_fallo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ataques`
--

INSERT INTO `ataques` (`id`, `nombre`, `daño_total`, `daño_parcial`, `daño_fallo`) VALUES
(1, 'Kamehameha', 14, 5, 0),
(2, 'Genki-dama', 20, 10, 0),
(3, 'Kaio-ken', 12, 6, 0),
(4, 'Taiyoken', 8, 4, 0),
(5, 'Teletransportación', 6, 3, 0),
(6, 'AbsorcionV', 12, 6, 0),
(7, 'RayoDeCarameloV', 18, 9, 0),
(8, 'BolaDeLaMuerteV', 10, 5, 0),
(9, 'NovaStrikeV', 8, 4, 0),
(10, 'BlackKamehamehaV', 20, 10, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ataques_personaje`
--

CREATE TABLE `ataques_personaje` (
  `id` int(11) NOT NULL,
  `personaje_id` int(11) DEFAULT NULL,
  `ataque_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ataques_personaje`
--

INSERT INTO `ataques_personaje` (`id`, `personaje_id`, `ataque_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 2, 1),
(7, 2, 2),
(8, 2, 3),
(9, 2, 4),
(10, 2, 5),
(11, 4, 1),
(12, 4, 2),
(13, 4, 3),
(14, 4, 4),
(15, 4, 5),
(16, 5, 1),
(17, 5, 2),
(18, 5, 3),
(19, 5, 4),
(20, 5, 5),
(21, 3, 6),
(22, 3, 7),
(23, 3, 8),
(24, 3, 9),
(25, 3, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `batallas`
--

CREATE TABLE `batallas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `escenario_id` int(11) DEFAULT NULL,
  `enemigo_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `condiciones_atmosfericas`
--

CREATE TABLE `condiciones_atmosfericas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `condiciones_atmosfericas`
--

INSERT INTO `condiciones_atmosfericas` (`id`, `nombre`) VALUES
(1, 'despejado'),
(2, 'niebla'),
(3, 'lluvia'),
(4, 'nieve');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escenarios`
--

CREATE TABLE `escenarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `condicion_atmosferica_id` int(11) DEFAULT NULL,
  `momento_dia_id` int(11) DEFAULT NULL,
  `tipo_terreno_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `escenarios`
--

INSERT INTO `escenarios` (`id`, `nombre`, `condicion_atmosferica_id`, `momento_dia_id`, `tipo_terreno_id`) VALUES
(1, 'Planeta Namek', NULL, NULL, NULL),
(2, 'Planeta Tierra', NULL, NULL, NULL),
(3, 'Planeta Freezer', NULL, NULL, NULL),
(4, 'Planeta Vegeta', NULL, NULL, NULL),
(5, 'Planeta Vampa', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `finales`
--

CREATE TABLE `finales` (
  `id` int(11) NOT NULL,
  `personaje_id` int(11) DEFAULT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `frases_npc`
--

CREATE TABLE `frases_npc` (
  `id` int(11) NOT NULL,
  `npc_id` int(11) DEFAULT NULL,
  `frase` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `id` int(11) NOT NULL,
  `personaje_id` int(11) DEFAULT NULL,
  `objeto` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `momento_dia`
--

CREATE TABLE `momento_dia` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `momento_dia`
--

INSERT INTO `momento_dia` (`id`, `nombre`) VALUES
(1, 'mañana'),
(2, 'tarde'),
(3, 'noche');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personajes`
--

CREATE TABLE `personajes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `especie` varchar(100) DEFAULT NULL,
  `vida` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personajes`
--

INSERT INTO `personajes` (`id`, `nombre`, `tipo`, `especie`, `vida`) VALUES
(1, 'Goku', 'protagonista', 'Saiyajin', 100),
(2, 'Vegeta', 'protagonista', 'Saiyajin', 100),
(3, 'Majin Boo', 'enemigo', 'Majin', 100),
(4, 'Gohan', 'personajeSecundario', 'Saiyajin-Humano', 90),
(5, 'Kaio-sama', 'personajeSecundario', 'Dios', 90);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puzzles`
--

CREATE TABLE `puzzles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `puntos_otorgados` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_terreno`
--

CREATE TABLE `tipo_terreno` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_terreno`
--

INSERT INTO `tipo_terreno` (`id`, `nombre`) VALUES
(1, 'llano'),
(2, 'rocoso'),
(3, 'montañoso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre_usuario` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `puntuacion_total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre_usuario`, `password`, `puntuacion_total`) VALUES
(8, 'Adrian', 'Catalan', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ataques`
--
ALTER TABLE `ataques`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ataques_personaje`
--
ALTER TABLE `ataques_personaje`
  ADD PRIMARY KEY (`id`),
  ADD KEY `personaje_id` (`personaje_id`),
  ADD KEY `ataque_id` (`ataque_id`);

--
-- Indices de la tabla `batallas`
--
ALTER TABLE `batallas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `escenario_id` (`escenario_id`),
  ADD KEY `enemigo_id` (`enemigo_id`);

--
-- Indices de la tabla `condiciones_atmosfericas`
--
ALTER TABLE `condiciones_atmosfericas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `escenarios`
--
ALTER TABLE `escenarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `condicion_atmosferica_id` (`condicion_atmosferica_id`),
  ADD KEY `momento_dia_id` (`momento_dia_id`),
  ADD KEY `tipo_terreno_id` (`tipo_terreno_id`);

--
-- Indices de la tabla `finales`
--
ALTER TABLE `finales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `personaje_id` (`personaje_id`);

--
-- Indices de la tabla `frases_npc`
--
ALTER TABLE `frases_npc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `npc_id` (`npc_id`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `personaje_id` (`personaje_id`);

--
-- Indices de la tabla `momento_dia`
--
ALTER TABLE `momento_dia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `personajes`
--
ALTER TABLE `personajes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `puzzles`
--
ALTER TABLE `puzzles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_terreno`
--
ALTER TABLE `tipo_terreno`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ataques`
--
ALTER TABLE `ataques`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `ataques_personaje`
--
ALTER TABLE `ataques_personaje`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `batallas`
--
ALTER TABLE `batallas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `condiciones_atmosfericas`
--
ALTER TABLE `condiciones_atmosfericas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `escenarios`
--
ALTER TABLE `escenarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `finales`
--
ALTER TABLE `finales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `frases_npc`
--
ALTER TABLE `frases_npc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `momento_dia`
--
ALTER TABLE `momento_dia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `personajes`
--
ALTER TABLE `personajes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `puzzles`
--
ALTER TABLE `puzzles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_terreno`
--
ALTER TABLE `tipo_terreno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ataques_personaje`
--
ALTER TABLE `ataques_personaje`
  ADD CONSTRAINT `ataques_personaje_ibfk_1` FOREIGN KEY (`personaje_id`) REFERENCES `personajes` (`id`),
  ADD CONSTRAINT `ataques_personaje_ibfk_2` FOREIGN KEY (`ataque_id`) REFERENCES `ataques` (`id`);

--
-- Filtros para la tabla `batallas`
--
ALTER TABLE `batallas`
  ADD CONSTRAINT `batallas_ibfk_1` FOREIGN KEY (`escenario_id`) REFERENCES `escenarios` (`id`),
  ADD CONSTRAINT `batallas_ibfk_2` FOREIGN KEY (`enemigo_id`) REFERENCES `personajes` (`id`);

--
-- Filtros para la tabla `escenarios`
--
ALTER TABLE `escenarios`
  ADD CONSTRAINT `escenarios_ibfk_1` FOREIGN KEY (`condicion_atmosferica_id`) REFERENCES `condiciones_atmosfericas` (`id`),
  ADD CONSTRAINT `escenarios_ibfk_2` FOREIGN KEY (`momento_dia_id`) REFERENCES `momento_dia` (`id`),
  ADD CONSTRAINT `escenarios_ibfk_3` FOREIGN KEY (`tipo_terreno_id`) REFERENCES `tipo_terreno` (`id`);

--
-- Filtros para la tabla `finales`
--
ALTER TABLE `finales`
  ADD CONSTRAINT `finales_ibfk_1` FOREIGN KEY (`personaje_id`) REFERENCES `personajes` (`id`);

--
-- Filtros para la tabla `frases_npc`
--
ALTER TABLE `frases_npc`
  ADD CONSTRAINT `frases_npc_ibfk_1` FOREIGN KEY (`npc_id`) REFERENCES `personajes` (`id`);

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`personaje_id`) REFERENCES `personajes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
