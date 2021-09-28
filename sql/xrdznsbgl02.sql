# Host: localhost  (Version: 5.5.47)
# Date: 2020-06-02 09:50:28
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `jobnumber` varchar(255) DEFAULT '',
  `name` varchar(255) DEFAULT '' COMMENT '姓名',
  `department` varchar(255) DEFAULT NULL COMMENT '部门',
  `username` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `power` varchar(255) DEFAULT NULL COMMENT '权限',
  `job` varchar(255) DEFAULT NULL COMMENT '职务',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户管理表';

#
# Data for table "admin"
#

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'GH00001','海燕','信息管理部','admin','e10adc3949ba59abbe56e057f20f883e','1','管理员'),(2,'111','111','111','zzv123','70a4c4dfa9e93c3636a8f83b9d278426','0','111'),(3,'3','张增威','超自然现象研究部','zzv123456','70a4c4dfa9e93c3636a8f83b9d278426','1','部长'),(4,'4','可达鸭','神奇宝贝部','kedaya','25f9e794323b453885f5181f1b624d0b','1','部长');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

#
# Structure for table "equipment"
#

DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `person` varchar(255) NOT NULL DEFAULT '',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `number` varchar(255) DEFAULT '' COMMENT '型号',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='设备表';

#
# Data for table "equipment"
#

INSERT INTO `equipment` VALUES (1,'游戏鼠标','张增威','雷蛇','炼狱蝰蛇'),(2,'笔记本电脑','张增威','联想','拯救者Y7000P'),(3,'智能手机','可达鸭','苹果','iPhone 11 pro max'),(4,'机械键盘','海燕','阿米洛','花旦娘');

#
# Structure for table "loginlog"
#

DROP TABLE IF EXISTS `loginlog`;
CREATE TABLE `loginlog` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `adminid` varchar(255) NOT NULL DEFAULT '',
  `logintime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='登陆日志';

#
# Data for table "loginlog"
#

INSERT INTO `loginlog` VALUES (1,'1','2020-05-19 16:52:35','223.98.221.172'),(2,'1','2020-05-19 18:24:03','223.98.221.172'),(3,'4','2020-05-19 18:45:36','223.98.221.172'),(4,'1','2020-05-20 14:27:34','223.98.221.172');
