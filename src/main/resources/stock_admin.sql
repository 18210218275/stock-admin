/*
 Navicat Premium Data Transfer

 Source Server         : localdb(本地)
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : stock_admin

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 27/08/2019 18:03:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `brand_name_cn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌中文名',
  `brand_name_en` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌英文名',
  `brand_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌编码',
  `type` int(4) NULL DEFAULT NULL COMMENT '品牌类型',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '品牌表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES (4, '朵以', 'duoyi', '001', 12, '2019-08-23 14:32:49');
INSERT INTO `brand` VALUES (5, '卓多姿', 'zhuoduozi', '002', NULL, '2019-08-23 14:41:13');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品编码',
  `brand_id` int(11) NULL DEFAULT NULL COMMENT '所属品牌',
  `time_to_market` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上市时间',
  `market_price` double(5, 2) NULL DEFAULT NULL COMMENT '吊牌价',
  `sale_price` double(5, 2) NULL DEFAULT NULL COMMENT '销售价',
  `size` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '尺码',
  `color` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '颜色',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '商品件数',
  `sex` tinyint(2) NULL DEFAULT NULL COMMENT '性别',
  `clothing_type` int(5) NULL DEFAULT NULL COMMENT '服装类型',
  `purchase_time` datetime(0) NULL DEFAULT NULL COMMENT '进货时间',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加商品时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (19, '上衣', '909090', 4, '', 345.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-08-24 11:27:33');
INSERT INTO `product` VALUES (20, '', '', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-08-24 11:28:43');
INSERT INTO `product` VALUES (21, '裤子', '78235', 5, '2019-09-05', 345.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-08-24 11:37:23');
INSERT INTO `product` VALUES (22, '短袖', '909024', 4, '2019-08-30', 345.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-08-24 11:46:41');

-- ----------------------------
-- Table structure for product_spec
-- ----------------------------
DROP TABLE IF EXISTS `product_spec`;
CREATE TABLE `product_spec`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品ID',
  `color` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '颜色',
  `size` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '尺寸',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '数量',
  `purchase_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '进货时间',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_spec
-- ----------------------------
INSERT INTO `product_spec` VALUES (25, 19, '黑色', '160/42/XS', 34, '', '2019-08-24 11:28:24', 0);
INSERT INTO `product_spec` VALUES (26, NULL, '黑色', '160/42/XS', 34, '2019-08-23', '2019-08-24 11:30:08', 0);
INSERT INTO `product_spec` VALUES (27, 21, '黑色', '165/44/S', 121, '2019-08-31', '2019-08-24 11:37:39', 0);
INSERT INTO `product_spec` VALUES (28, 22, '黑色', '160/42/XS', 15, '', '2019-08-24 11:47:12', 0);
INSERT INTO `product_spec` VALUES (29, 22, '黄色', '160/42/XS', 5, '2019-08-31', '2019-08-24 11:47:26', 0);

-- ----------------------------
-- Table structure for product_store_upper
-- ----------------------------
DROP TABLE IF EXISTS `product_store_upper`;
CREATE TABLE `product_store_upper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品编码',
  `store_id` int(11) NULL DEFAULT NULL COMMENT '店铺ID',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '商品件数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '店铺上架商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_warehouse_stock
-- ----------------------------
DROP TABLE IF EXISTS `product_warehouse_stock`;
CREATE TABLE `product_warehouse_stock`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_spec_id` int(11) NULL DEFAULT NULL COMMENT '商品属性主键',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品主键',
  `warehouse_id` int(11) NULL DEFAULT NULL COMMENT '仓库ID',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '件数',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `brand_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `warehouse_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '仓库名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '仓库存储商品数量' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_warehouse_stock
-- ----------------------------
INSERT INTO `product_warehouse_stock` VALUES (9, 25, 19, 11, 34, '2019-08-24 11:28:24', '2019-08-24 11:28:24', '朵以', '仓库1');
INSERT INTO `product_warehouse_stock` VALUES (10, 26, NULL, 11, 34, '2019-08-24 11:30:08', '2019-08-24 11:30:08', '卓多姿', '仓库1');
INSERT INTO `product_warehouse_stock` VALUES (11, 27, 21, 11, 1211, '2019-08-24 11:37:39', '2019-08-24 13:17:30', '卓多姿', '仓库1');
INSERT INTO `product_warehouse_stock` VALUES (12, 27, 21, NULL, 121, '2019-08-24 11:38:35', '2019-08-24 11:38:35', NULL, NULL);
INSERT INTO `product_warehouse_stock` VALUES (13, 28, 22, 11, 9, '2019-08-24 11:47:12', '2019-08-24 11:51:26', '朵以', '仓库1');
INSERT INTO `product_warehouse_stock` VALUES (14, 29, 22, 11, 5, '2019-08-24 11:47:26', '2019-08-24 11:47:26', '朵以', '仓库1');
INSERT INTO `product_warehouse_stock` VALUES (15, 28, 22, 12, 6, '2019-08-24 11:51:26', '2019-08-24 11:51:26', '朵以', '文化路店仓库');
INSERT INTO `product_warehouse_stock` VALUES (16, 29, 22, 0, 0, '2019-08-24 11:51:26', '2019-08-24 11:51:26', '朵以', '---请选择---');
INSERT INTO `product_warehouse_stock` VALUES (17, 28, 22, 0, 0, '2019-08-24 11:52:09', '2019-08-24 11:52:09', '朵以', '---请选择---');
INSERT INTO `product_warehouse_stock` VALUES (18, 27, 21, 12, 1, '2019-08-24 13:17:02', '2019-08-24 13:17:30', '卓多姿', '文化路店仓库');
INSERT INTO `product_warehouse_stock` VALUES (19, 27, 21, 0, 0, '2019-08-24 13:17:02', '2019-08-24 13:17:02', 'null', '---请选择---');

-- ----------------------------
-- Table structure for sale_product
-- ----------------------------
DROP TABLE IF EXISTS `sale_product`;
CREATE TABLE `sale_product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品编码',
  `product_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `store_id` int(11) NULL DEFAULT NULL COMMENT '店铺ID',
  `salesperson` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '销售员',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '商品件数',
  `sale_time` date NULL DEFAULT NULL COMMENT '销售时间',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  `total_money` double(10, 2) NULL DEFAULT NULL COMMENT '销售收入',
  `color` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '颜色',
  `size` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '尺码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品销售记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_product
-- ----------------------------
INSERT INTO `sale_product` VALUES (4, '909024', '短袖', NULL, '张三', 2, '2019-08-30', '2019-08-24 13:14:44', 123.00, '黑色', '165/44/S');

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店名',
  `store_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店铺地址',
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `manager` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店长',
  `start_business_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '开业时间',
  `type` tinyint(2) NULL DEFAULT NULL COMMENT '店铺类型',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '店铺表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (5, '保利ccdd', '保利广场', '', '', '', NULL, '2019-08-24 11:26:38');
INSERT INTO `store` VALUES (6, '保利z11', '保利广场', '', '', '', NULL, '2019-08-24 11:26:53');

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `warehouse_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '仓库名称',
  `warehouse_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '仓库地址',
  `build_date` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '仓库创建时间',
  `type` tinyint(2) NULL DEFAULT NULL COMMENT '仓库类型（0 为小仓，1为大仓）',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '仓库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (11, '仓库1', '屋里', '', 0, '2019-08-24 11:27:14', '');
INSERT INTO `warehouse` VALUES (12, '文化路店仓库', '文化路', '2019-08-30', 0, '2019-08-24 11:50:51', '');

SET FOREIGN_KEY_CHECKS = 1;
