-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bankmanagementsystem
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank` (
  `pin` varchar(10) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES ('2001','Mon Sep 11 18:40:31 IST 2023','Deposit','10000.0'),('2001','Mon Sep 11 18:40:44 IST 2023','Withdrawal','5000'),('2001','Mon Sep 11 18:40:53 IST 2023','Withdrawal','100.0'),('2001','Mon Sep 11 18:41:24 IST 2023','Withdrawal','1000.0'),('2001','Mon Sep 11 18:41:58 IST 2023','Withdrawal','2000.0'),('2001','Mon Sep 11 18:48:40 IST 2023','Deposit','2000.0'),('2001','Mon Sep 11 18:48:46 IST 2023','Withdrawal','1000'),('2001','Mon Sep 11 18:48:56 IST 2023','Withdrawal','600.0'),('2001','Mon Sep 11 18:57:23 IST 2023','Withdrawal','600.0'),('2001','Mon Sep 11 19:06:13 IST 2023','Deposit','300.0'),('2001','Mon Sep 11 19:06:23 IST 2023','Withdrawal','600.0'),('2001','Mon Sep 11 19:09:31 IST 2023','Deposit','600.0'),('2001','Mon Sep 11 19:09:51 IST 2023','Withdrawal','2000.0'),('2001','Mon Sep 11 20:13:10 IST 2023','Deposit','20001.0'),('2001','Mon Sep 11 20:13:16 IST 2023','Withdrawal','1'),('2001','Mon Sep 11 20:13:25 IST 2023','Withdrawal','2000.0'),('4001','Mon Sep 11 21:10:34 IST 2023','Deposit','1000.0'),('193','Tue Oct 03 20:32:51 IST 2023','Deposit','700.0'),('193','Tue Oct 03 20:33:46 IST 2023','Deposit','300.0'),('193','Tue Oct 03 20:33:54 IST 2023','Withdrawal','100'),('5671','Tue Oct 03 20:41:13 IST 2023','Deposit','100.0'),('5671','Tue Oct 03 20:42:03 IST 2023','Withdrawal','50');
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `formno` varchar(20) DEFAULT NULL,
  `cardnumber` varchar(255) DEFAULT NULL,
  `pinnumber` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('','5040936083610146','4053'),('906','5040936085760872','2001'),('','5040935977705015','553'),('4398','5040935967833391','503'),('721','5040936029410535','4001'),('5978','5040935926090769','193'),('8130','5040936050252308','5671');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signup` (
  `formno` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `guardian` varchar(20) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `marital` varchar(20) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `pin` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup`
--

LOCK TABLES `signup` WRITE;
/*!40000 ALTER TABLE `signup` DISABLE KEYS */;
INSERT INTO `signup` VALUES ('2671','Upayan Sarkar','Uttam Sarkar','05-Feb-2001','Male','imupayan5@gmail.com','Single','6 No, Deshbandhu Pally','Naihati','West Bengal','743165'),('1559','UK','RT','13-Sep-2023','Male','ASEDX23@gmail.com','Single','dg','szfd','Goa','765432'),('889','Rajesh Rao','Prajesh Rao','11-Sep-1947','Male','prajesh23@gmail.com','Married','bigbazar','mussourie','Madhya Pradesh','745354'),('9403','Ritwik Roy','Anup Roy','22-Jul-2006','Male','anup.R301@gmail.com','Single','Kultala','Howrah','West Bengal','746789'),('906','us','fd','01-Sep-2023','Male','cafaszc@gmail.com','Married','SDdx','cDcs','Arunachal Pradesh','786533'),('2086','riya roy','prajesh roy','22-Jul-1999','Female','riya345@gmail.com','Single','kalighat','kolkata','West Bengal','735476'),('4398','MAOSH','MAOF','14-Sep-2023','Male','RFASF542@gmail.com','Single','asf','sfs','Gujarat','764643'),('721','Ramcharan Das','Ram Das','30-Jun-1978','Male','ramcharan567@gmail.com','Married','7 No, BT Road','Satraganchi','Bihar','743265'),('5978','rajesh rao','umesh rao','05-Oct-2023','Male','umesh43@gmail.com','Single','kolkata','kolkata','West Bengal','786556'),('8130','md prajesh','md khatum','01-Oct-1777','Male','md4564@gmail.com','Married','lahore','lahore','Punjab','976475');
/*!40000 ALTER TABLE `signup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signupthree`
--

DROP TABLE IF EXISTS `signupthree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signupthree` (
  `formno` varchar(20) DEFAULT NULL,
  `accountType` varchar(255) DEFAULT NULL,
  `cardnumber` varchar(255) DEFAULT NULL,
  `pinnumber` varchar(255) DEFAULT NULL,
  `facility` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signupthree`
--

LOCK TABLES `signupthree` WRITE;
/*!40000 ALTER TABLE `signupthree` DISABLE KEYS */;
INSERT INTO `signupthree` VALUES ('','Saving Account','5040936029252004','6050','ATM CARD, E-Statement'),('','Saving Account','5040936083610146','4053','E-Statement'),('906','Saving Account','5040936085760872','2001','ATM CARD, Mobile Banking, Cheque Book'),('','Recurring Deposit Account','5040935977705015','553','Internet Banking, Mobile Banking'),('4398','Current Account','5040935967833391','503','ATM CARD, Internet Banking, Mobile Banking, Email & SMS Alerts, Cheque Book, E-Statement'),('721','Fixed Deposit Account','5040936029410535','4001','ATM CARD, Internet Banking, Mobile Banking, Email & SMS Alerts, Cheque Book, E-Statement'),('5978','Fixed Deposit Account','5040935926090769','193','ATM CARD, Internet Banking, Mobile Banking, Email & SMS Alerts, Cheque Book, E-Statement'),('8130','Fixed Deposit Account','5040936050252308','5671','ATM CARD, Internet Banking, Mobile Banking, Email & SMS Alerts, Cheque Book, E-Statement');
/*!40000 ALTER TABLE `signupthree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signuptwo`
--

DROP TABLE IF EXISTS `signuptwo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signuptwo` (
  `formno` varchar(20) DEFAULT NULL,
  `religion` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `income` decimal(10,2) DEFAULT NULL,
  `education` varchar(50) DEFAULT NULL,
  `occupation` varchar(50) DEFAULT NULL,
  `pan` varchar(10) DEFAULT NULL,
  `aadhar` varchar(12) DEFAULT NULL,
  `senior_citizen` enum('Yes','No') DEFAULT NULL,
  `existing_account` enum('Yes','No') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signuptwo`
--

LOCK TABLES `signuptwo` WRITE;
/*!40000 ALTER TABLE `signuptwo` DISABLE KEYS */;
INSERT INTO `signuptwo` VALUES ('','Hindu','ST',999.00,'High School','Student','MQYPS4102B','456598785678','Yes','Yes'),('1559','Muslim','OBC',646.00,'High School','Business','MQYPS4102B','678723453211','No','No'),('889','Hindu','ST',197654.00,'Other','Business','MQYPS5326D','987856643494','Yes','Yes'),('906','Muslim','Other',5352352.00,'PhD','Business','MQYPS4102B','345478659878','No','Yes'),('4398','Muslim','General',6356.00,'High School','Service','MQYPS4102B','789876434565','Yes','No'),('721','Hindu','SC',700000.00,'PhD','Service','MQYPS4304B','345467876545','Yes','No'),('5978','Hindu','General',6355355.00,'High School','Business','MQYPS4102B','678745652312','No','Yes'),('8130','Muslim','Other',6000.00,'PhD','Service','MQYPS5104B','986778653412','Yes','No');
/*!40000 ALTER TABLE `signuptwo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-07 20:09:01
