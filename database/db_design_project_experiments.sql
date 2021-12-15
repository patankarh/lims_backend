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
-- Table structure for table `experiments`
--

DROP TABLE IF EXISTS `experiments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experiments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `treatment_type` varchar(45) DEFAULT NULL,
  `date_performed` datetime DEFAULT NULL,
  `notes` varchar(45) DEFAULT NULL,
  `scientist_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiments`
--

LOCK TABLES `experiments` WRITE;
/*!40000 ALTER TABLE `experiments` DISABLE KEYS */;
INSERT INTO `experiments` VALUES (1,'Pancreatic cancer test','CRISPR','2021-01-11 12:13:45','Seems promising',6),(2,'Liver Disease test','CRISPR','2021-01-12 10:10:40','Accidently microwaved samples in this',5),(3,'General Cancer Treatment','RNA Insertion','2021-01-11 11:09:15','Created a zombie virus',5),(4,'Liver regeneration','Stem Cell','2021-02-09 13:08:40','Created two livers',6),(5,'Brain Regeneration','Stem Cell','2021-01-13 13:13:43','Created a small brain somehow',2),(6,'Skin Cancer Test','RNA Insertion','2021-01-08 20:10:09','Works! But skin is now green...',8),(7,'Hepatitis Test 1','CRISPR','2021-02-20 11:09:21','Blood is blue. I prefer it this way.',1),(8,'Hepatitis Test 2','CRISPR','2021-01-20 12:16:40','Blood is red. Didn\'t work though.',2),(9,'Hepatitis Test 3','CRISPR','2021-01-19 13:21:30','Works! Will make a lot of money through this.',4),(10,'Dinosaur resurrection  ','Stem Cell','2021-01-11 11:10:46','Dinosaur nuggets are now real!!!',3),(11,'Extra limb test','Stem Cell','2021-01-10 00:00:00','I now have 7 arms. This is great. Just great!',7);
/*!40000 ALTER TABLE `experiments` ENABLE KEYS */;
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
