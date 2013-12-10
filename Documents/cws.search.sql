--
-- Definition of table `cws`.`site_search`
--
DROP TABLE IF EXISTS `cws`.`site_search`;
CREATE TABLE `cws`.`site_search` (
  `search_terms` varchar(100) NOT NULL default '',
  `page_title` varchar(45) NOT NULL default '',
  `page_url` varchar(45) NOT NULL default '',
  `page_desc` varchar(45) NOT NULL default '',
  `page_lang` varchar(45) NOT NULL default '',
  FULLTEXT KEY `search` (`search_terms`,`page_title`,`page_url`,`page_desc`)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8 ROW_FORMAT=COMPACT COLLATE UTF8_GENERAL_CI;

--
-- Dumping data for table `cws`.`site_search`
--
/*!40000 ALTER TABLE `cws`.`site_search` DISABLE KEYS */;
/*!40000 ALTER TABLE `cws`.`site_search` ENABLE KEYS */;
COMMIT;

--
-- Definition of procedure `cws`.`getPageByAttribute`
--
DELIMITER $$
DROP PROCEDURE IF EXISTS `cws`.`getPageByAttribute`$$
/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`appuser`@`localhost` PROCEDURE `cws`.`getPageByAttribute`(
    IN searchTerms VARCHAR(100)
)
BEGIN
    SELECT page_url, page_title,
    MATCH (search_terms, page_title, page_url, page_desc)
    AGAINST (+searchTerms WITH QUERY EXPANSION)
    FROM `cws`.`site_search`
    WHERE MATCH (search_terms, page_title, page_url, page_desc)
    AGAINST (+searchTerms IN BOOLEAN MODE);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;
COMMIT;
