CREATE TABLE IF NOT EXISTS `notice_table` (
    `noticeId` INTEGER AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `content` TEXT NOT NULL,
    `createtime` DATETIME NOT NULL,
    `courseId` INTEGER NOT NULL,
    PRIMARY KEY (`noticeId`)
);

INSERT INTO `notice_table` VALUES 
(
	1,
	'高数考试时间',
	'星期五下午2点半',
	'2017-01-01 08:00:01',
	'1700000000'
),
(
	2,
	'高数取消考试',
	'高数没有考试很舒服',
	'2017-01-01 08:00:02',
	'1700000000'
);