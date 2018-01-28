-- 微信汽车购票系统数据库脚本
-- 删除已存在数据库
DROP DATABASE IF EXISTS bus;

-- 创建数据库
CREATE DATABASE bus;
USE bus;

-- 创建后台管理系统管理员信息表
DROP TABLE IF EXISTS `bus`.`tb_admin`;
CREATE TABLE `tb_admin` (
	`admin_id` INT NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
	`admin_uname` VARCHAR(30) NOT NULL UNIQUE COMMENT '管理员用户名',
	`admin_name` VARCHAR(20) DEFAULT NULL COMMENT '管理员真实姓名',
	`admin_password` VARCHAR(16) NOT NULL COMMENT '管理员密码',
	`admin_level` VARCHAR(3) NOT NULL COMMENT '管理员权限,权限等级有数字递减，1为最高级权限',
	PRIMARY KEY (`admin_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '管理员信息表';

-- 创建班次目的地信息表
DROP TABLE IF EXISTS `bus`.`tb_destination`;
CREATE TABLE `tb_destination` (
	`destination_id` VARCHAR(5) NOT NULL COMMENT '目的地编号',
	`destination_name` VARCHAR(255) NOT NULL UNIQUE COMMENT '目的地名称',
	`destination_top` VARCHAR(5) DEFAULT NULL COMMENT '上级目的地编号',
	`destination_level` VARCHAR(1) NOT NULL COMMENT '目的地级别：1省、2市、3区县',
	PRIMARY KEY (`destination_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '目的地信息表';

-- 创建管理员功能模块表
DROP TABLE IF EXISTS `bus`.`tb_module`;
CREATE TABLE `tb_module` (
	`module_id` VARCHAR(3) NOT NULL COMMENT '模块编号',
	`module_name` VARCHAR(50) NOT NULL COMMENT '模块名称',
	`module_url` VARCHAR(2048) NOT NULL COMMENT '模块链接',
	`module_level` VARCHAR(3) NOT NULL COMMENT '模块的访问权限',
	`module_top` VARCHAR(3) DEFAULT NULL COMMENT '上级模块编号',
	PRIMARY KEY (`module_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '管理员功能模块表';

-- 创建旅客信息表
DROP TABLE IF EXISTS `bus`.`tb_traveller`;
CREATE TABLE `tb_traveller` (
	`traveller_id` VARCHAR(18) NOT NULL COMMENT '旅客身份证',
	`traveller_name` VARCHAR(30) NOT NULL COMMENT '旅客真实姓名',
	`traveller_phone` VARCHAR(20) DEFAULT NULL COMMENT '旅客手机号',
	PRIMARY KEY (`traveller_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '旅客信息表';

-- 创建公众号关注用户信息表
DROP TABLE IF EXISTS `bus`.`tb_user`;
CREATE TABLE `tb_user` (
	`user_id` varchar(50) NOT NULL COMMENT '关注用户的openid',
	`user_wxname` varchar(255) NOT NULL COMMENT '关注用户的微信名字',
	`user_phone` varchar(20) DEFAULT NULL COMMENT '关注用户的手机号码',
	`user_photo` varchar(2048) NOT NULL COMMENT '关注用户的头像url',
	`user_date` datetime NOT NULL COMMENT '关注用户关注的日期',
	`user_cancel` tinyint DEFAULT 0 COMMENT '用户是否取消关注',
	`user_token` varchar(100) DEFAULT NULL COMMENT '用户登录的token',
	PRIMARY KEY (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '公众号关注用户信息表';

-- 创建常用旅客信息表
DROP TABLE IF EXISTS `bus`.`tb_user_traveller`;
CREATE TABLE `tb_user_traveller` (
	`user_id` VARCHAR(50) NOT NULL COMMENT '关注用户的openid,对应tb_user表中的主键',
	`traveller_id` VARCHAR(18) NOT NULL COMMENT '旅客身份证,对应tb_traveller表中的主键',
	PRIMARY KEY (`user_id`,`traveller_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '常用旅客信息表';

-- 创建汽车班次信息表
DROP TABLE IF EXISTS `bus`.`tb_car`;
CREATE TABLE `tb_car` (
	`car_id` VARCHAR(32) NOT NULL COMMENT '班次编号',
	`car_source` VARCHAR(5) NOT NULL COMMENT '班次发车地编号,对应tb_destination表中的主键',
	`car_destination` VARCHAR(5) NOT NULL COMMENT '班次目的地编号,对应tb_destination表中的主键',
	`car_time` DATETIME NOT NULL COMMENT '班次发车时间点',
	`car_max` INT(2) NOT NULL COMMENT '汽车限客量',
	`car_length` INT(5) NOT NULL COMMENT '大约车程，时长（单位m）',
	`car_price` DOUBLE NOT NULL COMMENT '参考票价',
	PRIMARY KEY (`car_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '汽车班次信息表';

-- 创建车票信息表
DROP TABLE IF EXISTS `bus`.`tb_ticket`;
CREATE TABLE `tb_ticket` (
	`ticket_car_id` VARCHAR(32) NOT NULL COMMENT '班次编号,对应tb_car表的主键',
	`ticket_num` INT(2) NOT NULL COMMENT '座位号',
	`ticket_traveller_id` VARCHAR(18) NOT NULL COMMENT '旅客身份证,对应tb_traveller表的主键',
	`ticket_order_id` VARCHAR(50) NOT NULL COMMENT '车票所属订单编号，对应tb_order表的主键',
	`ticket_type` VARCHAR(1) NOT NULL COMMENT '车票类型（1：成人票、2：儿童票、0：免费票）',
	`ticket_price` DOUBLE NOT NULL COMMENT '车票真实价格',
	PRIMARY KEY (`ticket_car_id`,`ticket_num`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '车票信息表';

-- 创建订单信息表
DROP TABLE IF EXISTS `bus`.`tb_order`;
CREATE TABLE `tb_order` (
	`order_id` VARCHAR(50) NOT NULL COMMENT '订单编号',
	`order_user_id` VARCHAR(50) NOT NULL COMMENT '订单所属的关注用户,对应tb_user表的主键',
	`order_trx_id` VARCHAR(50) DEFAULT NULL COMMENT '易宝交易流水号',
	`order_down_time` DATETIME NOT NULL COMMENT '下单时间',
	`order_pay_time` DATETIME DEFAULT NULL COMMENT '订单支付时间',
	`order_cancel_time` DATETIME DEFAULT NULL COMMENT '订单取消时间',
	`order_state` VARCHAR(1) NOT NULL COMMENT '订单的状态，0：已支付，1：未支付，2：已取消，3：已超时，4：待审核（退款），5：已退款',
	`order_total` DOUBLE NOT NULL COMMENT '订单实付款总额',
	PRIMARY KEY (`order_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '订单信息表';

-- 创建公众号菜单信息表
DROP TABLE IF EXISTS `bus`.`tb_menu`;
CREATE TABLE `tb_menu` (
	`menu_id` VARCHAR(3) NOT NULL COMMENT '菜单编号',
	`menu_name` VARCHAR(50) NOT NULL COMMENT '菜单名字',
	`menu_type` VARCHAR(20) NOT NULL COMMENT '菜单类型',
	`menu_url` VARCHAR(2048) NOT NULL COMMENT '菜单链接',
	`menu_top` VARCHAR(3) DEFAULT NULL COMMENT '上级菜单编号',
	PRIMARY KEY (`menu_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '公众号菜单信息表';

-- 添加外键约束
# ALTER TABLE `bus`.`tb_car` ADD CONSTRAINT fk_car_source_id FOREIGN KEY(`car_source`) REFERENCES `bus`.`tb_destination`(`destination_id`);
# ALTER TABLE `bus`.`tb_car` ADD CONSTRAINT fk_car_destination_id FOREIGN KEY(`car_destination`) REFERENCES `bus`.`tb_destination`(`destination_id`);
# ALTER TABLE `bus`.`tb_user_traveller` ADD CONSTRAINT fk_user_traveller_user_id FOREIGN KEY(`user_id`) REFERENCES `bus`.`tb_user`(`user_id`);
# ALTER TABLE `bus`.`tb_user_traveller` ADD CONSTRAINT fk_user_traveller_traveller_id FOREIGN KEY(`traveller_id`) REFERENCES `bus`.`tb_traveller`(`traveller_id`);
# ALTER TABLE `bus`.`tb_ticket` ADD CONSTRAINT fk_ticket_car_id FOREIGN KEY(`ticket_car_id`) REFERENCES `bus`.`tb_car`(`car_id`);
# ALTER TABLE `bus`.`tb_ticket` ADD CONSTRAINT fk_ticket_traveller_id FOREIGN KEY(`ticket_traveller_id`) REFERENCES `bus`.`tb_traveller`(`traveller_id`);
# ALTER TABLE `bus`.`tb_ticket` ADD CONSTRAINT fk_ticket_order_id FOREIGN KEY(`ticket_order_id`) REFERENCES `bus`.`tb_order`(`order_id`);
# ALTER TABLE `bus`.`tb_order` ADD CONSTRAINT fk_order_user_id FOREIGN KEY(`order_user_id`) REFERENCES `bus`.`tb_user`(`user_id`);