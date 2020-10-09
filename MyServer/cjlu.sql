# SQL-Front 5.1  (Build 4.16)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: cjlu
# ------------------------------------------------------
# Server version 5.5.38

#
# Source for table caretable
#

DROP TABLE IF EXISTS `caretable`;
CREATE TABLE `caretable` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `myid` varchar(255) DEFAULT NULL,
  `backid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=gbk;

#
# Dumping data for table caretable
#

LOCK TABLES `caretable` WRITE;
/*!40000 ALTER TABLE `caretable` DISABLE KEYS */;
INSERT INTO `caretable` VALUES (1,'24','1');
INSERT INTO `caretable` VALUES (2,'24','3');
INSERT INTO `caretable` VALUES (5,'24','30');
INSERT INTO `caretable` VALUES (6,'24','28');
INSERT INTO `caretable` VALUES (7,'24','29');
INSERT INTO `caretable` VALUES (8,'1','1');
INSERT INTO `caretable` VALUES (9,'24','24');
INSERT INTO `caretable` VALUES (10,'24','101');
INSERT INTO `caretable` VALUES (11,'111','1');
INSERT INTO `caretable` VALUES (12,'24','111');
INSERT INTO `caretable` VALUES (13,'2','106');
INSERT INTO `caretable` VALUES (14,'2','1');
INSERT INTO `caretable` VALUES (15,'24','106');
INSERT INTO `caretable` VALUES (16,'24','107');
INSERT INTO `caretable` VALUES (17,'24','108');
INSERT INTO `caretable` VALUES (18,'3','3');
INSERT INTO `caretable` VALUES (19,'null','29');
INSERT INTO `caretable` VALUES (20,'','30');
INSERT INTO `caretable` VALUES (21,'1','27');
INSERT INTO `caretable` VALUES (22,'1','27');
INSERT INTO `caretable` VALUES (23,'1','30');
/*!40000 ALTER TABLE `caretable` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table chatcontent
#

DROP TABLE IF EXISTS `chatcontent`;
CREATE TABLE `chatcontent` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) DEFAULT NULL,
  `usercontent` varchar(255) DEFAULT NULL,
  `usernickname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=55 DEFAULT CHARSET=gbk;

#
# Dumping data for table chatcontent
#

LOCK TABLES `chatcontent` WRITE;
/*!40000 ALTER TABLE `chatcontent` DISABLE KEYS */;
INSERT INTO `chatcontent` VALUES (1,'9999999','客服有话说:','客服');
INSERT INTO `chatcontent` VALUES (2,'9999999','大家新年快乐呦!','客服');
INSERT INTO `chatcontent` VALUES (3,'9999999','欢迎来到计量谈！','客服');
INSERT INTO `chatcontent` VALUES (4,'9999999','祝大家玩的开心!','客服');
INSERT INTO `chatcontent` VALUES (5,'9999999','作者：滕皓。','客服');
INSERT INTO `chatcontent` VALUES (6,'24','哈哈','肥牛');
INSERT INTO `chatcontent` VALUES (7,'24','快了吧','肥牛');
INSERT INTO `chatcontent` VALUES (8,'24','应该','肥牛');
INSERT INTO `chatcontent` VALUES (9,'24','yes','肥牛');
INSERT INTO `chatcontent` VALUES (10,'24','呃呃','肥牛');
INSERT INTO `chatcontent` VALUES (11,'24','有毒','肥牛');
INSERT INTO `chatcontent` VALUES (12,'24','真的有毒','肥牛');
INSERT INTO `chatcontent` VALUES (13,'24','唉呀','肥牛');
INSERT INTO `chatcontent` VALUES (14,'24','醉了','肥牛');
INSERT INTO `chatcontent` VALUES (15,'24','什么鬼','肥牛');
INSERT INTO `chatcontent` VALUES (16,'1','很尴尬的','张飒');
INSERT INTO `chatcontent` VALUES (17,'24','讲道理','肥牛');
INSERT INTO `chatcontent` VALUES (18,'24','一样的','肥牛');
INSERT INTO `chatcontent` VALUES (19,'1','哈哈','张飒');
INSERT INTO `chatcontent` VALUES (20,'1','流的一批','张飒');
INSERT INTO `chatcontent` VALUES (21,'1','呃呃呃额额得得得','张飒');
INSERT INTO `chatcontent` VALUES (22,'2','哈哈','李小璐');
INSERT INTO `chatcontent` VALUES (23,'2','厉害的','李小璐');
INSERT INTO `chatcontent` VALUES (24,'2','sfsdsdzhssd烦死人颜色人','李小璐');
INSERT INTO `chatcontent` VALUES (25,'2','哒','李小璐');
INSERT INTO `chatcontent` VALUES (26,'2','什么鬼','李小璐');
INSERT INTO `chatcontent` VALUES (27,'2','总是不排除bu','李小璐');
INSERT INTO `chatcontent` VALUES (28,'2','怪我喽','李小璐');
INSERT INTO `chatcontent` VALUES (29,'1','ee','张飒');
INSERT INTO `chatcontent` VALUES (30,'2','没办法','李小璐');
INSERT INTO `chatcontent` VALUES (31,'2','王者荣耀都有bug','李小璐');
INSERT INTO `chatcontent` VALUES (32,'2','大家好啊','李小璐');
INSERT INTO `chatcontent` VALUES (33,'24','好了','肥牛');
INSERT INTO `chatcontent` VALUES (34,'24','很尴尬','肥牛');
INSERT INTO `chatcontent` VALUES (35,'24','呃','肥牛');
INSERT INTO `chatcontent` VALUES (36,'24','找不到错误了','肥牛');
INSERT INTO `chatcontent` VALUES (37,'1','哈哈','张飒');
INSERT INTO `chatcontent` VALUES (38,'1','有毒','张飒');
INSERT INTO `chatcontent` VALUES (39,'1','王佳琪','张飒');
INSERT INTO `chatcontent` VALUES (40,'112','大家好','akk');
INSERT INTO `chatcontent` VALUES (41,'1','猜猜我是谁','张飒');
INSERT INTO `chatcontent` VALUES (42,'1','拜拜','张飒');
INSERT INTO `chatcontent` VALUES (43,'112','good night','akk');
INSERT INTO `chatcontent` VALUES (44,'1','这么厉害','张飒');
INSERT INTO `chatcontent` VALUES (45,'112','那必须','akk');
INSERT INTO `chatcontent` VALUES (46,'1','我要关服务器了','张飒');
INSERT INTO `chatcontent` VALUES (47,'1','没表情的','张飒');
INSERT INTO `chatcontent` VALUES (48,'112','嗐 没表情不太习惯','akk');
INSERT INTO `chatcontent` VALUES (49,'1','qqq','张飒');
INSERT INTO `chatcontent` VALUES (50,'2','哈哈哈','李小璐');
INSERT INTO `chatcontent` VALUES (51,'1','sbsbsbsbs','张飒');
INSERT INTO `chatcontent` VALUES (52,'2','呃呃呃','李小璐');
INSERT INTO `chatcontent` VALUES (53,'2','呵呵哒','李小璐');
INSERT INTO `chatcontent` VALUES (54,'1','哈哈啊哈','张飒');
/*!40000 ALTER TABLE `chatcontent` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table majorcontent
#

DROP TABLE IF EXISTS `majorcontent`;
CREATE TABLE `majorcontent` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `majorcontent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;

#
# Dumping data for table majorcontent
#

LOCK TABLES `majorcontent` WRITE;
/*!40000 ALTER TABLE `majorcontent` DISABLE KEYS */;
INSERT INTO `majorcontent` VALUES (1,'中国计量学院是我国质量监督检验检疫行业唯一的一所本科院校，是一所计量标准质量检验检疫特色鲜明、多学科协调发展的普通高校。学校坐落于浙江杭州。学校校园环境优美，办学条件优越，拥有教学科研仪器设备总值3.6亿元，纸质图书210万册。设有19个学院（部），举办1所独立学院，有全日制在校普通本科生14600人，研究生1250人，独立学院本科生6530人。');
INSERT INTO `majorcontent` VALUES (2,'测控技术与仪器专业:就业方向：测控技术与仪器专业毕业生主要到国民经济各部门从事测量与控制领域内有关技术、仪器与系统的设计制造、科技开发、应用研究、运行管理等方面的工作。');
INSERT INTO `majorcontent` VALUES (3,'质量管理工程专业:培养目标：本专业紧紧围绕产品质量、工程质量、服务质量领域所急需的应用型质量管理工程人才应具备的知识体系与能力体系的要求，以先进的质量管理理念的形成、质量安全关键技术的突破和质量科学理论的实践为中心');
INSERT INTO `majorcontent` VALUES (4,'食品质量与安全专业:就业方向：食品质量与安全专业毕业生可从事全国各级食品卫生监督部门、食品企业、社区的食品营养与安全服务部门、餐饮业及教学、科研等单位从事食品生产、食品营养与安全的管理、公共营养等方面的工作。');
INSERT INTO `majorcontent` VALUES (5,'知识产权专业:就业方向：知识产权专业毕业生在知识产权管理机构、大型企业、科研院所等单位从事知识产权管理工作；也能在知识产权中介服务机构、律师事务所或人民法院等单位从事知识产权服务工作或审判工作；还能在研究单位从事知识产权或相关的研究工作。');
INSERT INTO `majorcontent` VALUES (6,'电子信息工程专业:专业介绍：电子信息工程是一门应用计算机等现代化技术进行电子信息控制和信息处理的学科，主要研究信息的获取与处理，电子设备与信息系统的设计、开发、应用和集成。电子信息工程专业是集现代电子技术、信息技术、通信技术于一体的专业。');
INSERT INTO `majorcontent` VALUES (7,'机械设计制造及其自动化专业:就业方向：机械设计制造及其自动化专业毕业生可以在工业生产第一线从事机械制造领域内的设计制造、科技开发、应用研究、运行管理和经营销售等方面工作。');
INSERT INTO `majorcontent` VALUES (8,'电气工程及其自动化专业:培养目标：本专业培养能够从事与电气工程有关的系统运行、自动控制、电力电子技术、信息处理、试验分析、研制开发、经济管理以及电子与计算机技术应用等领域工作的宽口径\"复合型\"高级工程技术人才。');
INSERT INTO `majorcontent` VALUES (9,'自动化专业:培养目标：本专业培养的学生要具备电工技术、电子技术、控制理论、自动检测与仪表、信息处理、系统工程、计算机技术与应用和网络技术等较宽广领域的工程技术基础和一定的专业知识的高级工程技术人才。');
INSERT INTO `majorcontent` VALUES (10,'国际经济与贸易专业:就业方向：国际经济与贸易专业的毕业生可以到政府对外贸易经济管理部门从事外贸管理工作，到外贸企业从事对外贸易业务及国际市场的营销工作，到国家机关、国民经济综合部门、商业部门、涉外企业、合资企业、大型工商贸易公司或企业从事贸易经济、市场营销、经营管理工作，到各大高等院校、科研单位从事教学及科研工作等。');
INSERT INTO `majorcontent` VALUES (11,'光信息科学与技术专业:就业方向：光信息科学与技术专业学生毕业后可在应用光学、光电子学及相关的电子信息科学、计算机科学等领域(特别是光机电算一体化产业)从事科学研究、教学、产品设计、生产技术或管理工作。');
/*!40000 ALTER TABLE `majorcontent` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table myusers
#

DROP TABLE IF EXISTS `myusers`;
CREATE TABLE `myusers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `psw` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `myphone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=126 DEFAULT CHARSET=gbk;

#
# Dumping data for table myusers
#

LOCK TABLES `myusers` WRITE;
/*!40000 ALTER TABLE `myusers` DISABLE KEYS */;
INSERT INTO `myusers` VALUES (1,'tt','张飒','12345678911');
INSERT INTO `myusers` VALUES (2,'gg','李小璐','12345678911');
INSERT INTO `myusers` VALUES (3,'ss','詹丹凤','12345678911');
INSERT INTO `myusers` VALUES (24,'hh','肥牛','78945612369');
INSERT INTO `myusers` VALUES (27,'aa','略略','45612345678');
INSERT INTO `myusers` VALUES (28,'ff','李白','11111111111');
INSERT INTO `myusers` VALUES (29,'jj','我是韩信','12345678946');
INSERT INTO `myusers` VALUES (30,'kk','狄仁杰','12437564879');
INSERT INTO `myusers` VALUES (38,'hh','规模婆婆','64645446644');
INSERT INTO `myusers` VALUES (100,'jj','负电荷速度','12345678945');
INSERT INTO `myusers` VALUES (101,'ii','发送','17826833473');
INSERT INTO `myusers` VALUES (102,'uu','好的','12345678944');
INSERT INTO `myusers` VALUES (103,'yy','呃呃','55555555555');
INSERT INTO `myusers` VALUES (104,'hh','哦哦','14576489123');
INSERT INTO `myusers` VALUES (105,'jj','大范甘迪','12345678946');
INSERT INTO `myusers` VALUES (106,'hh','费大概多少','12345678944');
INSERT INTO `myusers` VALUES (107,'uu','水电费','12345678945');
INSERT INTO `myusers` VALUES (108,'uu','速度v','12345678945');
INSERT INTO `myusers` VALUES (109,'uu','阿三大东方大','24345678941');
INSERT INTO `myusers` VALUES (110,'uuu','噢噢噢','11111111111');
INSERT INTO `myusers` VALUES (111,'kk','噗','45612378945');
INSERT INTO `myusers` VALUES (112,'12345678','akk','11111111111');
INSERT INTO `myusers` VALUES (113,'12345678','akm','11111111111');
INSERT INTO `myusers` VALUES (125,'tty','mm','12345678900');
/*!40000 ALTER TABLE `myusers` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table writecircle
#

DROP TABLE IF EXISTS `writecircle`;
CREATE TABLE `writecircle` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `newnickname` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `datetime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `imagepath` varchar(255) DEFAULT NULL,
  `userid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=46 DEFAULT CHARSET=gbk;

#
# Dumping data for table writecircle
#

LOCK TABLES `writecircle` WRITE;
/*!40000 ALTER TABLE `writecircle` DISABLE KEYS */;
INSERT INTO `writecircle` VALUES (1,'噢噢噢','哈哈，我快做完了','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (2,'噗','嗨，你好啊','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (3,'张飒','我做好了','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (4,'詹丹凤','这么好的啊','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (5,'李白','怎么办，好无聊','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (6,'李白','我那么帅','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (7,'速度v','速度快点！','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (8,'狄仁杰','我更帅','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (9,'略略','略略','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (10,'我是韩信','且帅气且珍惜','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (11,'李白','青莲剑歌','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (12,'速度v','我的加速度很大','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (13,'狄仁杰','可惜是各位ADC','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (14,'略略','笨蛋','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (15,'我是韩信','我是刺客','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (16,'李白','我是个战士','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (17,'速度v','我没有计划','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (18,'狄仁杰','我打野','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (19,'略略','我想玩坦克了','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (20,'我是韩信','你是山，我是沙','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (21,'肥牛','酱紫','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (22,'akk','akk','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (23,'akk','啊哈哈','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (24,'mm','呵呵哒','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (25,'张飒','gagasgsagsa','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (26,'张飒','fdgdfg','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (27,'张飒','qqq','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (28,'张飒','qq','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (29,'张飒','ads','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (30,'张飒','aaa','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (31,'张飒','aaaaaaaa','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (32,'张飒','sefasdf是A发色','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (33,'张飒','frqwerwe','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (34,'张飒','dsfsdgsdfg','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (35,'张飒','sdfsd','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (36,'张飒','fewtetr','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (37,'张飒','sdafasdf','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (38,'张飒','dfasdfsdf','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (39,'张飒','sfdasdafdsa','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (42,'张飒','asdfasdfsd','2020-10-03 22:44:28','1601736268845',1);
INSERT INTO `writecircle` VALUES (43,'李小璐','sdfasdf','2020-10-03 22:45:16','1601736316785',2);
INSERT INTO `writecircle` VALUES (44,'李小璐','afsdfsdf','2020-10-03 22:48:28','1601736508578',2);
INSERT INTO `writecircle` VALUES (45,'李小璐','aaa','2020-10-03 22:49:45','1601736585235',2);
/*!40000 ALTER TABLE `writecircle` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
