-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version    5.0.51b-community-nt-log
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS cws;
COMMIT;

USE cws;

SOURCE ./cws.email_messaging.sql;
SOURCE ./cws.search.sql;
SOURCE ./cws.products.sql;
SOURCE ./cws.careers.sql;
SOURCE ./cws.news.sql;

COMMIT;

GRANT SELECT,INSERT,UPDATE,DELETE,EXECUTE ON cws.* TO 'appuser'@'localhost' IDENTIFIED BY PASSWORD '*ED66694310AF846C68C9FC3D430B30594837998D';
GRANT SELECT ON `mysql`.`proc` TO 'appuser'@'localhost';

FLUSH PRIVILEGES;
COMMIT;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
