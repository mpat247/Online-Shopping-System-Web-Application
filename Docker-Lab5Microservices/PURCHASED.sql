-- MySQL dump 10.19  Distrib 10.3.34-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: PURCHASED
-- ------------------------------------------------------
-- Server version	10.3.27-MariaDB-0+deb10u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CART`
--

DROP TABLE IF EXISTS `CART`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CART` (
  `purchaseDate` date DEFAULT NULL,
  `totalCost` varchar(100) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `cardNum` varchar(30) DEFAULT NULL,
  `cartId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cartId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CART`
--

LOCK TABLES `CART` WRITE;
/*!40000 ALTER TABLE `CART` DISABLE KEYS */;
/*!40000 ALTER TABLE `CART` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CATEGORY`
--

DROP TABLE IF EXISTS `CATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CATEGORY` (
  `categoryName` varchar(250) DEFAULT NULL,
  `categoryID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATEGORY`
--

LOCK TABLES `CATEGORY` WRITE;
/*!40000 ALTER TABLE `CATEGORY` DISABLE KEYS */;
INSERT INTO `CATEGORY` VALUES ('Clothing',1),('Furniture',2),('Gaming',3),('Electronics',4);
/*!40000 ALTER TABLE `CATEGORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INVENTORY`
--

DROP TABLE IF EXISTS `INVENTORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `INVENTORY` (
  `inventoryId` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`inventoryId`),
  UNIQUE KEY `productId` (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INVENTORY`
--

LOCK TABLES `INVENTORY` WRITE;
/*!40000 ALTER TABLE `INVENTORY` DISABLE KEYS */;
INSERT INTO `INVENTORY` VALUES (1,1,29),(2,2,30),(3,3,38),(4,4,65),(5,5,39),(6,6,60),(7,7,15),(8,8,87),(9,9,70),(10,10,45),(11,11,25);
/*!40000 ALTER TABLE `INVENTORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCT`
--

DROP TABLE IF EXISTS `PRODUCT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCT` (
  `productName` varchar(250) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `categoryID` varchar(30) DEFAULT NULL,
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT`
--

LOCK TABLES `PRODUCT` WRITE;
/*!40000 ALTER TABLE `PRODUCT` DISABLE KEYS */;
INSERT INTO `PRODUCT` VALUES ('T-Shirt',7.99,'1',1),('Shoe',27.99,'1',2),('IPad',597.99,'4',3),('PS4',697.99,'4',4),('PS4',697.99,'3',5),('Switch',497.99,'3',6),('Switch',497.99,'4',7),('MacBook',1497.99,'4',8),('Sofa',497.99,'2',9),('Table',297.99,'2',10);
/*!40000 ALTER TABLE `PRODUCT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `username` varchar(250) NOT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `password` varchar(250) NOT NULL,
  `firstName` varchar(250) DEFAULT NULL,
  `lastname` varchar(250) DEFAULT NULL,
  `phoneNum` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES ('yamini2000',NULL,'student1','Yamini','Durasingam',NULL,NULL,1),('manavp',NULL,'student2','Manav','Patel',NULL,NULL,2);
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-14 18:08:03
