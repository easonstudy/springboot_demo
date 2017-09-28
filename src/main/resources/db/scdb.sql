/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : scdb

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-09-28 18:21:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `status` int(4) DEFAULT '1',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_login_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member
-- ----------------------------
INSERT INTO `t_member` VALUES ('1', '1', 'gmh', '123456', '1', null, null);
INSERT INTO `t_member` VALUES ('2', '2', 'xx', '123456', '1', null, null);

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT 'url描述/名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('4', '/permission/list', '权限列表', null);
INSERT INTO `t_permission` VALUES ('5', '/shops/list', '商品列表', null);
INSERT INTO `t_permission` VALUES ('6', '/permission/edit', '权限编辑', '4');
INSERT INTO `t_permission` VALUES ('7', '/shops/edit', '商品编辑', '5');

-- ----------------------------
-- Table structure for t_permission_init
-- ----------------------------
DROP TABLE IF EXISTS `t_permission_init`;
CREATE TABLE `t_permission_init` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `permission_init` varchar(255) DEFAULT NULL COMMENT '需要具备的权限',
  `sort` int(50) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission_init
-- ----------------------------
INSERT INTO `t_permission_init` VALUES ('1', '/static/**', 'anon', '1');
INSERT INTO `t_permission_init` VALUES ('3', '/logout', 'logout', '3');
INSERT INTO `t_permission_init` VALUES ('4', '/add', 'perms[权限添加:权限删除],roles[100002],kickout', '4');
INSERT INTO `t_permission_init` VALUES ('5', '/**', 'user,kickout', '5');
INSERT INTO `t_permission_init` VALUES ('6', '/getGifCode', 'anon,kickout', '2');
INSERT INTO `t_permission_init` VALUES ('7', '/kickout', 'anon', '2');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '系统管理员', '100004');
INSERT INTO `t_role` VALUES ('3', '权限角色', '100001');
INSERT INTO `t_role` VALUES ('4', '用户中心', '100002');
INSERT INTO `t_role` VALUES ('5', '角色管理', '100003');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `rid` varchar(64) DEFAULT NULL COMMENT '角色ID',
  `pid` varchar(64) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1', '4', '8');
INSERT INTO `t_role_permission` VALUES ('2', '4', '9');
INSERT INTO `t_role_permission` VALUES ('3', '4', '10');
INSERT INTO `t_role_permission` VALUES ('4', '4', '11');
INSERT INTO `t_role_permission` VALUES ('5', '4', '12');
INSERT INTO `t_role_permission` VALUES ('6', '3', '4');
INSERT INTO `t_role_permission` VALUES ('7', '3', '6');
INSERT INTO `t_role_permission` VALUES ('8', '3', '7');
INSERT INTO `t_role_permission` VALUES ('9', '3', '13');
INSERT INTO `t_role_permission` VALUES ('10', '3', '14');
INSERT INTO `t_role_permission` VALUES ('11', '3', '15');
INSERT INTO `t_role_permission` VALUES ('12', '3', '16');
INSERT INTO `t_role_permission` VALUES ('13', '3', '17');
INSERT INTO `t_role_permission` VALUES ('14', '3', '18');
INSERT INTO `t_role_permission` VALUES ('15', '3', '19');
INSERT INTO `t_role_permission` VALUES ('16', '3', '20');
INSERT INTO `t_role_permission` VALUES ('17', '1', '4');
INSERT INTO `t_role_permission` VALUES ('18', '1', '6');
INSERT INTO `t_role_permission` VALUES ('19', '1', '7');
INSERT INTO `t_role_permission` VALUES ('20', '1', '8');
INSERT INTO `t_role_permission` VALUES ('21', '1', '9');
INSERT INTO `t_role_permission` VALUES ('22', '1', '10');
INSERT INTO `t_role_permission` VALUES ('23', '1', '11');
INSERT INTO `t_role_permission` VALUES ('24', '1', '12');
INSERT INTO `t_role_permission` VALUES ('25', '1', '13');
INSERT INTO `t_role_permission` VALUES ('26', '1', '14');
INSERT INTO `t_role_permission` VALUES ('27', '1', '15');
INSERT INTO `t_role_permission` VALUES ('28', '1', '16');
INSERT INTO `t_role_permission` VALUES ('29', '1', '17');
INSERT INTO `t_role_permission` VALUES ('30', '1', '18');
INSERT INTO `t_role_permission` VALUES ('31', '1', '19');
INSERT INTO `t_role_permission` VALUES ('32', '1', '20');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `pswd` varchar(255) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` tinyint(4) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin@qq.com', 'CpievEp3tWpuK7exnZldGFzkQJDBPimEt+zG1EbUth6pmRt2pMLwSxtNJEhBRJRU', '2017-09-20 14:47:03', '2017-09-20 14:47:03', '1');
INSERT INTO `t_user` VALUES ('11', 'root', '8446666@qq.com', 'CpievEp3tWpuK7exnZldGFzkQJDBPimEt+zG1EbUth6pmRt2pMLwSxtNJEhBRJRU', '2016-05-26 20:50:54', '2017-02-13 15:49:04', '1');
INSERT INTO `t_user` VALUES ('12', '8446666', '8446666', 'CpievEp3tWpuK7exnZldGFzkQJDBPimEt+zG1EbUth6pmRt2pMLwSxtNJEhBRJRU', '2016-05-27 22:34:19', '2016-06-15 17:03:16', '1');
INSERT INTO `t_user` VALUES ('13', '123', '123', 'CpievEp3tWpuK7exnZldGFzkQJDBPimEt+zG1EbUth6pmRt2pMLwSxtNJEhBRJRU', '2016-05-27 22:34:19', '2016-06-15 17:03:16', '0');
INSERT INTO `t_user` VALUES ('14', 'haiqin', '123123@qq.com', 'CpievEp3tWpuK7exnZldGFzkQJDBPimEt+zG1EbUth6pmRt2pMLwSxtNJEhBRJRU', '2016-05-27 22:34:19', '2017-03-23 21:39:44', '1');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `uid` varchar(64) DEFAULT NULL COMMENT '用户ID',
  `rid` varchar(64) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '12', '4');
INSERT INTO `t_user_role` VALUES ('2', '11', '3');
INSERT INTO `t_user_role` VALUES ('3', '11', '4');
INSERT INTO `t_user_role` VALUES ('4', '1', '1');
SET FOREIGN_KEY_CHECKS=1;
