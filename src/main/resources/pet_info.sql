/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : pet_info

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2017-07-14 21:40:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_employee
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `id` varchar(30) NOT NULL DEFAULT '' COMMENT '主键编号',
  `login_name` varchar(30) NOT NULL COMMENT '登陆名',
  `need_change_password` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否需要更改密码  0：否。1：是',
  `last_login_date` datetime NOT NULL,
  `register_date` datetime NOT NULL COMMENT '注册时间',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `id_number` varchar(18) NOT NULL COMMENT '身份证号',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '账户状态，0：禁用，1：启用',
  `mobile` varchar(30) NOT NULL COMMENT '手机号',
  `name` varchar(30) NOT NULL DEFAULT '' COMMENT '员工真实姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_employee
-- ----------------------------

-- ----------------------------
-- Table structure for tb_employee_login_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee_login_record`;
CREATE TABLE `tb_employee_login_record` (
  `id` varchar(30) NOT NULL,
  `employee_id` varchar(30) NOT NULL COMMENT '员工编号',
  `login_info` varchar(60) DEFAULT NULL COMMENT '登录信息，可以存放登陆的IP地址或者是设备唯一号，或者是经纬度',
  `login_time` datetime NOT NULL COMMENT '登陆时间',
  `source` varchar(20) NOT NULL COMMENT '登陆来源，如pc,h5,android,ios等',
  `success` tinyint(1) NOT NULL COMMENT '是否成功登陆，0：登陆失败，1：登陆成功 ',
  PRIMARY KEY (`id`),
  KEY `FK_TB_EMPLOYEE_LOGIN_RECORD_EMPLOYEE_ID` (`employee_id`),
  CONSTRAINT `FK_TB_EMPLOYEE_LOGIN_RECORD_EMPLOYEE_ID` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_employee_login_record
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` varchar(30) NOT NULL COMMENT '主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
