create database web_homework;
-- 用户表
create table if not exists web_homework.`user`
(
    `id`                   bigint                                 not null auto_increment comment '主键' primary key,
    `username`             varchar(256)                           not null comment '昵称',
    `account`              varchar(256)                           not null comment '账号',
    `role`                 varchar(128) default '学生'            not null comment '身份',
    `mail`                 varchar(256)                           not null comment '邮箱',
    `signature`            varchar(512)                           not null comment '签名',
    `submit_experiment`    varchar(1024)                          not null comment '已提交实验',
    `to_submit_experiment` varchar(1024)                          not null comment '未提交实验',
    `to_do`                varchar(1024)                          not null comment '用户待办事件（推荐用json）',
    `avatar`               varchar(512)                           not null comment '头像',
    `create_time`          datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time`          datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_deleted`           tinyint      default 0                 not null comment '是否删除(0-未删, 1-已删)'
) comment '用户表';

insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('陆文', '15117844982', '冯涛', 'ada.hill@gmail.com', '西北农业大学', 'www.shirely-bednar.info',
        'www.vivan-wilkinson.name', '1659539849286', 'www.lynda-kiehn.biz');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('杨文', '15696787741', '邱鸿煊', 'akilah.schaden@yahoo.com', '南经贸大学', 'www.sarina-schumm.name',
        'www.leonard-raynor.com', '1665781051616', 'www.janis-maggio.org');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('郝峻熙', '17828478220', '唐晓博', 'jamey.lang@hotmail.com', '西体育大学', 'www.ira-sporer.net',
        'www.mac-mraz.name', '1660662718033', 'www.rosette-parker.net');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('杜聪健', '18516017054', '万荣轩', 'timmy.beahan@hotmail.com', '南农业大学', 'www.catharine-kassulke.io',
        'www.arturo-lynch.com', '1655567441360', 'www.phillip-ankunding.biz');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('李晓博', '17095866279', '谭明轩', 'pamelia.terry@hotmail.com', '东北理工大学', 'www.queenie-streich.info',
        'www.lanita-nolan.name', '1659878254706', 'www.dawna-franecki.org');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('张博涛', '17728509955', '曹乐驹', 'christian.morissette@yahoo.com', '西南经贸大学', 'www.margery-haag.info',
        'www.ada-stoltenberg.io', '1655705784828', 'www.virgilio-kling.info');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('陆振家', '13094487509', '熊立果', 'philip.runte@hotmail.com', '北科技大学', 'www.russel-johnston.name',
        'www.oscar-gaylord.co', '1658940264750', 'www.jean-glover.biz');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('段修洁', '15993286500', '董智宸', 'jeffie.lubowitz@gmail.com', '东北艺术大学', 'www.jonas-heller.io',
        'www.tawana-carter.io', '1654695324006', 'www.jane-runte.biz');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('朱昊强', '17538221858', '侯鹤轩', 'trevor.padberg@hotmail.com', '北体育大学', 'www.kitty-shields.io',
        'www.ulrike-wintheiser.biz', '1664540562362', 'www.lavone-legros.org');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('谭擎苍', '15858750630', '莫立诚', 'lee.torphy@hotmail.com', '北艺术大学', 'www.hipolito-kunze.com',
        'www.sean-fritsch.org', '1652489105930', 'www.frankie-pfeffer.co');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('张立辉', '15832447176', '江子骞', 'ma.treutel@gmail.com', '北体育大学', 'www.antwan-hagenes.name',
        'www.scott-feil.info', '1641959117977', 'www.rocco-schaden.net');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('魏天磊', '17102708480', '程晋鹏', 'earle.will@gmail.com', '西南技术大学', 'www.nicholle-frami.biz',
        'www.ray-wolf.io', '1665875626785', 'www.heath-cronin.org');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('卢皓轩', '15848091999', '石胤祥', 'dagmar.crooks@hotmail.com', '西大学', 'www.rene-bechtelar.biz',
        'www.shala-smith.biz', '1672452538505', 'www.golden-gusikowski.net');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('何昊焱', '15970476786', '莫睿渊', 'noah.hermann@gmail.com', '东北技术大学', 'www.markus-herman.biz',
        'www.santo-lockman.info', '1641543353508', 'www.vern-wilkinson.name');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('胡彬', '13241696111', '金鹏涛', 'hubert.stanton@yahoo.com', '东北经贸大学', 'www.donnell-white.info',
        'www.royal-gutmann.name', '1648413313439', 'www.amee-kertzmann.com');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('贾航', '17821721914', '王煜城', 'dean.breitenberg@hotmail.com', '东科技大学', 'www.chelsey-gaylord.net',
        'www.lissa-cartwright.com', '1666730171150', 'www.sharie-hammes.biz');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('毛志泽', '17301593558', '赖立诚', 'cedric.fritsch@yahoo.com', '东北体育大学', 'www.melody-stroman.com',
        'www.joetta-schumm.org', '1645349704368', 'www.katina-ortiz.name');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('黎潇然', '13454485444', '贾航', 'raymond.bruen@hotmail.com', '东北技术大学', 'www.wilmer-kuphal.info',
        'www.ludie-gerlach.co', '1663381349222', 'www.hugh-marks.net');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('田聪健', '17138108457', '邵果', 'spring.emard@yahoo.com', '东北理工大学', 'www.renea-christiansen.org',
        'www.lara-stark.info', '1652946448627', 'www.lee-kuhlman.net');
insert into web_homework.`user` (`username`, `account`, `role`, `mail`, `signature`, `submit_experiment`,
                                 `to_submit_experiment`, `to_do`, `avatar`)
values ('韦煜祺', '17388389089', '韦烨华', 'zachariah.powlowski@yahoo.com', '中国农业大学', 'www.mariah-franecki.biz',
        'www.eddy-rohan.name', '1651354143612', 'www.laronda-kuhic.net');


-- 用户关联习题
create table if not exists web_homework.`user_test`
(
    `teacher`     varchar(256)                       not null comment '老师',
    `student`     varchar(256)                       not null comment '学生',
    `description` varchar(1024)                      not null comment '题目描述',
    `testName`    varchar(256)                       not null comment '题目标题',
    `detail`      varchar(1024)                      not null comment '题目内容',
    `status`      tinyint  default 0                 not null comment '状态 是否完成 0否',
    `id`          bigint                             not null auto_increment comment '主键' primary key,
    `create_time` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_deleted`  tinyint  default 0                 not null comment '是否删除(0-未删, 1-已删)'
) comment '用户关联习题';

insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('毛晓啸', '侯熠彤', '西北大学', '西体育大学', '鞍山');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('金梓晨', '孙黎昕', '东农业大学', '中国技术大学', '安阳');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('马立辉', '尹弘文', '东南科技大学', '东大学', '文登');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('汪建辉', '郝振家', '中国农业大学', '北农业大学', '潍坊');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('武弘文', '段展鹏', '西北农业大学', '东北农业大学', '鄂尔多斯');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('田熠彤', '田烨伟', '东南艺术大学', '东南艺术大学', '锦州');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('毛哲瀚', '孔耀杰', '西农业大学', '西农业大学', '菏泽');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('林擎苍', '薛晟睿', '西南农业大学', '北大学', '上海');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('宋靖琪', '杨志泽', '中国科技大学', '北理工大学', '成都');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('严金鑫', '邓雨泽', '西北科技大学', '北理工大学', '韶关');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('陶鹏煊', '邓琪', '西南科技大学', '东体育大学', '西安');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('魏晓博', '崔晋鹏', '东北大学', '南艺术大学', '宜昌');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('胡天翊', '杜熠彤', '东北艺术大学', '北农业大学', '大同');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('戴苑博', '曹熠彤', '东南技术大学', '中国技术大学', '铜川');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('阎思远', '白锦程', '中国科技大学', '西北理工大学', '丹东');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('袁鑫鹏', '贺振家', '东北农业大学', '东体育大学', '茂名');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('孟苑博', '顾擎苍', '中国经贸大学', '西体育大学', '延安');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('田志泽', '万潇然', '中国农业大学', '东北艺术大学', '攀枝花');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('王伟宸', '赖峻熙', '东北农业大学', '北大学', '福州');
insert into web_homework.`user_test` (`teacher`, `student`, `description`, `testName`, `detail`)
values ('孔鹏飞', '梁子骞', '南理工大学', '中国艺术大学', '常熟');

-- 用户关联通知
create table if not exists web_homework.`user_notice`
(
    `teacher`     varchar(256)                       not null comment '发布老师',
    `student`     varchar(256)                       not null comment '学生',
    `title`       varchar(256)                       not null comment '通知标题',
    `description` varchar(1024)                      not null comment '通知内容',
    `status`      tinyint  default 0                 not null comment '是否已读',
    `id`          bigint                             not null auto_increment comment '主键' primary key,
    `create_time` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_deleted`  tinyint  default 0                 not null comment '是否删除(0-未删, 1-已删)'
) comment '用户关联通知';

insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('曹瑾瑜', '廖伟宸', '东体育大学', '菏泽');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('张耀杰', '谭涛', '东南大学', '济南');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('于风华', '曹弘文', '南经贸大学', '海门');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('王建辉', '雷擎宇', '西南理工大学', '无锡');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('廖笑愚', '傅皓轩', '东南技术大学', '桂林');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('张雨泽', '萧烨磊', '中国经贸大学', '宿迁');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('姚振家', '许子涵', '南经贸大学', '开封');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('江弘文', '苏楷瑞', '西南技术大学', '云浮');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('田昊强', '洪语堂', '中国经贸大学', '嘉兴');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('毛荣轩', '毛博文', '西北体育大学', '桂林');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('胡鑫鹏', '刘鹤轩', '南经贸大学', '宁波');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('贺明辉', '武锦程', '东北艺术大学', '诸暨');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('毛雨泽', '马懿轩', '东科技大学', '马鞍山');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('秦伟宸', '许远航', '东北农业大学', '锦州');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('朱弘文', '苏子涵', '中国技术大学', '武汉');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('莫志泽', '姚烨华', '东南技术大学', '玉溪');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('薛伟泽', '熊烨磊', '东理工大学', '扬州');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('廖伟诚', '唐文昊', '东南科技大学', '绍兴');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('朱修洁', '丁远航', '南艺术大学', '杭州');
insert into web_homework.`user_notice` (`teacher`, `student`, `title`, `description`)
values ('于嘉懿', '黎雨泽', '中国技术大学', '滨州');


