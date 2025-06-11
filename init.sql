CREATE DATABASE  IF NOT EXISTS `ContactRegistry` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ContactRegistry`;


DROP TABLE IF EXISTS `contacts`;

CREATE TABLE `contacts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_names` varchar(250) NOT NULL,
  `phone_number` int NOT NULL,
  `id_number` int DEFAULT NULL,
  `date_of_brith` date DEFAULT NULL,
  `gender` enum('MALE','FEMALE','NONBINARY') DEFAULT NULL,
  `county` varchar(250) DEFAULT NULL,
  `email_address` varchar(100) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
    `idfile` varchar(250),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `contacts` WRITE;
INSERT INTO `contacts` VALUES (1,'genderfinaltest null null',55658,0,'2025-05-23','MALE','County1','genderTesr@final.norepeat',NULL),(2,'grifins okoth',72355868,NULL,NULL,NULL,NULL,NULL,NULL),(3,'brian null',545888,2384848,'1970-01-01',NULL,'Maasai',NULL,NULL),(4,'brian motari null',703492461,9975767,'1970-01-01',NULL,'Mombasa',NULL,NULL),(5,'bee null',87854587,8751458,NULL,NULL,'kilifi',NULL,0),(6,'bravoo null',58789657,7895426,NULL,NULL,'Msa',NULL,0),(7,'bravoo null',58789657,7895426,NULL,NULL,'Msa',NULL,0),(8,'bravoo null',58789657,7895426,NULL,NULL,'Msa',NULL,0),(35,'Test User 1',710000001,10000001,'1990-01-01','MALE','county1','user1@example.com',1),(36,'Test User 2',710000002,10000002,'1991-01-02','FEMALE','county2','user2@example.com',2),(37,'Test User 3',710000003,10000003,'1992-01-03','NONBINARY','county3','user3@example.com',3),(38,'Test User 4',710000004,10000004,'1993-01-04','MALE','county1','user4@example.com',4),(39,'Test User 5',710000005,10000005,'1994-01-05','FEMALE','county2','user5@example.com',5),(40,'Test User 6',710000006,10000006,'1995-01-06','NONBINARY','county3','user6@example.com',1),(41,'Test User 7',710000007,10000007,'1996-01-07','MALE','county1','user7@example.com',2),(42,'Test User 8',710000008,10000008,'1997-01-08','FEMALE','county2','user8@example.com',3),(43,'Test User 9',710000009,10000009,'1998-01-09','NONBINARY','county3','user9@example.com',4),(44,'Test User 10',710000010,10000010,'1999-01-10','MALE','county1','user10@example.com',5);
UNLOCK TABLES;


DROP TABLE IF EXISTS `userrs`;

CREATE TABLE `userrs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(250) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `role` varchar(23) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
);

LOCK TABLES `userrs` WRITE;
INSERT INTO `userrs` VALUES (1,'motaribrian','motaribrian@123',NULL),(2,'attachment','password_attachment',NULL),(3,'admin','adminpass123','ADMIN'),(4,'user1','user1pass','USER'),(5,'user2','user2pass','USER'),(6,'user3','user3pass','USER'),(7,'guest','guestpass','GUEST');
UNLOCK TABLES;
