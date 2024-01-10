CREATE DATABASE  pharmacy;
USE pharmacy;
CREATE TABLE `tbl_categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `added_date` datetime NOT NULL,
  `added_by` int NOT NULL,
  `updated_date` datetime NOT NULL,
  `updated_by` int NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

INSERT INTO `tbl_categories` VALUES (1,'PR','Pain reliever','2023-10-16 22:33:03',1,'2023-10-16 22:49:04',4,1),(2,'BPM','Blood pressure medication\n','2023-10-16 22:48:39',4,'2023-10-16 22:48:48',4,1),(3,'Cholesterol','Cholesterol-lowering medication\n','2023-10-16 22:49:28',4,'2023-10-16 22:49:28',4,1),(4,'DM','Diabetes medication\n','2023-10-16 22:49:43',4,'2023-10-16 22:49:43',4,1),(5,'SAR','Stomach acid reducer\n','2023-10-16 22:50:14',4,'2023-10-16 22:50:14',4,1),(6,'AI','Anti-inflammatory\n','2023-10-16 22:50:46',4,'2023-10-16 22:50:46',4,1);

CREATE TABLE `tbl_manufactures` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(500) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `added_date` datetime NOT NULL,
  `added_by` int NOT NULL,
  `updated_date` datetime NOT NULL,
  `updated_by` int NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

INSERT INTO `tbl_manufactures` VALUES (1,'Pfizer Inc','235 East 42nd Street, New York, NY 10017, USA\n','pfizer@gmail.com','+1-3452345','2023-10-16 22:54:12',4,'2023-10-16 22:54:12',4,1),(2,'Johnson & Johnson\n','One Johnson & Johnson Plaza, New Brunswick, NJ 08933, USA\n','jonson@gmail.com','+1-12345678','2023-10-16 22:55:08',4,'2023-10-16 22:55:08',4,1),(3,'Novartis AG\n','Lichtstrasse 35, 4056 Basel, Switzerland\nGlaxoSmithKline (GSK)\n','novartis@gmail.com','087654656','2023-10-16 22:55:46',4,'2023-10-16 22:55:46',4,1);

CREATE TABLE `tbl_stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `qty` int NOT NULL,
  `price` DECIMAL(5,2) NOT NULL,
  `man_id` int NOT NULL,
  `added_date` datetime NOT NULL,
  `added_by` int NOT NULL,
  `updated_date` datetime NOT NULL,
  `updated_by` int NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

INSERT INTO `tbl_stock` VALUES (1,'Aspirin','PR',1000,10,1,'2023-10-16 22:57:27',2,'2023-10-16 22:57:27',2,1),(2,'Lisinopril','BPM',10,100,3,'2023-10-16 23:02:10',2,'2023-10-16 23:02:10',2,1);

CREATE TABLE `tbl_transaction` (
  `id` int unsigned NOT NULL,
  `c_name` varchar(50) NOT NULL,
  `total` DECIMAL(5,2) NOT NULL,
  `added_date` datetime NOT NULL,
  `added_by` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tbl_transaction_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `c_id` int NOT NULL,
  `p_id` int NOT NULL,
  `p_price` DECIMAL(5,2) NOT NULL,
  `qty` int NOT NULL,
  `total` DECIMAL(5,2) NOT NULL,
  `added_date` datetime NOT NULL,
  `added_by` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tbl_users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(70) NOT NULL,
  `dob` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `user_type` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `added_date` datetime NOT NULL,
  `added_by` int NOT NULL,
  `updated_date` datetime NOT NULL,
  `updated_by` int NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 ;

INSERT INTO `tbl_users` VALUES (1,'Pasith','2002-04-24','pasith@gmail.com','pasith','pasith','Male','123','Admin','MInuwangoda','2023-10-16 22:30:21',0,'2023-10-16 22:45:32',1,1),(2,'Supun','2002-05-31','supun@gmail.com','supun','supun','Male','0715868465','Admin','Narammala','2023-10-16 22:31:12',1,'2023-10-16 22:45:48',1,1),(3,'Kalana','2002-11-20','kalana@gmail.com','kalana','kalana','Male','123','User','Galnawa','2023-10-16 22:39:40',2,'2023-10-16 22:42:52',2,1),(4,'Hiruni','2002-03-10','hiruni@gmail.com','hiruni','hiruni','Female','0776545356','Admin','Kurunagala','2023-10-16 22:41:58',2,'2023-10-16 22:46:38',2,1),(5,'dulanjali','2000-08-24','dulanjali@gmail.com','dulanjali','dulanjali','Female','07164583753','User','Kurunagala','2023-10-16 22:44:04',2,'2023-10-16 22:48:00',4,1);
