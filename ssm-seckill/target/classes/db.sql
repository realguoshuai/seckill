CREATE DATABASE `seckill`;

-- 用户表
CREATE TABLE `user`(
	`id` int primary key auto_increment,
	`email` varchar(20) not null,
	`password` varchar(20) not null
);

-- 秒杀商品列表
CREATE TABLE `goods`(
	`id` int primary key auto_increment,
	`name` varchar(20) not null,
	`info` varchar(500) not null,
	`image` char(32),
	`count` int not null,
	`price` int not null,
	`begin_time` datetime not null,
	`end_time` datetime not null
);

-- 秒杀记录表
CREATE TABLE `user_goods`(
	`user_id` int,
	`goods_id` int,
	`count` int,
	`time` datetime default current_timestamp,
	primary key(user_id, goods_id)
);

INSERT INTO user VALUES(null, 'zhangsan@163.com', '123456');
INSERT INTO user VALUES(null, 'lisi@qq.com', '123456');


INSERT INTO goods VALUES(null, '费列罗巧克力礼盒装', '生日礼物送女友，加49送价值99元香皂花礼盒一份', null, 100, 79, '2017-12-20 12:00:00', '2017-12-21 12:00:00');
INSERT INTO goods VALUES(null, '德尔玛（Deerma）加湿器', '【取暖伴侣！京东力荐冬季驱燥神器！底价抢，类目火热，抢完即止】【5L大容量爆款静音加湿器！】活性炭过滤网+趋零辐射设计，宝妈放心使用！大屏幕数显+实时感应温度，加湿更健康！新增12小时定时功能！', null, 100, 99, '2017-12-21 18:00:00', '2017-12-22 18:00:00');
INSERT INTO goods VALUES(null, '联想（ThinkPad） E470c', '联想（ThinkPad） E470c（20H3A00JCD）14英寸笔记本电脑（i3-6006U 4G 256GSSD 2G独显 Win10）黑色，新经典，新传承！ 23.7mm轻薄，高效5小时续航！', null, 200, 3899, '2017-12-21 12:00:00', '2017-12-22 18:00:00');
INSERT INTO goods VALUES(null, '飞利浦（PHILIPS）电动牙刷', 'HX6761/03亮白型成人充电式声波震动牙刷粉色【圣诞狂欢】秒杀价388元！下单限量赠镜子！数量有限 ！抢完即止！19-25日火爆开抢！立即抢购！', null, 100, 388, '2017-12-22 12:00:00', '2017-12-23 12:00:00');
INSERT INTO goods VALUES(null, '红星蓝瓶二锅头', '红星 红星蓝瓶二锅头 绵柔8陈酿 43度 750ml*6瓶 整箱装 （新老包装随机发货）【京东自营，品质保证】寒冬已至 选好酒上京东 自营白酒专场', null, 100, 179, '2017-12-20 12:00:00', '2017-12-24 12:00:00');
INSERT INTO goods VALUES(null, 'Guylian吉利莲', '比利时进口 Guylian吉利莲 金贝壳巧克力礼盒250g【京东自营，品质保证】我们一路走一路被辜负，一路点燃希望一路寻找答案。在灯火靡靡的城市，寻觅摸索，摸爬滚打，才发现唯有爱和美食不可辜负。', null, 100, 75, '2017-12-22 12:00:00', '2017-12-23 12:00:00');


INSERT INTO user_goods (user_id, goods_id, count) VALUES (1, 1, 20);

