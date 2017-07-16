-- Script de la base de datos con algunos insert de prueba
--
CREATE DATABASE  IF NOT EXISTS `ProyectoIntegradoBd` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ProyectoIntegradoBd`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ProyectoIntegradoBd
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido1` varchar(50) NOT NULL,
  `apellido2` varchar(50) NOT NULL,
  `cp` int(5) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `disponibilidad` int(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `email2` varchar(255) DEFAULT NULL,
  `fecha_nac` date NOT NULL,
  `localidad` varchar(25) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `provincia` varchar(25) NOT NULL,
  `telefono` int(10) NOT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'Llorente','Corral',41020,'C/Hilanderas',0,'alejandrollorentecorral@gmail.com',NULL,'1988-02-19','Sevilla','Alejandro',NULL,'Sevilla',660065564,1);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_aptitud`
--

DROP TABLE IF EXISTS `alumno_aptitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_aptitud` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nivel` varchar(15) DEFAULT NULL,
  `alumno_id` int(11) DEFAULT NULL,
  `aptitud_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `alumno_id` (`alumno_id`),
  KEY `aptitud_id` (`aptitud_id`),
  CONSTRAINT `alumno_aptitud_ibfk_1` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `alumno_aptitud_ibfk_2` FOREIGN KEY (`aptitud_id`) REFERENCES `aptitud` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_aptitud`
--

LOCK TABLES `alumno_aptitud` WRITE;
/*!40000 ALTER TABLE `alumno_aptitud` DISABLE KEYS */;
INSERT INTO `alumno_aptitud` VALUES (1,'alto',1,1),(2,'medio',1,2),(3,'bajo',1,3),(4,'alto',1,4),(5,'alto',1,5);
/*!40000 ALTER TABLE `alumno_aptitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_ciclo`
--

DROP TABLE IF EXISTS `alumno_ciclo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_ciclo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `annio_fin` date DEFAULT NULL,
  `alumno_id` int(11) DEFAULT NULL,
  `ciclo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `alumno_id` (`alumno_id`),
  KEY `ciclo_id` (`ciclo_id`),
  CONSTRAINT `alumno_ciclo_ibfk_1` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `alumno_ciclo_ibfk_2` FOREIGN KEY (`ciclo_id`) REFERENCES `ciclo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_ciclo`
--

LOCK TABLES `alumno_ciclo` WRITE;
/*!40000 ALTER TABLE `alumno_ciclo` DISABLE KEYS */;
INSERT INTO `alumno_ciclo` VALUES (1,'2017-01-01',1,1);
/*!40000 ALTER TABLE `alumno_ciclo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_ot`
--

DROP TABLE IF EXISTS `alumno_ot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_ot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `annio_fin` date DEFAULT NULL,
  `alumno_id` int(11) DEFAULT NULL,
  `ot_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `alumno_ot` (`ot_id`),
  KEY `alumno_id` (`alumno_id`),
  CONSTRAINT `alumno_ot_ibfk_1` FOREIGN KEY (`ot_id`) REFERENCES `ot` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `alumno_ot_ibfk_2` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_ot`
--

LOCK TABLES `alumno_ot` WRITE;
/*!40000 ALTER TABLE `alumno_ot` DISABLE KEYS */;
INSERT INTO `alumno_ot` VALUES (1,'2017-01-01',1,1);
/*!40000 ALTER TABLE `alumno_ot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aptitud`
--

DROP TABLE IF EXISTS `aptitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aptitud` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aptitud`
--

LOCK TABLES `aptitud` WRITE;
/*!40000 ALTER TABLE `aptitud` DISABLE KEYS */;
INSERT INTO `aptitud` VALUES (1,'Java'),(2,'Php'),(3,'Sql'),(4,'Xml'),(5,'Bootstrap'),(6,'Ingles'),(7,'Angular'),(8,'Spring'),(9,'Jsf');
/*!40000 ALTER TABLE `aptitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centro`
--

DROP TABLE IF EXISTS `centro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `centro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centro`
--

LOCK TABLES `centro` WRITE;
/*!40000 ALTER TABLE `centro` DISABLE KEYS */;
INSERT INTO `centro` VALUES (1,'Universidad de Sevilla'),(2,'Universidad Pablo de Olavide');
/*!40000 ALTER TABLE `centro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciclo`
--

DROP TABLE IF EXISTS `ciclo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciclo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `siglas` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciclo`
--

LOCK TABLES `ciclo` WRITE;
/*!40000 ALTER TABLE `ciclo` DISABLE KEYS */;
INSERT INTO `ciclo` VALUES (1,'Desarrollo de Aplicaciones Web','DAW'),(2,'Administracion Sistemas Informaticos y Redes','ASIR'),(3,'Sistemas Microinformaticos y Redes','SMR'),(4,'Mediación Comunicativa','MCO'),(5,'Animación Sociocultural y Turística','ASCT'),(6,'Atención a Personas en Situación de Dependencia','APSD'),(7,'Sistemas de Telecomunicación e Informáticos','STI'),(8,'Instalaciones Eléctricas y Automáticas','IEA'),(9,'Gestión Administrativa','GA'),(10,'Electromecánica de Vehículos Automóviles','EVA');
/*!40000 ALTER TABLE `ciclo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ot`
--

DROP TABLE IF EXISTS `ot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `siglas` varchar(10) NOT NULL,
  `centro_id` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `centro_id` (`centro_id`),
  CONSTRAINT `ot_ibfk_1` FOREIGN KEY (`centro_id`) REFERENCES `centro` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ot`
--

LOCK TABLES `ot` WRITE;
/*!40000 ALTER TABLE `ot` DISABLE KEYS */;
INSERT INTO `ot` VALUES (1,'ISC',1,'Ingeniero en Sistemas Computacionales'),(2,'siglas',1,'nombre completo'),(3,'pepe',2,'pepepepepepe');
/*!40000 ALTER TABLE `ot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `redes`
--

DROP TABLE IF EXISTS `redes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `redes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link` varchar(255) NOT NULL,
  `alumno_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `alumno_id` (`alumno_id`),
  CONSTRAINT `redes_ibfk_1` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `redes`
--

LOCK TABLES `redes` WRITE;
/*!40000 ALTER TABLE `redes` DISABLE KEYS */;
INSERT INTO `redes` VALUES (1,'http://www.facebook.com',1),(2,'http://www.google+.com',1);
/*!40000 ALTER TABLE `redes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contrasena` varchar(20) NOT NULL,
  `rol_profesor` int(1) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Alejandro7',0,'alellc'),(2,'admin',1,'admin'),(3,'a',1,'a');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-22  0:50:23
