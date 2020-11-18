/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2020-11-18 15:24:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pms_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_category`;
CREATE TABLE `pms_category` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT '' COMMENT '分类名',
  `par_id` smallint(4) DEFAULT '0' COMMENT '父级层级id',
  `level` smallint(4) DEFAULT NULL COMMENT '分类层级',
  `unit` varchar(4) DEFAULT '' COMMENT '计量单位',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1016 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_category
-- ----------------------------
INSERT INTO `pms_category` VALUES ('1', '手机数码', '0', '1', '件', '2020-10-22 14:13:24');
INSERT INTO `pms_category` VALUES ('2', '服装配饰', '0', '1', '件', '2020-10-22 14:13:57');
INSERT INTO `pms_category` VALUES ('1007', '手机', '1', '2', '台', '2020-11-06 16:13:28');
INSERT INTO `pms_category` VALUES ('1008', '电脑', '1', '2', '台', '2020-11-06 16:13:47');
INSERT INTO `pms_category` VALUES ('1009', '男装', '2', '2', '件', '2020-11-06 16:14:03');
INSERT INTO `pms_category` VALUES ('1010', '女装', '2', '2', '件', '2020-11-06 16:14:21');
INSERT INTO `pms_category` VALUES ('1011', '童装', '2', '2', '件', '2020-11-06 16:14:58');
INSERT INTO `pms_category` VALUES ('1012', '裙子', '1010', '3', '条', '2020-11-06 16:15:26');
INSERT INTO `pms_category` VALUES ('1013', '风衣', '1010', '3', '件', '2020-11-06 16:16:08');
INSERT INTO `pms_category` VALUES ('1014', '长裤', '1009', '3', '条', '2020-11-06 16:16:26');
INSERT INTO `pms_category` VALUES ('1015', '夹克', '1009', '3', '件', '2020-11-06 16:16:39');
