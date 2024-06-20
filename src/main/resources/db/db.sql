/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云数据库web
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : rm-wz9a978ly829cb29n6o.mysql.rds.aliyuncs.com:3306
 Source Schema         : web_homework

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 20/06/2024 18:48:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`
(
    `name`  varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '注册权限准许',
    `allow` int                                                           NOT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority`
VALUES ('register', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`                   int                                                           NOT NULL AUTO_INCREMENT,
    `account`              varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
    `role`                 varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
    `salt`                 varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
    `salt_hashed_password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
    `username`             varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
    `email`                varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
    `phone`                varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
    `identity`             varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
    `status`               int                                                           NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, '2021150047', '学生', 'random_salt_1', '3b1d6e26fb87db9952ff40543b2fb4f58dabc710fec815ec8b479382e5fc946f',
        '张三', 'zhangsan@example.com', '23812345678', '510100198001012345', 1);
INSERT INTO `user`
VALUES (2, '1000000002', '学生', 'random_salt_2', 'hashed_password_2', '李四', 'lisi@example.com', '13912345678',
        '510100198002012345', 1);
INSERT INTO `user`
VALUES (3, '6666666666', '老师', 'random_salt_3', 'b337ecbee339650e3b7c2f74ad3646e7153f7eaa9abc325b2bfc6b192de6c190',
        '王五', 'wangwu666@example.com', '13712345678', '510100198003012345', 1);
INSERT INTO `user`
VALUES (4, '1000000003', '学生', 'random_salt_4', 'hashed_password_4', '赵六', 'zhaoliu@example.com', '13612345678',
        '510100198004012345', 1);
INSERT INTO `user`
VALUES (5, '8888888888', '老师', 'random_salt_5', 'hashed_password_5', '钱七', 'qianqi@example.com', '13512345678',
        '510100198005012345', 1);
INSERT INTO `user`
VALUES (6, '2021150048', '学生', 'random_salt_592', 'b0c0372d5d3a08737d944ef62ce7551838e5b675c047d18cb643cbc3ce9ffcf1',
        '老三', 'laosan@qq.com', '13511112222', '111111222222223333', 1);

SET FOREIGN_KEY_CHECKS = 1;
