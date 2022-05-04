/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : stockmanager

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2022-05-04 09:28:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tmp
-- ----------------------------
DROP TABLE IF EXISTS `tmp`;
CREATE TABLE `tmp` (
  `goodsId` varchar(50) DEFAULT NULL,
  `count` varchar(50) DEFAULT NULL,
  `supplierName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tmp
-- ----------------------------
INSERT INTO `tmp` VALUES ('A002', '11', '四星');
