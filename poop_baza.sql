-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 30, 2021 at 02:39 PM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `poop_baza`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `ime`, `username`, `password`) VALUES
(1, 'admin1', 'admin1', 'admin1');

-- --------------------------------------------------------

--
-- Table structure for table `oglas`
--

DROP TABLE IF EXISTS `oglas`;
CREATE TABLE IF NOT EXISTS `oglas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `radna_pozicija` varchar(50) NOT NULL,
  `opis` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_poslodavca` int NOT NULL,
  `kategorija` varchar(50) NOT NULL,
  `podkategorija` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `oglas`
--

INSERT INTO `oglas` (`id`, `radna_pozicija`, `opis`, `id_poslodavca`, `kategorija`, `podkategorija`) VALUES
(1, 'Java Junior Developer', 'Opis za JAVA JUNIOR', 3, 'Programer', 'Java programer'),
(2, 'Java Senior Developer', 'Opis za JAVA SENIOR', 2, 'Programer', 'Java programer'),
(3, 'C Junior Developer', 'Opis za C JUNIOR', 3, 'Programer', 'C programer'),
(8, 'System Administrator', 'System Administrator', 2, 'Administracija', 'Administracija');

-- --------------------------------------------------------

--
-- Table structure for table `poslodavac`
--

DROP TABLE IF EXISTS `poslodavac`;
CREATE TABLE IF NOT EXISTS `poslodavac` (
  `id` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  `opis` varchar(200) NOT NULL,
  `delatnost` varchar(50) NOT NULL,
  `sediste` varchar(50) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `poslodavac`
--

INSERT INTO `poslodavac` (`id`, `naziv`, `opis`, `delatnost`, `sediste`, `username`, `password`) VALUES
(2, 'Naziv poslodavca 2', 'Neki opis za poslodavca 2', 'Programiranje', 'Novi Sad', 'pos1', 'pos1'),
(3, 'Naziv poslodavca 3', 'Neki opis za poslodavca 3', 'Programiranje', 'Beograd', 'pos2', 'pos2'),
(5, 'Naziv poslodavca 4', 'Neki opis za poslodavca 4', 'Programiranje', 'Beograd', 'pos4', 'pos4'),
(6, 'Firma', 'Opis Firme', 'Administracija', 'Kragujevac', 'Poslodavac1', 'sifra');

-- --------------------------------------------------------

--
-- Table structure for table `prijavaoglas`
--

DROP TABLE IF EXISTS `prijavaoglas`;
CREATE TABLE IF NOT EXISTS `prijavaoglas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `oglas` int NOT NULL,
  `radnik` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `prijavaoglas`
--

INSERT INTO `prijavaoglas` (`id`, `oglas`, `radnik`) VALUES
(7, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `radnik`
--

DROP TABLE IF EXISTS `radnik`;
CREATE TABLE IF NOT EXISTS `radnik` (
  `id` int NOT NULL AUTO_INCREMENT,
  `imeprez` varchar(100) NOT NULL,
  `kvalifikacije` varchar(100) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `radnik`
--

INSERT INTO `radnik` (`id`, `imeprez`, `kvalifikacije`, `username`, `password`) VALUES
(1, 'Pera Petrovic', 'Neke kvalifikacije za Peru', 'pera', 'peric'),
(2, 'Marko Markovic', 'Neke kvalifikacije za Marka', 'marko', 'markovic'),
(3, 'Rade Radovic', 'Neke kvalifikacije za Radeta', 'rade', 'radovic'),
(4, 'Jovan Jovovic', 'Neke kvalifikacije za Jovana', 'jovan', 'jovovic');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
