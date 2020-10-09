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
INSERT INTO `chatcontent` VALUES (1,'9999999','�ͷ��л�˵:','�ͷ�');
INSERT INTO `chatcontent` VALUES (2,'9999999','������������!','�ͷ�');
INSERT INTO `chatcontent` VALUES (3,'9999999','��ӭ��������̸��','�ͷ�');
INSERT INTO `chatcontent` VALUES (4,'9999999','ף�����Ŀ���!','�ͷ�');
INSERT INTO `chatcontent` VALUES (5,'9999999','���ߣ���𩡣','�ͷ�');
INSERT INTO `chatcontent` VALUES (6,'24','����','��ţ');
INSERT INTO `chatcontent` VALUES (7,'24','���˰�','��ţ');
INSERT INTO `chatcontent` VALUES (8,'24','Ӧ��','��ţ');
INSERT INTO `chatcontent` VALUES (9,'24','yes','��ţ');
INSERT INTO `chatcontent` VALUES (10,'24','����','��ţ');
INSERT INTO `chatcontent` VALUES (11,'24','�ж�','��ţ');
INSERT INTO `chatcontent` VALUES (12,'24','����ж�','��ţ');
INSERT INTO `chatcontent` VALUES (13,'24','��ѽ','��ţ');
INSERT INTO `chatcontent` VALUES (14,'24','����','��ţ');
INSERT INTO `chatcontent` VALUES (15,'24','ʲô��','��ţ');
INSERT INTO `chatcontent` VALUES (16,'1','�����ε�','���');
INSERT INTO `chatcontent` VALUES (17,'24','������','��ţ');
INSERT INTO `chatcontent` VALUES (18,'24','һ����','��ţ');
INSERT INTO `chatcontent` VALUES (19,'1','����','���');
INSERT INTO `chatcontent` VALUES (20,'1','����һ��','���');
INSERT INTO `chatcontent` VALUES (21,'1','���������õõ�','���');
INSERT INTO `chatcontent` VALUES (22,'2','����','��С�');
INSERT INTO `chatcontent` VALUES (23,'2','������','��С�');
INSERT INTO `chatcontent` VALUES (24,'2','sfsdsdzhssd��������ɫ��','��С�');
INSERT INTO `chatcontent` VALUES (25,'2','��','��С�');
INSERT INTO `chatcontent` VALUES (26,'2','ʲô��','��С�');
INSERT INTO `chatcontent` VALUES (27,'2','���ǲ��ų�bu','��С�');
INSERT INTO `chatcontent` VALUES (28,'2','�����','��С�');
INSERT INTO `chatcontent` VALUES (29,'1','ee','���');
INSERT INTO `chatcontent` VALUES (30,'2','û�취','��С�');
INSERT INTO `chatcontent` VALUES (31,'2','������ҫ����bug','��С�');
INSERT INTO `chatcontent` VALUES (32,'2','��Һð�','��С�');
INSERT INTO `chatcontent` VALUES (33,'24','����','��ţ');
INSERT INTO `chatcontent` VALUES (34,'24','������','��ţ');
INSERT INTO `chatcontent` VALUES (35,'24','��','��ţ');
INSERT INTO `chatcontent` VALUES (36,'24','�Ҳ���������','��ţ');
INSERT INTO `chatcontent` VALUES (37,'1','����','���');
INSERT INTO `chatcontent` VALUES (38,'1','�ж�','���');
INSERT INTO `chatcontent` VALUES (39,'1','������','���');
INSERT INTO `chatcontent` VALUES (40,'112','��Һ�','akk');
INSERT INTO `chatcontent` VALUES (41,'1','�²�����˭','���');
INSERT INTO `chatcontent` VALUES (42,'1','�ݰ�','���');
INSERT INTO `chatcontent` VALUES (43,'112','good night','akk');
INSERT INTO `chatcontent` VALUES (44,'1','��ô����','���');
INSERT INTO `chatcontent` VALUES (45,'112','�Ǳ���','akk');
INSERT INTO `chatcontent` VALUES (46,'1','��Ҫ�ط�������','���');
INSERT INTO `chatcontent` VALUES (47,'1','û�����','���');
INSERT INTO `chatcontent` VALUES (48,'112','�� û���鲻̫ϰ��','akk');
INSERT INTO `chatcontent` VALUES (49,'1','qqq','���');
INSERT INTO `chatcontent` VALUES (50,'2','������','��С�');
INSERT INTO `chatcontent` VALUES (51,'1','sbsbsbsbs','���');
INSERT INTO `chatcontent` VALUES (52,'2','������','��С�');
INSERT INTO `chatcontent` VALUES (53,'2','�Ǻ���','��С�');
INSERT INTO `chatcontent` VALUES (54,'1','��������','���');
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
INSERT INTO `majorcontent` VALUES (1,'�й�����ѧԺ���ҹ������ල���������ҵΨһ��һ������ԺУ����һ��������׼�������������ɫ��������ѧ��Э����չ����ͨ��У��ѧУ�������㽭���ݡ�ѧУУ԰������������ѧ������Խ��ӵ�н�ѧ���������豸��ֵ3.6��Ԫ��ֽ��ͼ��210��ᡣ����19��ѧԺ���������ٰ�1������ѧԺ����ȫ������У��ͨ������14600�ˣ��о���1250�ˣ�����ѧԺ������6530�ˡ�');
INSERT INTO `majorcontent` VALUES (2,'��ؼ���������רҵ:��ҵ���򣺲�ؼ���������רҵ��ҵ����Ҫ�����񾭼ø����Ŵ��²���������������йؼ�����������ϵͳ��������졢�Ƽ�������Ӧ���о������й���ȷ���Ĺ�����');
INSERT INTO `majorcontent` VALUES (3,'����������רҵ:����Ŀ�꣺��רҵ����Χ�Ʋ�Ʒ�����������������������������������Ӧ���������������˲�Ӧ�߱���֪ʶ��ϵ��������ϵ��Ҫ�����Ƚ�����������������γɡ�������ȫ�ؼ�������ͻ�ƺ�������ѧ���۵�ʵ��Ϊ����');
INSERT INTO `majorcontent` VALUES (4,'ʳƷ�����밲ȫרҵ:��ҵ����ʳƷ�����밲ȫרҵ��ҵ���ɴ���ȫ������ʳƷ�����ල���š�ʳƷ��ҵ��������ʳƷӪ���밲ȫ�����š�����ҵ����ѧ�����еȵ�λ����ʳƷ������ʳƷӪ���밲ȫ�Ĺ�������Ӫ���ȷ���Ĺ�����');
INSERT INTO `majorcontent` VALUES (5,'֪ʶ��Ȩרҵ:��ҵ����֪ʶ��Ȩרҵ��ҵ����֪ʶ��Ȩ���������������ҵ������Ժ���ȵ�λ����֪ʶ��Ȩ��������Ҳ����֪ʶ��Ȩ�н�����������ʦ������������Ժ�ȵ�λ����֪ʶ��Ȩ�����������й������������о���λ����֪ʶ��Ȩ����ص��о�������');
INSERT INTO `majorcontent` VALUES (6,'������Ϣ����רҵ:רҵ���ܣ�������Ϣ������һ��Ӧ�ü�������ִ����������е�����Ϣ���ƺ���Ϣ�����ѧ�ƣ���Ҫ�о���Ϣ�Ļ�ȡ�봦�������豸����Ϣϵͳ����ơ�������Ӧ�úͼ��ɡ�������Ϣ����רҵ�Ǽ��ִ����Ӽ�������Ϣ������ͨ�ż�����һ���רҵ��');
INSERT INTO `majorcontent` VALUES (7,'��е������켰���Զ���רҵ:��ҵ���򣺻�е������켰���Զ���רҵ��ҵ�������ڹ�ҵ������һ�ߴ��»�е���������ڵ�������졢�Ƽ�������Ӧ���о������й���;�Ӫ���۵ȷ��湤����');
INSERT INTO `majorcontent` VALUES (8,'�������̼����Զ���רҵ:����Ŀ�꣺��רҵ�����ܹ���������������йص�ϵͳ���С��Զ����ơ��������Ӽ�������Ϣ����������������ƿ��������ù����Լ���������������Ӧ�õ��������Ŀ�ھ�\"������\"�߼����̼����˲š�');
INSERT INTO `majorcontent` VALUES (9,'�Զ���רҵ:����Ŀ�꣺��רҵ������ѧ��Ҫ�߱��繤���������Ӽ������������ۡ��Զ�������Ǳ���Ϣ����ϵͳ���̡������������Ӧ�ú����缼���ȽϿ������Ĺ��̼���������һ����רҵ֪ʶ�ĸ߼����̼����˲š�');
INSERT INTO `majorcontent` VALUES (10,'���ʾ�����ó��רҵ:��ҵ���򣺹��ʾ�����ó��רҵ�ı�ҵ�����Ե���������ó�׾��ù����Ŵ�����ó������������ó��ҵ���¶���ó��ҵ�񼰹����г���Ӫ�������������һ��ء����񾭼��ۺϲ��š���ҵ���š�������ҵ��������ҵ�����͹���ó�׹�˾����ҵ����ó�׾��á��г�Ӫ������Ӫ��������������ߵ�ԺУ�����е�λ���½�ѧ�����й����ȡ�');
INSERT INTO `majorcontent` VALUES (11,'����Ϣ��ѧ�뼼��רҵ:��ҵ���򣺹���Ϣ��ѧ�뼼��רҵѧ����ҵ�����Ӧ�ù�ѧ�������ѧ����صĵ�����Ϣ��ѧ���������ѧ������(�ر��ǹ������һ�廯��ҵ)���¿�ѧ�о�����ѧ����Ʒ��ơ������������������');
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
INSERT INTO `myusers` VALUES (1,'tt','���','12345678911');
INSERT INTO `myusers` VALUES (2,'gg','��С�','12345678911');
INSERT INTO `myusers` VALUES (3,'ss','ղ����','12345678911');
INSERT INTO `myusers` VALUES (24,'hh','��ţ','78945612369');
INSERT INTO `myusers` VALUES (27,'aa','����','45612345678');
INSERT INTO `myusers` VALUES (28,'ff','���','11111111111');
INSERT INTO `myusers` VALUES (29,'jj','���Ǻ���','12345678946');
INSERT INTO `myusers` VALUES (30,'kk','���ʽ�','12437564879');
INSERT INTO `myusers` VALUES (38,'hh','��ģ����','64645446644');
INSERT INTO `myusers` VALUES (100,'jj','������ٶ�','12345678945');
INSERT INTO `myusers` VALUES (101,'ii','����','17826833473');
INSERT INTO `myusers` VALUES (102,'uu','�õ�','12345678944');
INSERT INTO `myusers` VALUES (103,'yy','����','55555555555');
INSERT INTO `myusers` VALUES (104,'hh','ŶŶ','14576489123');
INSERT INTO `myusers` VALUES (105,'jj','�󷶸ʵ�','12345678946');
INSERT INTO `myusers` VALUES (106,'hh','�Ѵ�Ŷ���','12345678944');
INSERT INTO `myusers` VALUES (107,'uu','ˮ���','12345678945');
INSERT INTO `myusers` VALUES (108,'uu','�ٶ�v','12345678945');
INSERT INTO `myusers` VALUES (109,'uu','�����󶫷���','24345678941');
INSERT INTO `myusers` VALUES (110,'uuu','������','11111111111');
INSERT INTO `myusers` VALUES (111,'kk','��','45612378945');
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
INSERT INTO `writecircle` VALUES (1,'������','�������ҿ�������','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (2,'��','�ˣ���ð�','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (3,'���','��������','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (4,'ղ����','��ô�õİ�','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (5,'���','��ô�죬������','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (6,'���','����ô˧','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (7,'�ٶ�v','�ٶȿ�㣡','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (8,'���ʽ�','�Ҹ�˧','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (9,'����','����','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (10,'���Ǻ���','��˧������ϧ','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (11,'���','��������','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (12,'�ٶ�v','�ҵļ��ٶȺܴ�','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (13,'���ʽ�','��ϧ�Ǹ�λADC','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (14,'����','����','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (15,'���Ǻ���','���Ǵ̿�','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (16,'���','���Ǹ�սʿ','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (17,'�ٶ�v','��û�мƻ�','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (18,'���ʽ�','�Ҵ�Ұ','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (19,'����','������̹����','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (20,'���Ǻ���','����ɽ������ɳ','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (21,'��ţ','����','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (22,'akk','akk','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (23,'akk','������','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (24,'mm','�Ǻ���','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (25,'���','gagasgsagsa','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (26,'���','fdgdfg','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (27,'���','qqq','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (28,'���','qq','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (29,'���','ads','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (30,'���','aaa','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (31,'���','aaaaaaaa','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (32,'���','sefasdf��A��ɫ','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (33,'���','frqwerwe','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (34,'���','dsfsdgsdfg','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (35,'���','sdfsd','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (36,'���','fewtetr','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (37,'���','sdafasdf','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (38,'���','dfasdfsdf','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (39,'���','sfdasdafdsa','0000-00-00 00:00:00',NULL,0);
INSERT INTO `writecircle` VALUES (42,'���','asdfasdfsd','2020-10-03 22:44:28','1601736268845',1);
INSERT INTO `writecircle` VALUES (43,'��С�','sdfasdf','2020-10-03 22:45:16','1601736316785',2);
INSERT INTO `writecircle` VALUES (44,'��С�','afsdfsdf','2020-10-03 22:48:28','1601736508578',2);
INSERT INTO `writecircle` VALUES (45,'��С�','aaa','2020-10-03 22:49:45','1601736585235',2);
/*!40000 ALTER TABLE `writecircle` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
