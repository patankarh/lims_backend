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
-- Table structure for table `samples`
--

DROP TABLE IF EXISTS `samples`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `samples` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `organism` varchar(45) DEFAULT NULL,
  `tissue_origin` varchar(45) DEFAULT NULL,
  `dna_sequence` varchar(1000) DEFAULT NULL,
  `disease` varchar(45) DEFAULT NULL,
  `vendor` varchar(45) DEFAULT NULL,
  `notes` varchar(45) DEFAULT NULL,
  `experiment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `samples`
--

LOCK TABLES `samples` WRITE;
/*!40000 ALTER TABLE `samples` DISABLE KEYS */;
INSERT INTO `samples` VALUES (1,'HS-1','homo sapien','pancreas','tgcaccaaacatgtctaaagctggaaccaaaattactttctttgaagacaaaaactttca\naggccgccactatgacagcgattgcgactgtgcagatttccacatgtacctgagccgctg\ncaactccatcagagtggaaggaggcacctgggctgtgtatgaaaggcccaattttgctgg\ngtacatgtacatcctaccccggggcgagtatcctgagtaccagcactggatgggcctcaa\ncgaccgcctcagctcctgcagggctgttcacctgtctagtggaggccagtataagcttca\ngatctttgagaaaggggattttaatggtcagatgcatgagaccacggaagactgcccttc\ncatcatggagcagttccacatgcgggaggtccactcctgtaaggtgctggagggcgcctg\ngatcttctatgagctgcccaactaccgaggcaggcagtacctgctggacaagaaggagta\nccggaagcccgtcgactggggtgcagcttccccagctgtccagtctttccgccgcattgt\nggagtgatgatacagatgcggccaaacgctggctggccttgtcatccaaataagcattat\naaataaaacaattggcatgc','cancer','Organic Samples',NULL,1),(2,'HS-2','homo sapien','pancreas','cgccactatgacagcgattgcgactgtgcagatttccacatgtacctgagccgctg\ncaactccatcagagtggaaggaggcacctgggctgtgtatgaaaggcccaattttgctgg\ngtacatgtacatcctaccccggggcgagtatcctgagtaccagcactggatgggcctcaa\ncgaccgcctcagctcctgca','cancer','Organs R Us',NULL,1),(3,'BL-1','Papio','liver','tggagcagttccacatgcgggaggtccactcctgtaaggtgctggagggcgcctg\ngatcttctatgagctgcccaactaccgaggcaggcagtacctgctggacaagaaggagta\nccggaagcccgtcg','liver disease','Organs R Us','Baboon sample?',2),(4,'HL-1','homo sapien','liver','gacagcgattgcgactgtgcagatttccacatgtacctgagccgctg\ncaactccatcagagtggaaggaggcacctgggctgtgtatgaaaggcccaattttgctgg\ngtacatgtacatcctaccccggggcgagtatcctgagtaccagcactggatgggcctcaa\ncgaccgcctcagctcctgcagggctgttcacctgtctagtggaggccagtataagcttca\ngatctttgagaaaggggattttaatggtcagatgcatgagaccacggaagactgcccttc\ncatcatggagcagttccacatgcggga','liver disease','Organs R Us',NULL,2),(5,'HS-1','homo sapien','skin','ctggggtgcagcttccccagctgtccagtctttccgccgcattgt\nggagtgatgatacagatgcggccaaacgctggctggccttgtcatccaaataagcattat\naaataaaacaattggcatgc','cancer','Organic Samples',NULL,3),(6,'HLU-1','homo sapien','lung','cgcgcgcttcgactgcgatagtgtccgcgtccgtacggtgtaacaatttagcccctttag\natagcaggtcaccttctcgtttccacaccaccggttcatagcgccaaccctactagaatg\ntcccgtaagcgataaccacttacacttatcctctggtcccactccattaacgtaaagcac\ngcgcattattgtcacaaggcagaagccctccaagagagccgcatgtagacgtaatcttca\nagtgcgttgtcgtcgcta','cancer','Organic Samples','dropped on the floor',3),(7,'HLU-3','homo sapien','lung','taatagatctgtacatactcgaacaagaagtacaatggtttgcctagtagta\nttgggctcgggcttctcatccctacgatcccatccctgtatacagaagaacgggcgtcag\nttcacggggacccccctggttcgtcccagggccagagatatctaatgtatctttagtgta\naaagttacgactagacac','cancer','Organic Samples','dropped on the floor',3),(8,'HL-2','homo sapien','liver','ggcctttatctctacgagcgtcgactccctgacgaaggacgcctccga\ngcgatacaggtcttcttttaccgtttcgaagttgcgagtactcggatcgggacaggaata\nggtgctggcaagcggcagagctacacggcgcccaaatgagtattcctcgctgcccctagc\naagattaagcctgcctgcgtaac',NULL,'Organs R Us',NULL,4),(9,'HB-1','homo sapien','brain','cgtaaggttaatagatctgtacatactcgaacaagaagtacaatggtttgcctagtagta\nttgggctcgggcttctcatccctacgatcccatccctgtatacagaagaacgggcgtcag\nttcacggggacccccctggttcgtcccagggccagagatatctaatgtatctttagtgta\naaagttacgactagacactattaacggcaggctactttgtcgaaacaccagaccatcttc',NULL,'Organs R Us',NULL,5),(10,'SKIN-1','homo sapien','skin','agctacacggcgcccaaatgagtattcctcgctgcccctagc\naagattaagcctgcctgcgtaacgattatacctggtaggagtagctatcagagaaatgca\ntagtttggatgctttagcaatgcttatccaacctgtacagtgtggcctctgaatactatg\ntgcagactacgcgttagtcctgctgtt','cancer','Organs R Us','had a tattoo',6),(11,'HEP-1','homo sapien','blood','tccaacctgtacagtgtggcctctgaatactatg\ntgcagactacgcgttagtcctgctgttactagtctatacggccggccaggcttctgctag\ntggagatcggcgacagaacttgttgagtacagtttccca','hepatitus A','Organs R Us',NULL,7),(12,'HEP-2','homo sapien','blood','ttcgccgaaacgagaggagcatatcctgggttgccagctgtcaattcagtcgaa\ngggcgtcgacagaacc','hepatitus A','Organs R Us',NULL,7),(13,'HEP-3','homo sapien','blood','cgatgcacatgctctagcaaatgatatggcgaatcgccaagttatgagtgt\naatactaatgcttgagtgggaaacaggaaagtttaactaagtaacagccccgggtagacc\ncgtcgattacctattattctatcagtaggatgatccgctaagcttctagaagaacctgga\nagggtttgcagatggcggacaggtctcggatcattacttctaagggaccatcggggagcg\natgatatattacgtcgca','hepatitus A','Organs R Us',NULL,8),(14,'HEP-4','homo sapien','blood','agcttacctcataatgatcggccgattcacttg\nacaaaagactaaccttcagtacaataaatagattctttaccttcgatgtaacgcaaatga\nacggctcacagactaggttggggccgcccgctgtcgttccgagttccccttaccacatac\nttctcgctaggtttgcgcgaacaaccgtcgttacggtctcgtaagcgatcgttaacgggt\naatgctaacgaacctgttgacttcgggccccacatcttcaca','hepatitus A','Organs R Us',NULL,8),(15,'HEP-5','homo sapien','blood','atgtgatgcactgtctaacttcaacttagccatgggccct\naaagtccccttgcaagccttctacggggggttatggctgtatatcgttatagcgataatc\ngggctgggcgtggaattactacctcggttcgttagctaagggtgacgggtgattcaccgt\ncgtttggagcgatgcacatgctctagcaa','hepatitus B','Organs R Us',NULL,9),(16,'HEP-6','homo sapien','blood','caggaaagtttaactaagtaacagccccgggtagacc\ncgtcgattacctattattctatcagtaggatgatccgctaagcttctagaagaacctgga\nagggtttgcagatggcggacaggtctcggatcattacttctaagggaccatcggggagcg\natgatatattacgtcgcaggccaggttagcttacctcataatgatcggccgattcacttg\nacaaaagactaaccttcagtacaataaatagattctttaccttcgatgtaacgcaaatga\nacggctcacagactaggttggggccgcccgctgtcgttccgagttccccttaccacatac\nttctcgctaggtttgcgcgaacaaccgtcgttacggtctcgtaagcgatcgttaacgggt\naatgctaacgaacctgttgacttcgggccccacatcttca','hepatitus B','Organs R Us',NULL,9),(17,'Dino sample','Tyrannosaurus rex','brain','ttttaactgagaagtaagaaggtcttgcgggctattcagaatgcccaagccgacaaagca\ngcagtcttcgccgaaacgagaggagcatatcctgggttgccagctgtcaattcagtcgaa\ngggcgtcgacagaaccgaatagatgtgttagggcggcctcgcagtagatgaggcattgta\nagtatcggggcggagatactggtcacaacgtgaataatattccctctgatctcatcgtct\ncgcaggcctttccatgaagtatgtgatgcactgtctaacttcaacttagccatgggccct\naaagtccccttgcaagccttctacggggggttatggctgtatatcgttatagcgataatc\ngggctgggcgtggaattactacctcggttcgttagctaagggtgacgggtgattcaccgt\ncgtttggagcgatgcacatgc',NULL,'Jurassic Park','Found encoated in amber',10),(18,'HA-1','homo sapien','blood','gcaagccttctacggggggttatggctgtatatcgttatagcgataatc\ngggctgggcgtggaattactacctcggttcgttagctaagggtgacgggtgattcaccgt\ncgtttggagcgatgcacatgctctagcaaatgatatggcgaatcgccaagttatgagtgt\naatactaatgcttgagtgggaaacaggaaagtttaactaagtaacagccccgggtagacc\ncgtcgattacctattattctatcagtaggatgatccgctaagcttctagaagaacctgga\nagggtttgcagatggcggacaggtctcggatcattacttctaagggaccatcggggagcg\natgatatattacgtcgcaggccaggttagcttacctcataatgatcggccgattcacttg\nacaaaagactaaccttcagtacaataaatagattctttaccttcgatgtaacgcaaatga\nacggctcacagactaggttggggccgcccgctgtcgttccgagttccccttaccacatac\nttctcgctaggtttgcgcgaacaaccgtcgttacggtctcgtaagcgatcgttaacgggt\naatgctaacgaacctgttgacttcgggccccacatcttcacacaattaggactttctaaa\ncagagtgtatgttaaatcaccgctcccgtagaacaccttc',NULL,'Organic Samples','From an arm',11);
/*!40000 ALTER TABLE `samples` ENABLE KEYS */;
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
