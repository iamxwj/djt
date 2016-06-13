#========================= 元信息表 ======================================
# province   city   invest_phase  invest_field project_phase
#========================================================================
CREATE TABLE IF NOT EXISTS `province` (
  `province_id` INTEGER UNSIGNED PRIMARY KEY COMMENT '省份ID',
  `province_name` VARCHAR(50) NOT NULL COMMENT '省份名字'
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `city` (
  `city_id` INTEGER UNSIGNED PRIMARY KEY COMMENT '城市ID',
  `city_name` VARCHAR(60) NOT NULL  COMMENT '城市名字',
  `province_id` INTEGER UNSIGNED NOT NULL COMMENT '所属省份CODE',

  FOREIGN KEY (`province_id`) REFERENCES `province`(`province_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `invest_phase` (
  `phase_id` TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `phase_name` VARCHAR(20) NOT NULL COMMENT '阶段名称'
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `invest_field` (
  `field_id` TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `field_name` VARCHAR(20) NOT NULL COMMENT '领域名称',
  `field_type` VARCHAR(20) NOT NULL COMMENT '领域大类',

  UNIQUE KEY (`field_name`, `field_type`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `invest_member_level` (
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `level` VARCHAR(30)  NOT NULL ,
  `position` VARCHAR(30)  NOT NULL ,

  UNIQUE KEY (`level`, `position`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_phase` (
  `phase_id` TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `phase_name` VARCHAR(20) NOT NULL COMMENT '阶段名称'
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

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


  `achievement` VARCHAR(600) NOT NULL DEFAULT '' COMMENT '机构的成就与荣誉',
  `institution_intro` VARCHAR(1000) NOT NULL DEFAULT '' COMMENT '机构简介',


  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `institution_member` (
  `member_id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `member_name` VARCHAR(40) NOT NULL COMMENT '机构成员名字',
  `member_level` TINYINT NOT NULL DEFAULT 0 COMMENT '机构成员级别（首席合伙人、合伙人、团队）',
  `member_position` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '机构成员职位',
  `institution_id` BIGINT UNSIGNED NOT NULL COMMENT '所属机构ID',
  `member_photo` VARCHAR(200) COMMENT '机构成员照片',

  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  FOREIGN KEY (`institution_id`) REFERENCES `institution_info`(`institution_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `institution_case` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `institution_id` BIGINT UNSIGNED NOT NULL COMMENT '投资机构ID',
  `name` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '投资项目名称',
  `logo_path` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '项目图片',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `invest_unit` VARCHAR(20) DEFAULT '' COMMENT '金额单位',
  `invest_number` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '投资金额',
  FOREIGN KEY (`institution_id`) REFERENCES `institution_info`(`institution_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

# CREATE TABLE IF NOT EXISTS `institution_phase` (
#   `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
#   `institution_id` BIGINT UNSIGNED NOT NULL ,
#   `phase_id` TINYINT UNSIGNED NOT NULL ,
#
#   UNIQUE KEY (`institution_id`, `phase_id`),
#   FOREIGN KEY (`institution_id`) REFERENCES `institution_info`(`institution_id`),
#   FOREIGN KEY (`phase_id`) REFERENCES `invest_phase`(`phase_id`)
# ) ENGINE = InnoDB DEFAULT CHARSET = utf8;
#
# CREATE TABLE IF NOT EXISTS `institution_field` (
#   `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
#   `institution_id` BIGINT UNSIGNED NOT NULL ,
#   `field_id` TINYINT UNSIGNED NOT NULL ,
#
#   UNIQUE KEY (`institution_id`, `field_id`),
#   FOREIGN KEY (`institution_id`) REFERENCES `institution_info`(`institution_id`),
#   FOREIGN KEY (`field_id`) REFERENCES `invest_field`(`field_id`)
# ) ENGINE = InnoDB DEFAULT CHARSET = utf8;


#==========================投资人相关表 =================================================
# investor_info investor_phase  investor_field  investor_case
#=======================================================================================
create TABLE IF NOT EXISTS `investor_info` (
  `investor_id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '投资人ID',
  `investor_name` VARCHAR(30) NOT NULL DEFAULT "" COMMENT '投资人名字',
  `investor_level` TINYINT NOT NULL DEFAULT 0 COMMENT '投资人评级',
  `birth_year` varchar(10) NOT NULL DEFAULT "" COMMENT '投资人出生年份',
  `native_province` VARCHAR(60) NOT NULL DEFAULT "" COMMENT '投资人籍贯省',
  `native_district` VARCHAR(60) NOT NULL DEFAULT "" COMMENT '投资人籍贯市',
  `age` INTEGER NOT NULL DEFAULT 1960 COMMENT '年龄',
  `gender` VARCHAR(20) NOT NULL DEFAULT "" COMMENT '性别',

  `tag` VARCHAR(200) NOT NULL DEFAULT "" COMMENT '阿里系，北大系等标签',


  `investor_intro` VARCHAR(1200) NOT NULL DEFAULT "" COMMENT '投资人简介',
  `achievement` VARCHAR(1200) NOT NULL DEFAULT "" COMMENT '成就与荣誉',
  `education` VARCHAR(500) NOT NULL DEFAULT "" COMMENT '教育背景',
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

  `web_portrait` VARCHAR(1000) NOT NULL DEFAULT '' COMMENT 'Web端投资人头像(以|分隔)',
  `mobile_portrait` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '移动端投资人头像',
  `investor_photo` VARCHAR(10000) NOT NULL DEFAULT '' COMMENT '投资人照片(以|分隔)',

  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

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

#投资人投资的项目表
CREATE TABLE IF NOT EXISTS `investor_case` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `investor_id` BIGINT UNSIGNED NOT NULL COMMENT '投资人ID',
  `name` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '投资项目名称',
  `logo_path` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '项目图片',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `invest_unit` VARCHAR(20) DEFAULT '' COMMENT '金额单位',
  `invest_number` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '投资金额',

  FOREIGN KEY (`investor_id`) REFERENCES `investor_info`(`investor_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `notice` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED UNIQUE NOT NULL ,

  `notice_list` BIGINT UNSIGNED NOT NULL COMMENT '关注者ID',
  `fans_list` BIGINT UNSIGNED NOT NULL COMMENT '被关注者ID',

  FOREIGN KEY (`user_id`) REFERENCES `user_info`(`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `follow_group` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED NOT NULL COMMENT '关注者ID',
  `group_name` VARCHAR(20) NOT NULL  COMMENT '投资人简介',
  `group_description` VARCHAR(100)  DEFAULT  "" COMMENT '投资人简介',

  FOREIGN KEY (`user_id`) REFERENCES `user_info`(`user_id`)

) ENGINE = InnoDB DEFAULT CHARSET = utf8;

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

CREATE TABLE IF NOT EXISTS `session` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `from_user` BIGINT UNSIGNED NOT NULL COMMENT '发送者ID',
  `to_user` BIGINT UNSIGNED NOT NULL COMMENT '接收者ID',
  `last_update` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  delete_by_from TINYINT(1) DEFAULT '0',
  delete_by_to TINYINT(1) DEFAULT '0' ,
  FOREIGN KEY (`from_user`) REFERENCES `user_info`(`user_id`),
  FOREIGN KEY (`to_user`) REFERENCES `user_info`(`user_id`)

) ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `message` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `flag` BOOLEAN  NOT NULL DEFAULT 0 COMMENT '0 发送者发给接收者;1 接收者发给发送者',
  `viewed` BOOLEAN  NOT NULL DEFAULT 0 COMMENT '收这条消息的人是否阅读',
  `content` VARCHAR(160) NOT NULL  COMMENT '内容',
  `session_id` BIGINT UNSIGNED NOT NULL COMMENT 'session 表的外键',
  `create_date` TIMESTAMP NOT NULL  DEFAULT  CURRENT_TIMESTAMP,
  FOREIGN KEY (`session_id`) REFERENCES `session`(`id`)

) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `black_List` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `from_user` BIGINT UNSIGNED NOT NULL COMMENT '请求者ID',
  `to_user` BIGINT UNSIGNED NOT NULL COMMENT '禁言者ID',
  FOREIGN KEY (`from_user`) REFERENCES `user_info`(`user_id`),
  FOREIGN KEY (`to_user`) REFERENCES `user_info`(`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `session_setting` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `receive_from_unknown` BOOLEAN  NOT NULL DEFAULT 1 COMMENT '是否接受陌生人',
  `receive_from_system` BOOLEAN  NOT NULL DEFAULT 1 COMMENT '是否接收系统消息',
  `user_id` BIGINT UNSIGNED NOT NULL UNIQUE COMMENT '外键',
  FOREIGN KEY (`user_id`) REFERENCES `user_info`(`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

ALTER TABLE session
ADD CONSTRAINT uc_session UNIQUE (from_user,to_user);

CREATE TABLE IF NOT EXISTS `advice` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `from_user` BIGINT UNSIGNED NOT NULL COMMENT '发送者ID',
  `to_user` BIGINT UNSIGNED NOT NULL COMMENT '接收者ID',
  `title` VARCHAR(160) DEFAULT '' COMMENT '标题',
  `content` VARCHAR(1000) DEFAULT '' COMMENT '内容',
  `reply` VARCHAR(1000) DEFAULT '' COMMENT '回复',
  `payment` INT(64) UNSIGNED DEFAULT 0 COMMENT '红包',
  `state` TINYINT NOT NULL COMMENT '状态',
  `create_date` TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP COMMENT '创建时间',
  `reply_date` VARCHAR(25)   COMMENT '回复时间',
  `receive_payment` BOOLEAN DEFAULT 0 COMMENT '是否收到红包',
  `send_payment` BOOLEAN DEFAULT 0 COMMENT '是否支付红包',
  `deleted` BOOLEAN   DEFAULT 0 COMMENT '删除',
  `to_user_level` TINYINT(4) DEFAULT 0 COMMENT '对方的等级',
  `word_count_level` INTEGER DEFAULT 0 COMMENT '字数等级',
  `advice_difficulty` INTEGER DEFAULT 0 COMMENT '投递难度',
  FOREIGN KEY (`from_user`) REFERENCES `user_info`(`user_id`),
  FOREIGN KEY (`to_user`) REFERENCES `user_info`(`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_delivery` (
  id BIGINT(20) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  from_user BIGINT(20) UNSIGNED NOT NULL COMMENT '发送者ID',
  to_user BIGINT(20) UNSIGNED NOT NULL COMMENT '接收者ID',
  reply VARCHAR(1000) DEFAULT '' COMMENT '回复',
  contact VARCHAR(20) DEFAULT '' COMMENT '联系方式',
  state TINYINT(4) NOT NULL COMMENT '状态',
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
  receive_payment TINYINT(1) DEFAULT '0' COMMENT '是否收到红包',
  send_payment TINYINT(1) DEFAULT '0' COMMENT '是否支付红包',
  sender_comment VARCHAR(1000) DEFAULT '' COMMENT '创业者评论',
  receiver_comment VARCHAR(1000) DEFAULT '' COMMENT '接收者评论',
  already_delivery TINYINT(1) DEFAULT '0' NOT NULL,
  `payment` INT(64) UNSIGNED DEFAULT 0 COMMENT '红包',
  delivery_date VARCHAR(25) COMMENT '发送时间',
  love TINYINT(1) DEFAULT '0' COMMENT '热爱',
  hope TINYINT(1) DEFAULT '0' COMMENT '待观察',
  dislike TINYINT(1) DEFAULT '0' COMMENT '不看好',
  dolike TINYINT(1) DEFAULT '0',
  to_user_type TINYINT(4) NOT NULL,
  flag TINYINT(4) DEFAULT '0',
  discuss_detail VARCHAR(200) DEFAULT '' COMMENT '约谈内容',
  discuss_or_not TINYINT(1) DEFAULT '0' COMMENT '是否约谈',
  FOREIGN KEY (`from_user`) REFERENCES `user_info`(`user_id`),
  FOREIGN KEY (`to_user`) REFERENCES `user_info`(`user_id`)
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

CREATE TABLE IF NOT EXISTS `news` (
  `id` BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `title` VARCHAR(100)  NOT NULL COMMENT '新闻标题',
  `content` VARCHAR(3000)  NOT NULL COMMENT '新闻标题',
  `create_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '时间',
  `subtitle` VARCHAR(100)  DEFAULT '' COMMENT '新闻子标题',
  `author` VARCHAR(100)  DEFAULT '' COMMENT '新闻作者',
  `source_name` VARCHAR(100) DEFAULT ''  COMMENT '新闻来源名字',
  `source_url` VARCHAR(100)  DEFAULT '' COMMENT '新闻来源url',
  `img` VARCHAR(100) DEFAULT '' COMMENT '图片url'
) ENGINE = InnoDB DEFAULT CHARSET = utf8;