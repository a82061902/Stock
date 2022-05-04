/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : stockmanager

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2022-05-04 09:47:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerName` varchar(50) DEFAULT NULL,
  `customerPhone` varchar(50) DEFAULT NULL,
  `customerEmail` varchar(50) DEFAULT NULL,
  `customerAddress` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('果粉', '1', '1', '1');
INSERT INTO `customer` VALUES ('1', '11111111111', '1@qq.com', '2');

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

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `count` int DEFAULT NULL,
  `supplierName` varchar(50) DEFAULT NULL,
  `inTime` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('A001', '苹果', '11', '苹果', null);
INSERT INTO `goods` VALUES ('A002', '四星', '11', '四星', null);

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('super', 'D4NxcNISgNMHKicfwGwJHw==', 'Veuyu+HR2VqsCCVB1b7Y9Q==', '2022-04-07 01:32:03');

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `orderId` varchar(50) DEFAULT NULL,
  `goodsId` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `count` int DEFAULT NULL,
  `inTime` datetime DEFAULT NULL,
  `supplierName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES ('22040611010001', 'A001', '苹果', '10', '2022-04-06 03:01:02', '苹果');
INSERT INTO `purchase` VALUES ('22040611020001', 'A002', '四星', '11', '2022-04-06 03:01:51', '四星');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `authorities` varchar(50) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('admin', '0cRVhQ09IAOHxyi4T9iJhQ==', '1', '1');
INSERT INTO `role` VALUES ('user', '0cRVhQ09IAOHxyi4T9iJhQ==', '2', '1');
INSERT INTO `role` VALUES ('super', '0cRVhQ09IAOHxyi4T9iJhQ==', '0', '1');
INSERT INTO `role` VALUES ('guest', '0cRVhQ09IAOHxyi4T9iJhQ==', '2', '0');

-- ----------------------------
-- Table structure for shipment
-- ----------------------------
DROP TABLE IF EXISTS `shipment`;
CREATE TABLE `shipment` (
  `orderId` varchar(50) DEFAULT NULL,
  `goodsId` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `count` int DEFAULT NULL,
  `outTime` datetime DEFAULT NULL,
  `customerName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of shipment
-- ----------------------------
INSERT INTO `shipment` VALUES ('22031713570001', 'A001', '苹果', '1', '2022-03-17 05:57:24', '果粉');
INSERT INTO `shipment` VALUES ('22031714120001', 'A001', '苹果', '111', '2022-03-17 06:12:41', '果粉');
INSERT INTO `shipment` VALUES ('22032516070001', 'A003', '小米', '1', '2022-03-25 08:07:32', '1');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplierName` varchar(50) DEFAULT NULL,
  `supplierPhone` varchar(50) DEFAULT NULL,
  `supplierEmail` varchar(50) DEFAULT NULL,
  `supplierAddress` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('苹果', '12311111122', '2@qq.com', '23');
INSERT INTO `supplier` VALUES ('五星', '11111111111', '1@qq.com', '1');

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
