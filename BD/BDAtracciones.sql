-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: atracciones
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atracciones`
--

DROP TABLE IF EXISTS `atracciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atracciones` (
  `NombreAtraccion` varchar(20) DEFAULT NULL,
  `Identificador` int NOT NULL,
  `FechaInstalacion` varchar(20) DEFAULT NULL,
  `Capacidad` int DEFAULT NULL,
  `Seccion` varchar(30) DEFAULT NULL,
  `EdadPermitida` int DEFAULT NULL,
  `PrecioxPersona` double DEFAULT NULL,
  PRIMARY KEY (`Identificador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atracciones`
--

LOCK TABLES `atracciones` WRITE;
/*!40000 ALTER TABLE `atracciones` DISABLE KEYS */;
INSERT INTO `atracciones` VALUES ('Montaña Rusa',890,'2-3-2016',20,'Montañas Rusas',15,2000),('Ruleta',1028,'8-12-2015',2,'Carros',18,1200);
/*!40000 ALTER TABLE `atracciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookeoatraccion`
--

DROP TABLE IF EXISTS `bookeoatraccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookeoatraccion` (
  `PaseEspecial` int DEFAULT NULL,
  `FechaVenta` date DEFAULT NULL,
  `FechaVisita` date DEFAULT NULL,
  `TotalVenta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookeoatraccion`
--

LOCK TABLES `bookeoatraccion` WRITE;
/*!40000 ALTER TABLE `bookeoatraccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookeoatraccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ganancias`
--

DROP TABLE IF EXISTS `ganancias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ganancias` (
  `NumeroAtraccion` int DEFAULT NULL,
  `NombreAtraccion` varchar(20) DEFAULT NULL,
  `RecaudacionxAtraccion` double DEFAULT NULL,
  `FechaDeRecaudacion` date DEFAULT NULL,
  `CantidadPersonasxAtraccion` int DEFAULT NULL,
  `PasesEspecialesVendidos` int DEFAULT NULL,
  `RecaudacionTotal` double DEFAULT NULL,
  `NumeroTotalPersonas` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ganancias`
--

LOCK TABLES `ganancias` WRITE;
/*!40000 ALTER TABLE `ganancias` DISABLE KEYS */;
/*!40000 ALTER TABLE `ganancias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguimientoatraccion`
--

DROP TABLE IF EXISTS `seguimientoatraccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguimientoatraccion` (
  `Atraccion` varchar(40) NOT NULL,
  `Revisor` varchar(30) DEFAULT NULL,
  `FechaRevision` varchar(30) DEFAULT NULL,
  `DescripcionError` varchar(100) DEFAULT NULL,
  `Comentario` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Atraccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguimientoatraccion`
--

LOCK TABLES `seguimientoatraccion` WRITE;
/*!40000 ALTER TABLE `seguimientoatraccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguimientoatraccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `Cedula` int NOT NULL,
  `Contrasena` varchar(20) DEFAULT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `Apellido1` varchar(20) DEFAULT NULL,
  `Apellido2` varchar(20) DEFAULT NULL,
  `TipoUsuario` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1234567,'0000','andrescr','fuentes','corella','ADMINISTRADOR'),(98765432,'2222','ella22','Jiménez','Vargas','EMPLEADO'),(123456789,'1111','marti123','Gonzáles','Castro','CLIENTE');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-24 20:57:13
