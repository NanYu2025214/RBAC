/*
 Navicat Premium Data Transfer

 Source Server         : Sql
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : rbac

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 13/06/2025 01:01:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('仅次于系统管理员的顶尖强者', '管理员', 1);
INSERT INTO `roles` VALUES ('叁仟世界中最弱小的种族，也是有着最强生命力的种族', '学生', 2);
INSERT INTO `roles` VALUES ('仅仅比学生种族强大', '教师', 3);
INSERT INTO `roles` VALUES ('叁仟世界中的至强者', '系统管理员', 4);
INSERT INTO `roles` VALUES ('学生种族的有效克星，令众多学生闻风丧胆！', '教导主任', 28);
INSERT INTO `roles` VALUES ('天外来客，拥有比叁仟世界还强大的位格之力，不知此番降临对世界的子民来说是福是祸', '校长', 29);

-- ----------------------------
-- Table structure for scores
-- ----------------------------
DROP TABLE IF EXISTS `scores`;
CREATE TABLE `scores`  (
  `sid` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chinese` float NULL DEFAULT NULL,
  `math` float NULL DEFAULT NULL,
  `english` float NULL DEFAULT NULL,
  `total` float NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of scores
-- ----------------------------
INSERT INTO `scores` VALUES (2, '楠', 81, 92, 103, 287);
INSERT INTO `scores` VALUES (3, '楠瑜', 60, 60, 60, 180);
INSERT INTO `scores` VALUES (14, '朱浩楠', 60, 81, 80, 221);
INSERT INTO `scores` VALUES (16, '朱筱瑜', 60, 67, 78, 205);
INSERT INTO `scores` VALUES (18, '朱浩瑜', 60, 76, 67, 203);
INSERT INTO `scores` VALUES (19, '嘉楠', 60, 45, 94, 199);
INSERT INTO `scores` VALUES (20, '张三', 123, 75, 95, 290);
INSERT INTO `scores` VALUES (21, '李四', 123, 97, 69, 289);
INSERT INTO `scores` VALUES (22, '王五', 75, 89, 68, 232);
INSERT INTO `scores` VALUES (23, '刘六', 78, 67, 84, 229);
INSERT INTO `scores` VALUES (24, '赵七', 64, 75, 43, 182);
INSERT INTO `scores` VALUES (25, '白八', 90, 45, 68, 203);
INSERT INTO `scores` VALUES (26, '姜玖', 34, 23, 102, 159);
INSERT INTO `scores` VALUES (28, 'Peter Griffen', 20, 101, 42, 163);
INSERT INTO `scores` VALUES (35, 'Brian Griffen', 80, 54, 60, 194);
INSERT INTO `scores` VALUES (36, 'Meg Griffen', 0, 0, 0, 0);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '用户管理', 'HTTP://ALJIAYU:5210', '可以增删改查用户信息');
INSERT INTO `sys_permission` VALUES (2, '角色管理', 'HTTP://ALJIAYU:5211', '可以增删改用户的角色');
INSERT INTO `sys_permission` VALUES (3, '日志查看', 'HTTP://ALJIAYU:5202', '查看系统操作信息');
INSERT INTO `sys_permission` VALUES (4, '数据导出', 'HTTP://ALJIAYU:5200', '可以将数据导出为word文档');
INSERT INTO `sys_permission` VALUES (5, '一票否决', 'HTTP://ALJIAYU:5210', '面临不利投票时，拥有一票否决权，可以省去很多麻烦');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `rid` int(11) NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1);
INSERT INTO `sys_role_permission` VALUES (1, 3);
INSERT INTO `sys_role_permission` VALUES (2, 3);
INSERT INTO `sys_role_permission` VALUES (3, 1);
INSERT INTO `sys_role_permission` VALUES (28, 1);
INSERT INTO `sys_role_permission` VALUES (28, 3);
INSERT INTO `sys_role_permission` VALUES (4, 1);
INSERT INTO `sys_role_permission` VALUES (4, 2);
INSERT INTO `sys_role_permission` VALUES (4, 3);
INSERT INTO `sys_role_permission` VALUES (4, 4);
INSERT INTO `sys_role_permission` VALUES (29, 1);
INSERT INTO `sys_role_permission` VALUES (29, 2);
INSERT INTO `sys_role_permission` VALUES (29, 3);
INSERT INTO `sys_role_permission` VALUES (29, 4);
INSERT INTO `sys_role_permission` VALUES (29, 5);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '鱼', '1221', '1');
INSERT INTO `sys_user` VALUES (2, '楠', '0806', '1');
INSERT INTO `sys_user` VALUES (3, '楠瑜', '1208', '1');
INSERT INTO `sys_user` VALUES (8, '吕嘉瑜', '1221', '1');
INSERT INTO `sys_user` VALUES (14, '朱浩楠', '0806', '1');
INSERT INTO `sys_user` VALUES (16, '朱筱瑜', '1208', '1');
INSERT INTO `sys_user` VALUES (18, '朱浩瑜', '1221', '1');
INSERT INTO `sys_user` VALUES (19, '嘉楠', '1221', '1');
INSERT INTO `sys_user` VALUES (20, '张三', '1111', '1');
INSERT INTO `sys_user` VALUES (21, '李四', '2222', '1');
INSERT INTO `sys_user` VALUES (22, '王五', '333', '1');
INSERT INTO `sys_user` VALUES (23, '刘六', '6666', '1');
INSERT INTO `sys_user` VALUES (24, '赵七', '7777', '1');
INSERT INTO `sys_user` VALUES (25, '白八', '8888', '1');
INSERT INTO `sys_user` VALUES (26, '姜玖', '9999', '1');
INSERT INTO `sys_user` VALUES (28, 'Peter Griffen', '1111', '1');
INSERT INTO `sys_user` VALUES (35, 'Brian Griffen', '123456', '1');
INSERT INTO `sys_user` VALUES (36, 'Meg Griffen', '1111', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `rid` int(11) NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 16);
INSERT INTO `sys_user_role` VALUES (2, 16);
INSERT INTO `sys_user_role` VALUES (3, 8);
INSERT INTO `sys_user_role` VALUES (4, 8);
INSERT INTO `sys_user_role` VALUES (2, 14);
INSERT INTO `sys_user_role` VALUES (2, 18);
INSERT INTO `sys_user_role` VALUES (2, 19);
INSERT INTO `sys_user_role` VALUES (2, 20);
INSERT INTO `sys_user_role` VALUES (2, 21);
INSERT INTO `sys_user_role` VALUES (2, 22);
INSERT INTO `sys_user_role` VALUES (2, 23);
INSERT INTO `sys_user_role` VALUES (2, 24);
INSERT INTO `sys_user_role` VALUES (2, 25);
INSERT INTO `sys_user_role` VALUES (2, 26);
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (3, 1);
INSERT INTO `sys_user_role` VALUES (1, 2);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (2, 3);
INSERT INTO `sys_user_role` VALUES (2, 28);
INSERT INTO `sys_user_role` VALUES (2, 29);
INSERT INTO `sys_user_role` VALUES (2, 35);
INSERT INTO `sys_user_role` VALUES (2, 36);

-- ----------------------------
-- Table structure for sys_user_score
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_score`;
CREATE TABLE `sys_user_score`  (
  `uid` int(11) NULL DEFAULT NULL,
  `sid` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_score
-- ----------------------------
INSERT INTO `sys_user_score` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
