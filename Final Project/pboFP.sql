-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for coretax_db
CREATE DATABASE IF NOT EXISTS `coretax_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `coretax_db`;

-- Dumping structure for table coretax_db.users
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table coretax_db.users: ~3 rows (approximately)
REPLACE INTO `users` (`username`, `password`, `role`) VALUES
	('admin', 'admin123', 'admin'),
	('budi', 'budi123', 'customer'),
	('siti', 'siti123', 'customer');

-- Dumping structure for table coretax_db.wajib_pajak
CREATE TABLE IF NOT EXISTS `wajib_pajak` (
  `npwp` varchar(20) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `penghasilan_tahunan` double DEFAULT NULL,
  `pajak_terutang` double DEFAULT NULL,
  `status` varchar(20) DEFAULT 'Belum Lunas',
  PRIMARY KEY (`npwp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table coretax_db.wajib_pajak: ~4 rows (approximately)
REPLACE INTO `wajib_pajak` (`npwp`, `nama`, `penghasilan_tahunan`, `pajak_terutang`, `status`) VALUES
	('0050321', 'aqil', 360000000, 36000000, 'Lunas'),
	('123456789', 'Budi Santoso', 120000000, 12000000, 'Belum Lunas'),
	('442211', 'dicky', 100000000, 10000000, 'Belum Lunas'),
	('987654321', 'Siti Aminah', 250000000, 25000000, 'Belum Lunas');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
