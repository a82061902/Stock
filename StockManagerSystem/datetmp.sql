/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : stockmanager

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2022-05-04 09:28:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for datetmp
-- ----------------------------
DROP TABLE IF EXISTS `datetmp`;
CREATE TABLE `datetmp` (
  `year` int DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `count` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of datetmp
-- ----------------------------
INSERT INTO `datetmp` VALUES ('2022', '4', '21');
