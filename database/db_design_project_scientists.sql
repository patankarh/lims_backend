-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: db_design_project
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `scientists`
--

DROP TABLE IF EXISTS `scientists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scientists` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `role` enum('Lead Scientist','Scientist','Research Associate','Senior Scientist') DEFAULT 'Research Associate',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scientists`
--

LOCK TABLES `scientists` WRITE;
/*!40000 ALTER TABLE `scientists` DISABLE KEYS */;
INSERT INTO `scientists` VALUES (1,'Jerry','Seinfeld','superman','comedian!','jseinfeld@yahoo.com','1990-02-01 12:10:30','Lead Scientist'),(2,'Elainey','Benesy','dancermany','Password123!y','ebenes@gmail.comy','1992-10-20 00:00:00','Scientist'),(3,'George','Costanza','artvandelay','password','gconstanze@vandelayindustries.com','1990-02-10 15:14:45','Research Associate'),(4,'Cosmo','Kramer','nostrand','aaaaaa','ckramer@cklein.com','1982-01-09 18:12:23','Scientist'),(5,'Wayne','Newman','knight','Uspsrocks@','newman@gmail.com','1991-08-23 10:19:22','Senior Scientist'),(6,'Frank','Costanza','stillman','Cos123!','fcostanza@gmail.com','1960-05-12 10:45:45','Lead Scientist'),(7,'Leo','Sheridan','theuncle','Watches!!!123&','uncleleo@gmail.com','1965-08-13 11:50:37','Scientist'),(8,'Jeff','Winger','jwinger','Community!@','jwinger@gmail.com','1994-12-10 00:00:00','Research Associate'),(21,'Test Man',NULL,NULL,NULL,NULL,NULL,'Lead Scientist');
/*!40000 ALTER TABLE `scientists` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-14 22:11:05
