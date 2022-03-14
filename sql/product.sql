CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `product`
--

INSERT INTO `product` VALUES 
	(1,'headphone.jpg','Rose Gold Headphone',399),
	(2,'headphone2.jpg','Black Headphone',199),
	(3,'ipad.jpg','iPad', 599),
	(4,'iphone','iPhone 12',999),
	(5,'laptop.jpg','Silver MacBook',499),
    (6,'monitor.jpg','UHD Monitor',499),
    (7,'laptop2.jpg','MacBook i7',1199),
    (8,'ipad.jpg','iPad 2021',799);

