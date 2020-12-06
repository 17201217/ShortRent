/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : shortrent4
Target Host     : localhost:3306
Target Database : shortrent4
Date: 2020-12-06 22:24:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `anno_id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(200) NOT NULL,
  `anno_time` datetime DEFAULT NULL,
  PRIMARY KEY (`anno_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('10', '注意', '2020-10-15 23:00:21');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `collect_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `collecttime` datetime NOT NULL,
  PRIMARY KEY (`collect_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('5', '170003', '11', '2019-08-01 10:00:00');
INSERT INTO `collect` VALUES ('6', '170003', '22', '2019-08-01 10:01:00');
INSERT INTO `collect` VALUES ('7', '170004', '31', '2019-08-04 10:00:00');
INSERT INTO `collect` VALUES ('8', '170004', '5', '2019-08-01 11:00:00');
INSERT INTO `collect` VALUES ('9', '170005', '7', '2019-08-01 10:00:00');
INSERT INTO `collect` VALUES ('10', '170007', '9', '2019-08-01 10:01:00');
INSERT INTO `collect` VALUES ('11', '170007', '16', '2019-08-04 10:00:00');
INSERT INTO `collect` VALUES ('12', '170008', '19', '2019-08-01 11:00:00');
INSERT INTO `collect` VALUES ('17', '170002', '1', '2020-10-04 10:45:38');
INSERT INTO `collect` VALUES ('24', '170001', '2', '2020-10-13 09:02:11');
INSERT INTO `collect` VALUES ('25', '170001', '1', '2020-10-13 16:31:40');
INSERT INTO `collect` VALUES ('26', '170008', '19', '2020-10-14 14:14:10');
INSERT INTO `collect` VALUES ('29', '170001', '6', '2020-10-15 09:38:24');

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `house_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL,
  `house_name` varchar(30) NOT NULL,
  `type` varchar(20) NOT NULL,
  `size` int(11) NOT NULL,
  `house_price` int(11) NOT NULL,
  `photo` varchar(40) NOT NULL,
  `online` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0',
  `locate` varchar(40) NOT NULL,
  `flag` int(11) NOT NULL DEFAULT '0',
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`house_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES ('1', '170003', '龙城别墅1', '一室一厅', '15', '550', '1.png', '0', '0', '南昌家园', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('2', '170003', '龙城楼房2', '两室一厅', '35', '1500', '2.png', '1', '0', '九江豪庭', '1', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('4', '170003', '景程楼房4', '两室一厅', '55', '2500', '4.jpg', '1', '0', '鹰潭国际眼镜城', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('5', '170005', '龙城别墅99', '三室两厅', '50', '1999', '57.jpg', '0', '0', '九江碧桂园', '0', '空调，洗衣机');
INSERT INTO `house` VALUES ('6', '170005', '龙城别墅6', '两室两厅', '95', '10000', '6.jpg', '1', '0', '九江碧桂园', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('7', '170005', '龙城别墅7', '一室一厅', '120', '550', '7.jpg', '1', '0', '上饶市龙潭新苑', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('8', '170003', '龙城别墅8', '两室一厅', '15', '1500', '8.jpg', '0', '0', '鹰潭长途客运站店', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('9', '170003', '南昌别墅9', '一室一厅', '35', '2500', '9.jpg', '1', '0', '南昌市进明路进明小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('10', '170003', '南昌别墅10', '两室一厅', '55', '3500', '10.jpg', '1', '0', '九江金鹏城', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('11', '170003', '龙城别墅11', '一室一厅', '75', '10000', '11.jpg', '1', '0', '上饶市滨江西路24号小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('12', '170003', '龙城别墅12', '两室一厅', '95', '550', '12.jpg', '1', '0', '鹰潭四海花苑', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('15', '170003', '龙城别墅15', '三室一厅', '35', '3500', '15.jpg', '1', '0', ' 上饶市信州区北门沽塘叶社区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('16', '170003', '龙城别墅16', '两室一厅', '55', '10000', '16.jpg', '1', '0', '鹰潭市综合大楼', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('17', '170003', '南昌别墅19', '两室一厅', '100', '1999', '58.jpg', '1', '0', '南昌市进明路进明小区', '0', '很好');
INSERT INTO `house` VALUES ('18', '170003', '胜景楼房', '三室一厅', '95', '1500', '18.jpg', '1', '0', '南昌和苑住宅小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('19', '170003', '景程别墅', '一室一厅', '120', '2500', '19.jpg', '1', '0', '南昌县小蓝综合住宅小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('20', '170003', '景程楼房', '两室一厅', '15', '3500', '20.jpg', '1', '1', '南昌市进明路进明小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('21', '170003', '龙城楼房', '两室一厅', '35', '10000', '21.jpg', '0', '0', '南昌雅颂阁', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('22', '170003', '龙城楼房', '两室一厅', '55', '550', '22.jpg', '0', '0', '南昌地税住宅小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('23', '170003', '龙城楼房', '三室一厅', '75', '1500', '23.jpg', '0', '0', '南昌郡南府小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('24', '170003', '龙城楼房', '三室一厅', '95', '2500', '24.jpg', '0', '0', '南昌五星白鹤保护小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('25', '170003', '龙城楼房', '三室一厅', '120', '3500', '25.jpg', '0', '0', '南昌卷烟厂住宅小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('26', '170003', '龙城楼房', '三室一厅', '15', '10000', '26.jpg', '0', '0', '南昌市公安局射不亭小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('27', '170003', '龙城楼房', '三室一厅', '35', '550', '27.jpg', '0', '0', '南昌市体委住宅小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('28', '170003', '龙城楼房', '三室一厅', '55', '1500', '28.jpg', '0', '0', '南昌公交汽车修理厂小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('29', '170003', '龙城楼房', '三室一厅', '75', '2500', '29.jpg', '0', '0', '南昌上峰景城', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('30', '170003', '龙城楼房', '三室一厅', '95', '3500', '30.jpg', '0', '0', '南昌市煤气公司住宅小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('31', '170003', '龙城楼房', '三室一厅', '120', '10000', '31.jpg', '0', '0', '南昌市中级人民法院小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('48', '170003', '南昌别墅19', '三室一厅', '200', '10000', '46.jpg', '1', '0', '南昌市第一医院小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('49', '170003', '南昌别墅90', '三室一厅', '300', '10000', '9.jpg', '0', '0', '南昌中大城', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('50', '170003', '南昌别墅78', '三室一厅', '150', '10000', '22.jpg', '0', '0', '南昌市汽车配件公住宅小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('51', '170000', '南昌别墅20', '三室一厅', '200', '10000', '51.jpg', '1', '0', '南昌市眼科医院-小区', '0', '空调，洗衣机，电视');
INSERT INTO `house` VALUES ('52', '170003', '南昌别墅100', '三室一厅', '100', '1999', '27.jpg', '1', '0', '南昌供电局住宅', '0', '很好');
INSERT INTO `house` VALUES ('53', '170003', '南昌别墅99', '三室一厅', '100', '1999', '56.jpg', '1', '0', '南昌水城艺术村', '0', '空调，洗衣机');
INSERT INTO `house` VALUES ('54', '170003', '南昌别墅1000', '三室一厅', '100', '1999', '35.jpg', '1', '0', '南昌大学公租房', '0', '空调，洗衣机');

-- ----------------------------
-- Table structure for orderlist
-- ----------------------------
DROP TABLE IF EXISTS `orderlist`;
CREATE TABLE `orderlist` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `rent_id` varchar(20) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `order_time` datetime NOT NULL,
  `totalcost` int(11) NOT NULL,
  `starttime` date NOT NULL,
  `endtime` date NOT NULL,
  `flag` int(11) NOT NULL DEFAULT '0',
  `ispay` int(5) DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderlist
-- ----------------------------
INSERT INTO `orderlist` VALUES ('2', '170002', '4', '2020-09-11 10:00:00', '2000', '2020-09-13', '2020-09-15', '0', '0');
INSERT INTO `orderlist` VALUES ('3', '170002', '1', '2020-09-21 10:00:00', '4000', '2019-10-01', '2019-10-05', '0', '0');
INSERT INTO `orderlist` VALUES ('4', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('5', '170001', '4', '2020-09-21 10:00:00', '2000', '2020-09-21', '2020-09-23', '0', '0');
INSERT INTO `orderlist` VALUES ('6', '170002', '4', '2020-09-11 10:00:00', '2000', '2020-09-13', '2020-09-15', '0', '0');
INSERT INTO `orderlist` VALUES ('7', '170002', '1', '2020-09-21 10:00:00', '4000', '2019-10-01', '2019-10-05', '0', '0');
INSERT INTO `orderlist` VALUES ('8', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('10', '170002', '4', '2020-09-11 10:00:00', '2000', '2020-09-13', '2020-09-15', '0', '0');
INSERT INTO `orderlist` VALUES ('11', '170002', '1', '2020-09-21 10:00:00', '4000', '2019-10-01', '2019-10-05', '0', '0');
INSERT INTO `orderlist` VALUES ('12', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('13', '170001', '4', '2020-09-21 10:00:00', '2000', '2020-09-21', '2020-09-23', '0', '0');
INSERT INTO `orderlist` VALUES ('14', '170002', '4', '2020-09-11 10:00:00', '2000', '2020-09-13', '2020-09-15', '0', '0');
INSERT INTO `orderlist` VALUES ('15', '170002', '1', '2020-09-21 10:00:00', '4000', '2019-10-01', '2019-10-05', '0', '0');
INSERT INTO `orderlist` VALUES ('16', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('17', '170002', '1', '2020-09-21 10:00:00', '4000', '2019-10-01', '2019-10-05', '0', '0');
INSERT INTO `orderlist` VALUES ('18', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('19', '170001', '4', '2020-09-21 10:00:00', '2000', '2020-09-21', '2020-09-23', '0', '0');
INSERT INTO `orderlist` VALUES ('20', '170002', '4', '2020-09-11 10:00:00', '2000', '2020-09-13', '2020-09-15', '0', '0');
INSERT INTO `orderlist` VALUES ('21', '170002', '1', '2020-09-21 10:00:00', '4000', '2019-10-01', '2019-10-05', '0', '0');
INSERT INTO `orderlist` VALUES ('22', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('23', '170001', '4', '2020-09-21 10:00:00', '2000', '2020-09-21', '2020-09-23', '0', '0');
INSERT INTO `orderlist` VALUES ('24', '170002', '4', '2020-09-11 10:00:00', '2000', '2020-09-13', '2020-09-15', '0', '0');
INSERT INTO `orderlist` VALUES ('25', '170002', '1', '2020-09-21 10:00:00', '4000', '2019-10-01', '2019-10-05', '0', '0');
INSERT INTO `orderlist` VALUES ('26', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('27', '170002', '1', '2020-09-21 10:00:00', '4000', '2019-10-01', '2019-10-05', '0', '0');
INSERT INTO `orderlist` VALUES ('28', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('29', '170001', '4', '2020-09-21 10:00:00', '2000', '2020-09-21', '2020-09-23', '0', '0');
INSERT INTO `orderlist` VALUES ('30', '170002', '4', '2020-09-11 10:00:00', '2000', '2020-09-13', '2020-09-15', '0', '0');
INSERT INTO `orderlist` VALUES ('31', '170002', '1', '2020-09-21 10:00:00', '4000', '2019-10-01', '2019-10-05', '0', '0');
INSERT INTO `orderlist` VALUES ('32', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('33', '170001', '4', '2020-09-21 10:00:00', '2000', '2020-09-21', '2020-09-23', '0', '0');
INSERT INTO `orderlist` VALUES ('34', '170002', '4', '2020-09-11 10:00:00', '2000', '2020-09-13', '2020-09-15', '0', '0');
INSERT INTO `orderlist` VALUES ('35', '170002', '1', '2020-09-21 10:00:00', '4000', '2019-10-01', '2019-10-05', '0', '0');
INSERT INTO `orderlist` VALUES ('36', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('37', '170002', '1', '2020-09-21 10:00:00', '4000', '2019-10-01', '2019-10-05', '0', '0');
INSERT INTO `orderlist` VALUES ('38', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('39', '170001', '4', '2020-09-21 10:00:00', '2000', '2020-09-21', '2020-09-23', '0', '0');
INSERT INTO `orderlist` VALUES ('40', '170002', '4', '2020-09-11 10:00:00', '2000', '2020-09-13', '2020-09-15', '0', '0');
INSERT INTO `orderlist` VALUES ('41', '170002', '1', '2020-09-21 10:00:00', '4000', '2019-10-01', '2019-10-05', '0', '0');
INSERT INTO `orderlist` VALUES ('42', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('43', '170001', '1', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('44', '170001', '11', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('47', '170001', '1', '2020-10-10 10:57:47', '100', '2020-10-15', '2020-10-16', '0', '0');
INSERT INTO `orderlist` VALUES ('48', '170001', '1', '2020-10-10 10:59:42', '100', '2020-10-10', '2020-10-16', '0', '0');
INSERT INTO `orderlist` VALUES ('49', '170001', '11', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('50', '170001', '11', '2019-08-01 10:00:00', '2000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('51', '170001', '1', '2020-10-10 11:03:35', '100', '2020-10-22', '2020-10-28', '0', '0');
INSERT INTO `orderlist` VALUES ('52', '170001', '1', '2020-10-10 11:05:29', '100', '2020-10-14', '2020-10-15', '0', '0');
INSERT INTO `orderlist` VALUES ('53', '170001', '11', '2019-08-01 10:00:00', '20000', '2019-08-02', '2019-08-04', '0', '0');
INSERT INTO `orderlist` VALUES ('54', '170001', '1', '2020-10-10 11:11:14', '100', '2020-10-07', '2020-10-14', '0', '0');
INSERT INTO `orderlist` VALUES ('56', '170001', '1', '2020-10-10 11:13:38', '100', '2020-10-14', '2020-10-21', '0', '1');
INSERT INTO `orderlist` VALUES ('57', '170001', '16', '2020-10-06 13:43:00', '100', '2020-10-13', '2020-10-14', '0', '0');
INSERT INTO `orderlist` VALUES ('58', '170001', '1', '2020-10-06 13:44:41', '100', '2020-10-07', '2020-10-14', '0', '0');
INSERT INTO `orderlist` VALUES ('59', '170001', '5', '2020-10-06 13:45:34', '100', '2020-10-06', '2020-10-27', '0', '0');
INSERT INTO `orderlist` VALUES ('60', '170001', '2', '2020-10-06 13:47:35', '100', '2020-10-14', '2020-10-27', '0', '0');
INSERT INTO `orderlist` VALUES ('61', '170001', '2', '2020-10-10 13:48:58', '100', '2020-10-13', '2020-10-20', '0', '1');
INSERT INTO `orderlist` VALUES ('62', '170001', '2', '2020-10-10 13:49:53', '100', '2020-10-07', '2020-10-14', '0', '1');
INSERT INTO `orderlist` VALUES ('63', '170001', '2', '2020-10-10 13:58:32', '100', '2020-10-07', '2020-10-21', '0', '1');
INSERT INTO `orderlist` VALUES ('64', '170001', '1', '2020-10-10 14:12:22', '100', '2020-10-14', '2020-10-28', '0', '1');
INSERT INTO `orderlist` VALUES ('65', '170001', '9', '2020-10-10 14:24:54', '100', '2020-10-07', '2020-10-14', '0', '1');
INSERT INTO `orderlist` VALUES ('69', '170001', '9', '2020-10-10 14:30:45', '100', '2020-10-21', '2020-10-22', '0', '1');
INSERT INTO `orderlist` VALUES ('75', '170001', '9', '2020-10-10 14:46:21', '100', '2020-10-13', '2020-10-22', '0', '1');
INSERT INTO `orderlist` VALUES ('78', '170001', '5', '2020-10-10 14:52:43', '233', '2020-10-15', '2020-10-21', '1', '1');

-- ----------------------------
-- Table structure for reserve
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve` (
  `reserve_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `reserve_time` datetime DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`reserve_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reserve
-- ----------------------------
INSERT INTO `reserve` VALUES ('2', '170001', '2', '2019-07-02 11:00:00', '0');
INSERT INTO `reserve` VALUES ('4', '170002', '5', '2019-08-01 11:00:00', '1');
INSERT INTO `reserve` VALUES ('5', '170001', '1', '2019-08-01 11:00:00', '0');
INSERT INTO `reserve` VALUES ('6', '170001', '2', '2019-07-02 11:00:00', '0');
INSERT INTO `reserve` VALUES ('7', '170001', '4', '2019-08-03 11:00:00', '0');
INSERT INTO `reserve` VALUES ('8', '170002', '5', '2019-08-01 11:00:00', '0');
INSERT INTO `reserve` VALUES ('9', '170001', '1', '2019-08-01 11:00:00', '0');
INSERT INTO `reserve` VALUES ('10', '170001', '2', '2019-07-02 11:00:00', '0');
INSERT INTO `reserve` VALUES ('11', '170001', '4', '2019-08-03 11:00:00', '0');
INSERT INTO `reserve` VALUES ('12', '170002', '5', '2019-08-01 11:00:00', '0');
INSERT INTO `reserve` VALUES ('13', '170001', '1', '2019-07-02 11:00:00', '0');
INSERT INTO `reserve` VALUES ('14', '170001', '2', '2019-08-03 11:00:00', '0');
INSERT INTO `reserve` VALUES ('15', '170002', '4', '2019-08-01 11:00:00', '0');
INSERT INTO `reserve` VALUES ('16', '170001', '5', '2019-08-01 10:00:00', '0');
INSERT INTO `reserve` VALUES ('17', '170001', '1', '2020-10-13 22:59:00', '1');
INSERT INTO `reserve` VALUES ('18', '170001', '2', '2020-10-13 22:59:00', '1');
INSERT INTO `reserve` VALUES ('19', '170001', '5', '2020-10-13 22:59:00', '0');
INSERT INTO `reserve` VALUES ('22', '170001', '1', '2020-10-14 23:58:00', '1');
INSERT INTO `reserve` VALUES ('23', '170001', '2', '2020-10-20 23:59:00', '1');
INSERT INTO `reserve` VALUES ('25', '170001', '1', '2020-10-22 23:00:00', '0');
INSERT INTO `reserve` VALUES ('26', '170001', '1', '2020-10-22 23:00:00', '0');
INSERT INTO `reserve` VALUES ('27', '170001', '1', '2020-10-22 23:00:00', '0');
INSERT INTO `reserve` VALUES ('28', '170001', '1', '2020-10-15 23:59:00', '0');
INSERT INTO `reserve` VALUES ('32', '17201217', '1', '2021-10-06 23:00:00', '0');
INSERT INTO `reserve` VALUES ('34', '17201217', '6', '2020-10-20 23:59:00', '0');
INSERT INTO `reserve` VALUES ('35', '17201217', '7', '2020-10-21 01:58:00', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_email` varchar(40) NOT NULL,
  `user_name` varchar(40) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `user_tel` varchar(11) NOT NULL,
  `category` int(11) NOT NULL,
  `islock` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `index_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('170000', '123456', '3241153634@qq.com', '张三', '男', '13507016474', '2', '0');
INSERT INTO `user` VALUES ('170001', '111111', '3241153632@qq.com', '李四', '男', '13507016475', '0', '0');
INSERT INTO `user` VALUES ('170002', '123456', '3241153634@qq.com', '王五', '女', '13507016476', '0', '0');
INSERT INTO `user` VALUES ('170003', '123456', '3241153634@qq.com', '刘六', '男', '13507016477', '1', '0');
INSERT INTO `user` VALUES ('170004', '123456', '3241153634@qq.com', '马七', '男', '13507016478', '0', '1');
INSERT INTO `user` VALUES ('170005', '123456', '3241153634@qq.com', '魏八', '男', '13507016479', '1', '0');
INSERT INTO `user` VALUES ('170006', '123456', '3241153634@qq.com', '李连杰', '男', '13507016480', '1', '0');
INSERT INTO `user` VALUES ('170007', '123456', '3241153634@qq.com', '成龙', '男', '13426585427', '1', '0');
INSERT INTO `user` VALUES ('170008', '123456', '3241153634@qq.com', '洪金宝', '男', '13426585428', '0', '0');
INSERT INTO `user` VALUES ('170009', '111111', '3241153634@qq.com', '周星驰', '男', '13426585429', '0', '0');
INSERT INTO `user` VALUES ('170010', '123456', '3241153634@qq.com', '周润发', '男', '13426585430', '0', '0');
INSERT INTO `user` VALUES ('170011', '123456', '3241153634@qq.com', '梁家辉', '男', '13426585431', '0', '0');
INSERT INTO `user` VALUES ('170012', '123456', '3241153634@qq.com', '范冰冰', '女', '13426585432', '0', '0');
INSERT INTO `user` VALUES ('17201217', '123456', '2557272503@qq.com', '刘德华', '男', '13507016473', '0', '0');
