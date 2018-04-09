use fantasyweb;

DROP TABLE IF EXISTS `624bill`;

CREATE TABLE `624bill` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `money` double NOT NULL,
  `content` varchar(100) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE webbill(
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `money` double NOT NULL,
  `content` varchar(100) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `administrators`;
CREATE TABLE `adminusers` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sex` enum('男','女','保密') DEFAULT '保密',
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into adminusers(username,password,name) values('fantasy','fantasy','fantasy');