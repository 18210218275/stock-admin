/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.26 : Database - stock_admin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stock_admin` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `stock_admin`;

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `brand_name_cn` varchar(50) DEFAULT NULL COMMENT '品牌中文名',
  `brand_name_en` varchar(100) DEFAULT NULL COMMENT '品牌英文名',
  `brand_code` varchar(50) DEFAULT NULL COMMENT '品牌编码',
  `type` int(4) DEFAULT NULL COMMENT '品牌类型',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='品牌表';

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `product_code` varchar(100) DEFAULT NULL COMMENT '商品编码',
  `brand_id` int(11) DEFAULT NULL COMMENT '所属品牌',
  `time_to_market` varchar(20) DEFAULT NULL COMMENT '上市时间',
  `market_price` double(5,2) DEFAULT NULL COMMENT '吊牌价',
  `sale_price` double(5,2) DEFAULT NULL COMMENT '销售价',
  `size` varchar(20) DEFAULT NULL COMMENT '尺码',
  `color` varchar(10) DEFAULT NULL COMMENT '颜色',
  `quantity` int(11) DEFAULT NULL COMMENT '商品件数',
  `sex` tinyint(2) DEFAULT NULL COMMENT '性别',
  `clothing_type` int(5) DEFAULT NULL COMMENT '服装类型',
  `purchase_time` datetime DEFAULT NULL COMMENT '进货时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加商品时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

/*Table structure for table `product_spec` */

DROP TABLE IF EXISTS `product_spec`;

CREATE TABLE `product_spec` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `product_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `color` varchar(20) DEFAULT NULL COMMENT '颜色',
  `size` int(2) DEFAULT NULL COMMENT '尺寸',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `purchase_time` varchar(50) DEFAULT NULL COMMENT '进货时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `product_store_upper` */

DROP TABLE IF EXISTS `product_store_upper`;

CREATE TABLE `product_store_upper` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_code` varchar(100) DEFAULT NULL COMMENT '商品编码',
  `store_id` int(11) DEFAULT NULL COMMENT '店铺ID',
  `quantity` int(11) DEFAULT NULL COMMENT '商品件数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='店铺上架商品';

/*Table structure for table `product_warehouse_stock` */

DROP TABLE IF EXISTS `product_warehouse_stock`;

CREATE TABLE `product_warehouse_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_code` varchar(100) DEFAULT NULL COMMENT '商品编码',
  `warehouse_id` int(11) DEFAULT NULL COMMENT '仓库ID',
  `quantity` int(11) DEFAULT NULL COMMENT '件数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='仓库存储商品数量';

/*Table structure for table `sale_product` */

DROP TABLE IF EXISTS `sale_product`;

CREATE TABLE `sale_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_code` varchar(100) DEFAULT NULL COMMENT '商品编码',
  `quantity` int(11) DEFAULT NULL COMMENT '商品件数',
  `sale_time` datetime DEFAULT NULL COMMENT '销售时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  `total_money` double(5,2) DEFAULT NULL COMMENT '销售收入',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品销售记录表';

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `store_name` varchar(100) DEFAULT NULL COMMENT '店名',
  `store_address` varchar(255) DEFAULT NULL COMMENT '店铺地址',
  `telephone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `manager` varchar(20) DEFAULT NULL COMMENT '店长',
  `start_business_time` varchar(20) DEFAULT NULL COMMENT '开业时间',
  `type` tinyint(2) DEFAULT NULL COMMENT '店铺类型',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='店铺表';

/*Table structure for table `warehouse` */

DROP TABLE IF EXISTS `warehouse`;

CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `warehouse_name` varchar(255) DEFAULT NULL COMMENT '仓库名称',
  `warehouse_address` varchar(255) DEFAULT NULL COMMENT '仓库地址',
  `build_date` varchar(20) DEFAULT NULL COMMENT '仓库创建时间',
  `type` tinyint(2) DEFAULT NULL COMMENT '仓库类型（0 为小仓，1为大仓）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='仓库表';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
