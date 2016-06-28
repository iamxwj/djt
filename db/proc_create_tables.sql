
#====================用户信息表 ========================================
CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',

  `name` VARCHAR(100) NOT NULL UNIQUE COMMENT '用户名',
  `email` VARCHAR(60) NOT NULL UNIQUE DEFAULT '' COMMENT '邮箱',
  `mobile` VARCHAR(20) NOT NULL UNIQUE DEFAULT '' COMMENT '手机号码',
  `password` VARCHAR(150) NOT NULL COMMENT '密码',
  `user_type` TINYINT NOT NULL COMMENT '用户类型: 1==>investor; 2==>institution; 3==>project',

  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB DEFAULT CHARSET = utf8;



#===============================机构相关表 ======================================================
# institution_info  institution_member  institution_case  institution_phase  institution_field
#===============================================================================================
CREATE TABLE IF NOT EXISTS `institution_info` (
  `institution_id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '机构ID',
  `user_id` BIGINT UNSIGNED COMMENT '用户ID',
  `institution_name` VARCHAR(60) NOT NULL DEFAULT '' COMMENT '机构名称',
  `institution_level` TINYINT NOT NULL DEFAULT 0 COMMENT '机构评级 1 ==> 正科; 2==>副处; ... 7==>正部',
  `found_year` VARCHAR(10) NOT NULL DEFAULT '' COMMENT '成立时间',
  `fund_number` DOUBLE NOT NULL DEFAULT 0 COMMENT '基金规模',
  `fund_unit` VARCHAR(15) NOT NULL DEFAULT '' COMMENT '基金单位（万元，万美元，亿元，亿美元）',
  `staff_size` VARCHAR(60) NOT NULL DEFAULT '' COMMENT '人员规模',

  `invest_type` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '投资类型',
  `invest_phase` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '投资阶段',
  `main_phase` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '主要投资阶段',
  `tag` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '标签',

  `first_fields` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '一级行业',
  `second_fields` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '二级行业',

  `web_logo` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '机构Web Logo',
  `mobile_logo` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '机构Mobile Logo',
  `institution_photo` VARCHAR(5000) NOT NULL DEFAULT '' COMMENT '机构照片',

  `invest_success_indicator` TINYINT NOT NULL DEFAULT 0 COMMENT '投资成功度',
  `invest_active_indicator` TINYINT NOT NULL DEFAULT 0 COMMENT '投资活跃度',
  `brand_indicator` TINYINT NOT NULL DEFAULT 0 COMMENT '品牌知名度',
  `invest_rate_indicator` TINYINT NOT NULL DEFAULT 0 COMMENT '投资速度',

  `province` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '机构总部所在省',
  `city` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '机构所在市',
  `address` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '地址',

  `locate_provinces` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '分布省份',
  `overall_rank` INTEGER NOT NULL DEFAULT 0 COMMENT '总排名',
  `annual_rank` INTEGER NOT NULL DEFAULT 0 COMMENT '年度排名',
  `active_rank` INTEGER NOT NULL DEFAULT 0 COMMENT '活跃度排名',

  `fans_number` INTEGER NOT NULL DEFAULT 0 COMMENT '粉丝数量',
  `talk_number` INTEGER NOT NULL DEFAULT 0 COMMENT '约谈数量',
  `invest_number` INTEGER NOT NULL DEFAULT 0 COMMENT '投资数量',

  `achievement` VARCHAR(600) NOT NULL DEFAULT '' COMMENT '机构的成就与荣誉',
  `institution_intro` VARCHAR(1000) NOT NULL DEFAULT '' COMMENT '机构简介',

  `authenticated` BOOLEAN NOT NULL DEFAULT FALSE COMMENT '机构是否认证过',

  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  FOREIGN KEY (`user_id`) REFERENCES `user_info`(`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


#==========================投资人相关表 =================================================
# investor_info investor_phase  investor_field  investor_case
#=======================================================================================
create TABLE IF NOT EXISTS `investor_info` (
  `investor_id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '投资人ID',
  `user_id` BIGINT UNSIGNED,
  `investor_name` VARCHAR(30) NOT NULL DEFAULT "" COMMENT '投资人名字',
  `investor_level` TINYINT NOT NULL DEFAULT 0 COMMENT '投资人评级',
  `birth_year` varchar(10) NOT NULL DEFAULT "" COMMENT '投资人出生年份',
  `native_province` VARCHAR(60) NOT NULL DEFAULT "" COMMENT '投资人籍贯省',
  `native_district` VARCHAR(60) NOT NULL DEFAULT "" COMMENT '投资人籍贯市',
  `age` INTEGER NOT NULL DEFAULT 1960 COMMENT '年龄',
  `gender` VARCHAR(20) NOT NULL DEFAULT "" COMMENT '性别',

  `invest_type` VARCHAR(200) NOT NULL DEFAULT "" COMMENT '投资类型',
  `invest_phase` VARCHAR(200) NOT NULL DEFAULT "" COMMENT '投资阶段',
  `main_phase` VARCHAR(100) NOT NULL DEFAULT "" COMMENT '主要投资阶段',
  `tag` VARCHAR(200) NOT NULL DEFAULT "" COMMENT '阿里系，北大系等标签',

  `first_fields` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '一级行业',
  `second_fields` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '二级行业',

  `investor_intro` VARCHAR(1200) NOT NULL DEFAULT "" COMMENT '投资人简介',
  `achievement` VARCHAR(1200) NOT NULL DEFAULT "" COMMENT '成就与荣誉',
  `education` VARCHAR(500) NOT NULL DEFAULT "" COMMENT '教育背景',
  `edu_exp` VARCHAR(1000) NOT NULL DEFAULT "" COMMENT '教育经历',
  `work_exp` VARCHAR(1200) NOT NULL DEFAULT "" COMMENT '工作经历',
  `invest_philosophy` VARCHAR(600) NOT NULL DEFAULT "" COMMENT '投资理念',
  `fund_number` DOUBLE NOT NULL DEFAULT 0 COMMENT '基金规模',
  `fund_unit` VARCHAR(15) NOT NULL DEFAULT '' COMMENT '基金单位（万元，万美元，亿元，亿美元）',
  `others` VARCHAR(600) NOT NULL DEFAULT "" COMMENT '其他信息',

  `institution_name` VARCHAR(50) NOT NULL DEFAULT "" COMMENT '所属机构',
  `investor_position` VARCHAR(60)  NOT NULL DEFAULT "" COMMENT '投资人职位',
  `institution_id` BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属投资机构ID',

  `invest_success_indicator` TINYINT NOT NULL DEFAULT 0 COMMENT '投资成功度',
  `invest_active_indicator` TINYINT NOT NULL DEFAULT 0 COMMENT '投资活跃度',
  `brand_indicator` TINYINT NOT NULL DEFAULT 0 COMMENT '品牌知名度',
  `invest_rate_indicator` TINYINT NOT NULL DEFAULT 0 COMMENT '投资速度',

  `overall_rank` INTEGER NOT NULL DEFAULT 0 COMMENT '总排名',
  `annual_rank` INTEGER NOT NULL DEFAULT 0 COMMENT '年度排名',
  `active_rank` INTEGER NOT NULL DEFAULT 0 COMMENT '活跃度排名',

  `fans_number` BIGINT NOT NULL DEFAULT 0 COMMENT '粉丝数量',
  `talk_number` INTEGER NOT NULL DEFAULT 0 COMMENT '约谈数量',
  `invest_number` INTEGER NOT NULL DEFAULT 0 COMMENT '投资数量',

  `province` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '投资人所在省',
  `city` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '投资人所在市',
  `address` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '投资人地址',

  `authenticated` BOOLEAN NOT NULL DEFAULT FALSE COMMENT '投资人是否认证过',
  `web_portrait` VARCHAR(1000) NOT NULL DEFAULT '' COMMENT 'Web端投资人头像(以|分隔)',
  `mobile_portrait` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '移动端投资人头像',
  `investor_photo` VARCHAR(10000) NOT NULL DEFAULT '' COMMENT '投资人照片(以|分隔)',

  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `level_type` TINYINT NOT NULL DEFAULT 1 COMMENT '人物级别',
  FOREIGN KEY (`user_id`) REFERENCES `user_info`(`user_id`) ON DELETE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


# CREATE TABLE IF NOT EXISTS `investor_phase` (
#   `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
#   `investor_id` BIGINT UNSIGNED NOT NULL ,
#   `phase_id` TINYINT UNSIGNED NOT NULL ,
#
#   UNIQUE KEY (`investor_id`, `phase_id`),
#   FOREIGN KEY (`investor_id`) REFERENCES `investor_info`(`investor_id`),
#   FOREIGN KEY (`phase_id`) REFERENCES `invest_phase`(`phase_id`)
# ) ENGINE = InnoDB DEFAULT CHARSET = utf8;
#
# CREATE TABLE IF NOT EXISTS `investor_field` (
#   `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
#   `investor_id` BIGINT UNSIGNED NOT NULL ,
#   `field_id` TINYINT UNSIGNED NOT NULL ,
#
#   UNIQUE KEY (`investor_id`, `field_id`),
#   FOREIGN KEY (`investor_id`) REFERENCES `investor_info`(`investor_id`),
#   FOREIGN KEY (`field_id`) REFERENCES `invest_field`(`field_id`)
# ) ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `follow` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `notice_list` BIGINT UNSIGNED NOT NULL COMMENT '关注者ID',
  `fans_list` BIGINT UNSIGNED NOT NULL COMMENT '被关注者ID',
  `group_id` BIGINT UNSIGNED  COMMENT '分组',
  `notice_type` TINYINT NOT NULL COMMENT  '关注者类型',
  `fans_type` TINYINT NOT NULL COMMENT '被关注者类型',
  FOREIGN KEY (`notice_list`) REFERENCES `user_info`(`user_id`),
  FOREIGN KEY (`fans_list`) REFERENCES `user_info`(`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `user_money_bag` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED NOT NULL COMMENT '钱包所属ID',
  `amount` INT(64) UNSIGNED NOT NULL COMMENT '金额',
  FOREIGN KEY (`user_id`) REFERENCES `user_info`(`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `user_money_bag_detail` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED NOT NULL COMMENT '钱包所属ID',
  `amount` INT(64) UNSIGNED NOT NULL COMMENT '金额',
  `operation_type` INTEGER DEFAULT 0 NOT NUll COMMENT '操作类型 求指教,投递,钱包',
  `tradeNo` VARCHAR(64) COMMENT  '支付宝交易号',
  `source_device` INT NOT NULL COMMENT '设备 web/mobile(android,IOS)',
  `trade_status` VARCHAR(20)  COMMENT '交易状态',
  `payment_type` INTEGER DEFAULT 0 NOT NULL COMMENT '支付类型 余额,支付宝',
  `create_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '交易时间',
  `buyer_email` VARCHAR(100) DEFAULT '' COMMENT '买家支付宝账号',
  `buyer_id` VARCHAR(30) DEFAULT '' COMMENT '买家支付宝账户号',
  `notify_id` VARCHAR(100) DEFAULT '' COMMENT '通知校验ID',
  `gmt_payment` VARCHAR(20) DEFAULT '' COMMENT '付款时间',
  `in_out` BOOLEAN NOT NULL DEFAULT 0 COMMENT '钱包消费还是充值',
  `refund_status` VARCHAR(20) DEFAULT '' COMMENT '退款状态',
  `delivery_to_user` BOOLEAN DEFAULT 0 COMMENT '是否已经支付成功过',
  FOREIGN KEY (`user_id`) REFERENCES `user_info`(`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `user_money_bag_detail_relative` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `ref_id` BIGINT UNSIGNED NOT NULL COMMENT '钱包所属ID',
  `amount` INT(64) UNSIGNED NOT NULL COMMENT '金额',
  `relative_id` BIGINT UNSIGNED NOT NULL COMMENT '钱包所属ID',

  FOREIGN KEY (`ref_id`) REFERENCES `user_money_bag_detail`(`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `request_cash` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED NOT NULL COMMENT '关联ID',
  `account` VARCHAR(100) NOT NULL COMMENT '提现账号',
  `name` VARCHAR(100) NOT NULL COMMENT '名字',
  `amount` INTEGER  NOT NULL COMMENT '钱数',
  `type` TINYINT(4) NOT NULL COMMENT '类型：支付宝 1，银行卡 2',
  `create_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '时间',
  FOREIGN KEY (`user_id`) REFERENCES `user_info`(`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;