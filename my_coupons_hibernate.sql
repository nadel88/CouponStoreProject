-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 20, 2014 at 05:28 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `my_coupons_hibernate`
--

-- --------------------------------------------------------

--
-- Table structure for table `coupon`
--

CREATE TABLE IF NOT EXISTS `coupon` (
  `ID` int(11) NOT NULL,
  `BUSINESS_ID` text,
  `IMAGE` varchar(255) DEFAULT NULL,
  `DETAILS` varchar(255) DEFAULT NULL,
  `PRICE` double NOT NULL,
  `EXPIRE` text NOT NULL,
  `CATEGORY` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `coupon`
--

INSERT INTO `coupon` (`ID`, `BUSINESS_ID`, `IMAGE`, `DETAILS`, `PRICE`, `EXPIRE`, `CATEGORY`) VALUES
(1001, 'Pizza Hut', 'images/restaurants/pizza.jpg', 'Hot and Fresh Family Pizza with 2 toppings of your choice.\r\nvalid only for sitting in the restaurants.', 59.99, '10.30.2014 23:00:00', 'restaurants'),
(1002, 'Apple', 'images/electronics/iphone 5.jpg', 'iphone 5 16gb.\r\nget the iphone 5 at a great deal ', 2200, '10.30.2014 23:00:00', 'electronics'),
(1003, 'Apple', 'images/electronics/ipad.jpg', 'Apple iPAD 2 16GB WiFi\r\n', 1300, '10.30.2014 23:00:00', 'electronics'),
(1004, 'Apple', 'images/electronics/macbookpro.jpg', 'Apple MacBook Pro 2.5GHz\r\n', 4200, '10.30.2014 23:00:00', 'electronics'),
(1005, 'LG mobile', 'images/electronics/lg g3.jpg', 'LG G3 32GB D855\r\n', 2500, '30.10.2014 23:00:00', 'electronics'),
(1006, 'LG sound', 'images/electronics/surroundsystem.jpg', '‏LG HB906SB bluray 5.1 surround system\r\n', 2500, '10.30.2014 23:00:00', 'electronics'),
(1007, 'Samsung ', 'images/electronics/television55samsung.png', '‏55 inch UE55H6400 Samsung LED\r\n', 5500, '30.10.2014 23:00:00', 'electronics'),
(1008, 'HP ', 'images/electronics/HP-Pavilion-20-b101ea.jpg', '‏HP pavilion laptop 20b101ea all in one !!!\r\n', 5400, '10.30.2014 23:00:00', 'electronics'),
(1009, 'Mexicana Restaurant', 'images/restaurants/tacos.jpg', 'mexican launch at Mexicana Restaurant in Tel-Aviv.\r\nfull meal includ: main course drinks and desert.', 75, '10.30.2014 23:00:00', 'restaurants'),
(1010, 'Bar Burger', 'images/restaurants/burger.png', 'Bar Burger restaurant offer great deals on a variety of meals.\r\nmeal include: 220-330 g hamburger and a refill soda of your choice.', 80, '10.30.2014 23:00:00', 'restaurants'),
(1011, 'Meat House', 'images/restaurants/meat.jpg', 'Meat House restaurant offer discount launch.\r\nlaunch include one meal(meat or vegetable) two drinks and desert', 89.99, '10.30.2014 23:00:00', 'restaurants'),
(1012, 'Japanica', 'images/restaurants/sushi.jpg', 'Japanica restaurant offer sushi rolls 1+1 free for limited time for take away or in restaurant sitting.', 35, '10.30.2014 23:00:00', 'restaurants'),
(1013, 'MUL YAM Restaurant', 'images/restaurants/schrimps.jpg', 'The luxuriance restaurant mul yam offer a limited time deal for a sea food delights meal.\r\nmeal include: shrimps , wine of your choice and desert.\r\nnote "price is per person"!!!', 150, '10.30.2014 23:00:00', 'restaurants'),
(1014, 'MUL YAM Restaurant', 'images/restaurants/seafood.jpg', 'The luxuriance restaurant mul yam offer a great deal on the well known lobster dish.\r\nnote "price is per person"!!!', 160, '10.30.2014 23:00:00', 'restaurants'),
(1015, 'Cafe Greg', 'images/restaurants/breakfast.jpg', 'Breakfast at Cafe Greg restaurant.\r\nBreakfast include: one omelet , a salad soft drinks and coffee or tea. ', 60, '10.30.2014 23:00:00', 'restaurants'),
(1016, 'Cafe Greg', 'images/restaurants/desert.jpg', 'Free desert for every order above 60 NIS', 60, '10.30.2014 23:00:00', 'restaurants'),
(1017, 'Hadaka Ha 90', 'images/vacation/amsterdam.jpg', 'Hadaka ha 90 offer vacation to the beautiful Amsterdam.\r\noffer include: flights to destination and return , 3 nights at a 4 star hotel and free shuttle service.\r\nonce purchase has completed you will receive a phone call from our representative to schedule', 3000, '10.30.2014 23:00:00', 'vacation'),
(1018, 'EL Al flights', 'images/vacation/eiffeltower.jpg', 'El Al offer flight to paris.\r\noffer include: flights to destination and return in economy class.\r\nonce purchase has completed you will receive a phone call from our representative to schedule dates for the flight.', 1200, '10.30.2014 23:00:00', 'vacation'),
(1019, 'EL Al flights', 'images/vacation/bigben.jpg', 'El Al offer flight to london.\r\noffer include: flights to destination and return in economy class.\r\nonce purchase has completed you will receive a phone call from our representative to schedule dates for the flight.', 1500, '10.30.2014 23:00:00', 'vacation'),
(1020, 'EL Al flights', 'images/vacation/libertystatue.png', 'El Al offer flight to USA.\r\noffer include: flights to destination and return in economy class.\r\nonce purchase has completed you will receive a phone call from our representative to schedule dates for the flight.', 1500, '10.30.2014 23:00:00', 'vacation'),
(1021, 'Jerusalem tours', 'images/vacation/jerusalem.jpg', 'Come to see the old city of jerusalem.\r\na unique tour around the city , get to know the inside and out of this magical city , learn about the history and culture of the city.', 500, '10.30.2014 23:00:00', 'vacation'),
(1022, 'Mano Maritime LTD', 'images/vacation/Yacht.jpg', 'Mano Maritime offer a cruise to cyprus\r\n2 days in the luxuriance state of the art ship', 1250, '10.30.2014 23:00:00', 'vacation'),
(1023, 'Ciema City ', 'images/movies_shows/Theater-Popcorn.jpg', 'Free Popcorn for every ticket purchased only until the end of the month', 35, '10.30.2014 23:00:00', 'movies_shows'),
(1024, 'opera house', 'images/movies_shows/opera.jpg', 'Discounted opera shows only for this month', 60, '10.30.2014 23:00:00', 'movies_shows'),
(1025, 'Leaan Shows Tickets', 'images/movies_shows/concert.jpg', 'special rock concert ticket available until the end of October.', 250, '10.30.2014 23:00:00', 'movies_shows');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `USERNAME` text NOT NULL,
  `PASSWORD` text NOT NULL,
  `PERMISSIONS` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`USERNAME`, `PASSWORD`, `PERMISSIONS`, `ID`) VALUES
('user1', 'user1', 0, 1),
('user2', 'user2', 0, 2),
('nadav', 'nadav', 1, 3),
('user3', 'user3', 0, 4),
('nad88', 'eliyahu', 0, 5),
('test', 'test', 0, 6),
('admin2', 'admin2', 1, 7),
('user4', 'user4', 0, 8);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
