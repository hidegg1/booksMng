CREATE TABLE if not exists `book_management_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) NOT NULL COMMENT 'TITLE',
  `author` varchar(255) NOT NULL COMMENT 'AUTHOR',
  `versionnumber` varchar(10) NOT NULL COMMENT 'VERSIONNUMBER',
  `isbn` varchar(20) NOT NULL COMMENT 'ISBN',
  `bookscount` int(11) NOT NULL COMMENT 'BOOKSCOUNT',
  `note` varchar(300) DEFAULT NULL COMMENT 'NOTE',
  PRIMARY KEY (`id`)
) COMMENT='book_management_tbl';