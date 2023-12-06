## SMBMS 超市订单管理系统

### 文件说明：

sql文件在resource目录下。

**系统功能结构图：**

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/42a227ff6f8c44456edaaed10f5d41f4.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

**数据库结构要素：**

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/df221a70058c6c8695e7e49cda2a7b9d.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

### 1. 项目搭建前期准备

#### 1.1用webapp模板创建一个maven项目

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/0ed70b1761ab777d0d012b45f9e44f9c.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

#### 1.2初始化配置pom.xml与web.xml

```xml
<!--web.xml配置-->
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                         http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0"
         metadata-complete="true">
</web-app>

<!--pom.xml配置-->
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.mario</groupId>
  <artifactId>smbms</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

</project>
```

#### 1.3 在src/main文件夹下创建java与resource目录并做标注

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/cc3ed1fb041a99cea444d5a2dace14a8.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

#### 1.4 配置tomcat

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/703d0abbe1e694377f5c601853f2bd32.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/044a84a7ab82ca8f61d26088f527c46f.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/376708bf3e63fb60e244b724d1f9b9f4.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

#### 1.5 在web.xml中写相应的依赖导入项目中可能会遇到的jar包

```xml
  <dependencies>
<!--servlet与jsp依赖-->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
    </dependency>
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>javax.servlet.jsp-api</artifactId>
      <version>2.3.3</version>
    </dependency>
<!--mysql驱动依赖-->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.22</version>
    </dependency>
<!--jstl依赖与standard标签库-->
    <dependency>
      <groupId>javax.servlet.jsp.jstl</groupId>
      <artifactId>jstl-api</artifactId>
      <version>1.2</version>
    </dependency>
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
    </dependency>
  </dependencies>
```

#### 1.6创建项目包结构

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/265cd8988b7ac49dae25c12d3259975b.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

#### 1.7 连接smbss数据库

创建smbss数据库的sql语句代码

```sql
/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50555
Source Host           : 127.0.0.1:3306
Source Database       : smbms

Target Server Type    : MYSQL
Target Server Version : 50555
File Encoding         : 65001

Date: 2019-04-19 17:54:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for smbms_address
-- ----------------------------
DROP TABLE IF EXISTS `smbms_address`;
CREATE TABLE `smbms_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `contact` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系人姓名',
  `addressDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '收货地址明细',
  `postCode` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮编',
  `tel` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系人电话',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '修改者',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_address
-- ----------------------------
INSERT INTO `smbms_address` VALUES ('1', '王丽', '北京市东城区东交民巷44号', '100010', '13678789999', '1', '2016-04-13 00:00:00', null, null, '1');
INSERT INTO `smbms_address` VALUES ('2', '张红丽', '北京市海淀区丹棱街3号', '100000', '18567672312', '1', '2016-04-13 00:00:00', null, null, '1');
INSERT INTO `smbms_address` VALUES ('3', '任志强', '北京市东城区美术馆后街23号', '100021', '13387906742', '1', '2016-04-13 00:00:00', null, null, '1');
INSERT INTO `smbms_address` VALUES ('4', '曹颖', '北京市朝阳区朝阳门南大街14号', '100053', '13568902323', '1', '2016-04-13 00:00:00', null, null, '2');
INSERT INTO `smbms_address` VALUES ('5', '李慧', '北京市西城区三里河路南三巷3号', '100032', '18032356666', '1', '2016-04-13 00:00:00', null, null, '3');
INSERT INTO `smbms_address` VALUES ('6', '王国强', '北京市顺义区高丽营镇金马工业区18号', '100061', '13787882222', '1', '2016-04-13 00:00:00', null, null, '3');

-- ----------------------------
-- Table structure for smbms_bill
-- ----------------------------
DROP TABLE IF EXISTS `smbms_bill`;
CREATE TABLE `smbms_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `billCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '账单编码',
  `productName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `productDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品描述',
  `productUnit` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品单位',
  `productCount` decimal(20,2) DEFAULT NULL COMMENT '商品数量',
  `totalPrice` decimal(20,2) DEFAULT NULL COMMENT '商品总额',
  `isPayment` int(10) DEFAULT NULL COMMENT '是否支付（1：未支付 2：已支付）',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者（userId）',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `providerId` int(20) DEFAULT NULL COMMENT '供应商ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_bill
-- ----------------------------
INSERT INTO `smbms_bill` VALUES ('1', 'BILL2016_001', '洗发水、护发素', '日用品-洗发、护发', '瓶', '500.00', '25000.00', '2', '1', '2014-12-14 13:02:03', '15', '2019-04-16 21:43:12', '13');
INSERT INTO `smbms_bill` VALUES ('2', 'BILL2016_002', '香皂、肥皂、药皂', '日用品-皂类', '块', '1000.00', '10000.00', '2', '1', '2016-03-23 04:20:40', null, null, '13');
INSERT INTO `smbms_bill` VALUES ('3', 'BILL2016_003', '大豆油', '食品-食用油', '斤', '300.00', '5890.00', '2', '1', '2014-12-14 13:02:03', null, null, '6');
INSERT INTO `smbms_bill` VALUES ('4', 'BILL2016_004', '橄榄油', '食品-进口食用油', '斤', '200.00', '9800.00', '2', '1', '2013-10-10 03:12:13', null, null, '7');
INSERT INTO `smbms_bill` VALUES ('5', 'BILL2016_005', '洗洁精', '日用品-厨房清洁', '瓶', '500.00', '7000.00', '2', '1', '2014-12-14 13:02:03', null, null, '9');
INSERT INTO `smbms_bill` VALUES ('6', 'BILL2016_006', '美国大杏仁', '食品-坚果', '袋', '300.00', '5000.00', '2', '1', '2016-04-14 06:08:09', null, null, '4');
INSERT INTO `smbms_bill` VALUES ('7', 'BILL2016_007', '沐浴液、精油', '日用品-沐浴类', '瓶', '500.00', '23000.00', '1', '1', '2016-07-22 10:10:22', null, null, '14');
INSERT INTO `smbms_bill` VALUES ('8', 'BILL2016_008', '不锈钢盘碗', '日用品-厨房用具', '个', '600.00', '6000.00', '2', '1', '2016-04-14 05:12:13', null, null, '14');
INSERT INTO `smbms_bill` VALUES ('9', 'BILL2016_009', '塑料杯', '日用品-杯子', '个', '350.00', '1750.00', '2', '1', '2016-02-04 11:40:20', null, null, '14');
INSERT INTO `smbms_bill` VALUES ('10', 'BILL2016_010', '豆瓣酱', '食品-调料', '瓶', '200.00', '2000.00', '2', '1', '2013-10-29 05:07:03', null, null, '8');
INSERT INTO `smbms_bill` VALUES ('11', 'BILL2016_011', '海之蓝', '饮料-国酒', '瓶', '50.00', '10000.00', '1', '1', '2016-04-14 16:16:00', null, null, '1');
INSERT INTO `smbms_bill` VALUES ('12', 'BILL2016_012', '芝华士', '饮料-洋酒', '瓶', '20.00', '6000.00', '1', '1', '2016-09-09 17:00:00', null, null, '1');
INSERT INTO `smbms_bill` VALUES ('13', 'BILL2016_013', '长城红葡萄酒', '饮料-红酒', '瓶', '60.00', '800.00', '2', '1', '2016-11-14 15:23:00', null, null, '1');
INSERT INTO `smbms_bill` VALUES ('14', 'BILL2016_014', '泰国香米', '食品-大米', '斤', '400.00', '5000.00', '2', '1', '2016-10-09 15:20:00', null, null, '3');
INSERT INTO `smbms_bill` VALUES ('15', 'BILL2016_015', '东北大米', '食品-大米', '斤', '600.00', '4000.00', '2', '1', '2016-11-14 14:00:00', null, null, '3');
INSERT INTO `smbms_bill` VALUES ('16', 'BILL2016_016', '可口可乐', '饮料', '瓶', '2000.00', '6000.00', '2', '1', '2012-03-27 13:03:01', null, null, '2');
INSERT INTO `smbms_bill` VALUES ('17', 'BILL2016_017', '脉动', '饮料', '瓶', '1500.00', '4500.00', '2', '1', '2016-05-10 12:00:00', null, null, '2');

-- ----------------------------
-- Table structure for smbms_provider
-- ----------------------------
DROP TABLE IF EXISTS `smbms_provider`;
CREATE TABLE `smbms_provider` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `proCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商编码',
  `proName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商名称',
  `proDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商详细描述',
  `proContact` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商联系人',
  `proPhone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `proAddress` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `proFax` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '传真',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者（userId）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_provider
-- ----------------------------
INSERT INTO `smbms_provider` VALUES ('1', 'BJ_GYS001', '北京三木堂商贸有限公司', '长期合作伙伴，主营产品:茅台、五粮液、郎酒、酒鬼酒、泸州老窖、赖茅酒、法国红酒等', '张国强', '13566669999', '北京市丰台区育芳园北路', '010-58858787', '1', '2013-03-21 16:52:07', '2019-04-12 16:44:03', '10');
INSERT INTO `smbms_provider` VALUES ('2', 'HB_GYS001', '石家庄帅益食品贸易有限公司', '长期合作伙伴，主营产品:饮料、水饮料、植物蛋白饮料、休闲食品、果汁饮料、功能饮料等', '王军', '13309094212', '河北省石家庄新华区', '0311-67738876', '1', '2016-04-13 04:20:40', null, null);
INSERT INTO `smbms_provider` VALUES ('3', 'GZ_GYS001', '深圳市泰香米业有限公司', '初次合作伙伴，主营产品：良记金轮米,龙轮香米等', '郑程瀚', '13402013312', '广东省深圳市福田区深南大道6006华丰大厦', '0755-67776212', '1', '2014-03-21 16:56:07', null, null);
INSERT INTO `smbms_provider` VALUES ('4', 'GZ_GYS002', '深圳市喜来客商贸有限公司', '长期合作伙伴，主营产品：坚果炒货.果脯蜜饯.天然花茶.营养豆豆.特色美食.进口食品.海味零食.肉脯肉', '林妮', '18599897645', '广东省深圳市福龙工业区B2栋3楼西', '0755-67772341', '1', '2013-03-22 16:52:07', null, null);
INSERT INTO `smbms_provider` VALUES ('5', 'JS_GYS001', '兴化佳美调味品厂', '长期合作伙伴，主营产品：天然香辛料、鸡精、复合调味料', '徐国洋', '13754444221', '江苏省兴化市林湖工业区', '0523-21299098', '1', '2015-11-22 16:52:07', null, null);
INSERT INTO `smbms_provider` VALUES ('6', 'BJ_GYS002', '北京纳福尔食用油有限公司', '长期合作伙伴，主营产品：山茶油、大豆油、花生油、橄榄油等', '马莺', '13422235678', '北京市朝阳区珠江帝景1号楼', '010-588634233', '1', '2012-03-21 17:52:07', null, null);
INSERT INTO `smbms_provider` VALUES ('7', 'BJ_GYS003', '北京国粮食用油有限公司', '初次合作伙伴，主营产品：花生油、大豆油、小磨油等', '王驰', '13344441135', '北京大兴青云店开发区', '010-588134111', '1', '2016-04-13 00:00:00', null, null);
INSERT INTO `smbms_provider` VALUES ('8', 'ZJ_GYS001', '慈溪市广和绿色食品厂', '长期合作伙伴，主营产品：豆瓣酱、黄豆酱、甜面酱，辣椒，大蒜等农产品', '薛圣丹', '18099953223', '浙江省宁波市慈溪周巷小安村', '0574-34449090', '1', '2013-11-21 06:02:07', null, null);
INSERT INTO `smbms_provider` VALUES ('9', 'GX_GYS001', '优百商贸有限公司', '长期合作伙伴，主营产品：日化产品', '李立国', '13323566543', '广西南宁市秀厢大道42-1号', '0771-98861134', '1', '2013-03-21 19:52:07', null, null);
INSERT INTO `smbms_provider` VALUES ('10', 'JS_GYS002', '南京火头军信息技术有限公司', '长期合作伙伴，主营产品：不锈钢厨具等', '陈女士', '13098992113', '江苏省南京市浦口区浦口大道1号新城总部大厦A座903室', '025-86223345', '1', '2013-03-25 16:52:07', null, null);
INSERT INTO `smbms_provider` VALUES ('11', 'GZ_GYS003', '广州市白云区美星五金制品厂', '长期合作伙伴，主营产品：海绵床垫、坐垫、靠垫、海绵枕头、头枕等', '梁天', '13562276775', '广州市白云区钟落潭镇福龙路20号', '020-85542231', '1', '2016-12-21 06:12:17', null, null);
INSERT INTO `smbms_provider` VALUES ('12', 'BJ_GYS004', '北京隆盛日化科技', '长期合作伙伴，主营产品：日化环保清洗剂，家居洗涤专卖、洗涤用品网、墙体除霉剂、墙面霉菌清除剂等', '孙欣', '13689865678', '北京市大兴区旧宫', '010-35576786', '1', '2014-11-21 12:51:11', null, null);
INSERT INTO `smbms_provider` VALUES ('13', 'SD_GYS001', '山东豪克华光联合发展有限公司', '长期合作伙伴，主营产品：洗衣皂、洗衣粉、洗衣液、洗洁精、消杀类、香皂等', '吴洪转', '13245468787', '山东济阳济北工业区仁和街21号', '0531-53362445', '1', '2015-01-28 10:52:07', null, null);

-- ----------------------------
-- Table structure for smbms_role
-- ----------------------------
DROP TABLE IF EXISTS `smbms_role`;
CREATE TABLE `smbms_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `roleCode` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色编码',
  `roleName` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '修改者',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_role
-- ----------------------------
INSERT INTO `smbms_role` VALUES ('1', 'SMBMS_ADMIN', '系统管理员', '1', '2016-04-13 00:00:00', null, null);
INSERT INTO `smbms_role` VALUES ('2', 'SMBMS_MANAGER', '经理', '1', '2016-04-13 00:00:00', null, null);
INSERT INTO `smbms_role` VALUES ('3', 'SMBMS_EMPLOYEE', '普通员工', '1', '2016-04-13 00:00:00', null, null);

-- ----------------------------
-- Table structure for smbms_user
-- ----------------------------
DROP TABLE IF EXISTS `smbms_user`;
CREATE TABLE `smbms_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userCode` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `userPassword` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `gender` int(10) DEFAULT NULL COMMENT '性别（1:女、 2:男）',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `userRole` int(10) DEFAULT NULL COMMENT '用户角色（取自角色表-角色id）',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者（userId）',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_user
-- ----------------------------
INSERT INTO `smbms_user` VALUES ('1', 'wen', '系统管理员', '123', '1', '1997-01-01', '15200981234', '湖南省衡阳市蒸湘区南华大学', '1', '1', '2019-04-07 10:15:55', null, null);
INSERT INTO `smbms_user` VALUES ('5', 'hanlubiao', '韩路彪', '0000000', '2', '1984-06-05', '18567542321', '北京市朝阳区北辰中心12号', '2', '1', '2014-12-31 19:52:09', null, null);
INSERT INTO `smbms_user` VALUES ('6', 'zhanghua', '张华', '0000000', '1', '1983-06-15', '13544561111', '北京市海淀区学院路61号', '3', '1', '2013-02-11 10:51:17', null, null);
INSERT INTO `smbms_user` VALUES ('7', 'wangyang', '王洋', '0000000', '2', '1982-12-31', '13444561124', '北京市海淀区西二旗辉煌国际16层', '3', '1', '2014-06-11 19:09:07', null, null);
INSERT INTO `smbms_user` VALUES ('8', 'zhaoyan', '赵燕', '0000000', '1', '1986-03-07', '18098764545', '北京市海淀区回龙观小区10号楼', '3', '1', '2016-04-21 13:54:07', null, null);
INSERT INTO `smbms_user` VALUES ('10', 'sunlei', '孙磊', '0000000', '2', '1981-01-04', '13387676765', '北京市朝阳区管庄新月小区12楼', '3', '1', '2015-05-06 10:52:07', null, null);
INSERT INTO `smbms_user` VALUES ('11', 'sunxing', '孙兴', '0000000', '2', '1978-03-12', '13367890900', '北京市朝阳区建国门南大街10号', '3', '1', '2016-11-09 16:51:17', null, null);
INSERT INTO `smbms_user` VALUES ('12', 'zhangchen', '张晨', '0000000', '1', '1986-03-28', '18098765434', '朝阳区管庄路口北柏林爱乐三期13号楼', '3', '1', '2016-08-09 05:52:37', '1', '2016-04-14 14:15:36');
INSERT INTO `smbms_user` VALUES ('13', 'dengchao', '邓超', '0000000', '2', '1981-11-04', '13689674534', '北京市海淀区北航家属院10号楼', '3', '1', '2016-07-11 08:02:47', null, null);
INSERT INTO `smbms_user` VALUES ('14', 'yangguo', '杨过', '0000000', '2', '1980-01-01', '13388886623', '北京市朝阳区北苑家园茉莉园20号楼', '3', '1', '2015-02-01 03:52:07', null, null);
INSERT INTO `smbms_user` VALUES ('15', 'test', 'test', '111', '1', '2019-04-16', '123456789', '南华大学', '1', '1', '2019-04-16 19:52:37', null, null);

```

IDEA连接数据库

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/ddf8d29d25c2a7047ebcd9cd2e748466.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/e97cc8e2ddb334a76511c01c4bd699f7.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)
![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/99d323159ff4f3bb4b2ab17d98199304.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)
![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/d2aed10679426b52624ddf44e65e3bc6.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

#### 1.8编写实体类

pojo下编写对应数据库表的实体类，分类为Bill Role Provider User

**Bill**

```java
import java.math.BigDecimal;
import java.util.Date;
public class Bill {
   private Integer id;   //id 
   private String billCode; //账单编码 
   private String productName; //商品名称 
   private String productDesc; //商品描述 
   private String productUnit; //商品单位
   private BigDecimal productCount; //商品数量 
   private BigDecimal totalPrice; //总金额
   private Integer isPayment; //是否支付 
   private Integer providerId; //供应商ID 
   private Integer createdBy; //创建者
   private Date creationDate; //创建时间
   private Integer modifyBy; //更新者
   private Date modifyDate;//更新时间
   
   private String providerName;//供应商名称
   
   
   public String getProviderName() {
   	return providerName;
   }
   public void setProviderName(String providerName) {
   	this.providerName = providerName;
   }
   public Integer getId() {
   	return id;
   }
   public void setId(Integer id) {
   	this.id = id;
   }
   public String getBillCode() {
   	return billCode;
   }
   public void setBillCode(String billCode) {
   	this.billCode = billCode;
   }
   public String getProductName() {
   	return productName;
   }
   public void setProductName(String productName) {
   	this.productName = productName;
   }
   public String getProductDesc() {
   	return productDesc;
   }
   public void setProductDesc(String productDesc) {
   	this.productDesc = productDesc;
   }
   public String getProductUnit() {
   	return productUnit;
   }
   public void setProductUnit(String productUnit) {
   	this.productUnit = productUnit;
   }
   public BigDecimal getProductCount() {
   	return productCount;
   }
   public void setProductCount(BigDecimal productCount) {
   	this.productCount = productCount;
   }
   public BigDecimal getTotalPrice() {
   	return totalPrice;
   }
   public void setTotalPrice(BigDecimal totalPrice) {
   	this.totalPrice = totalPrice;
   }
   public Integer getIsPayment() {
   	return isPayment;
   }
   public void setIsPayment(Integer isPayment) {
   	this.isPayment = isPayment;
   }
   
   public Integer getProviderId() {
   	return providerId;
   }
   public void setProviderId(Integer providerId) {
   	this.providerId = providerId;
   }
   public Integer getCreatedBy() {
   	return createdBy;
   }
   public void setCreatedBy(Integer createdBy) {
   	this.createdBy = createdBy;
   }
   public Date getCreationDate() {
   	return creationDate;
   }
   public void setCreationDate(Date creationDate) {
   	this.creationDate = creationDate;
   }
   public Integer getModifyBy() {
   	return modifyBy;
   }
   public void setModifyBy(Integer modifyBy) {
   	this.modifyBy = modifyBy;
   }
   public Date getModifyDate() {
   	return modifyDate;
   }
   public void setModifyDate(Date modifyDate) {
   	this.modifyDate = modifyDate;
   }
}
```

**Role**

```java
import java.util.Date;
public class Role {	
   private Integer id;   //id
   private String roleCode; //角色编码
   private String roleName; //角色名称
   private Integer createdBy; //创建者
   private Date creationDate; //创建时间
   private Integer modifyBy; //更新者
   private Date modifyDate;//更新时间
   
   public Integer getId() {
   	return id;
   }
   public void setId(Integer id) {
   	this.id = id;
   }
   public String getRoleCode() {
   	return roleCode;
   }
   public void setRoleCode(String roleCode) {
   	this.roleCode = roleCode;
   }
   public String getRoleName() {
   	return roleName;
   }
   public void setRoleName(String roleName) {
   	this.roleName = roleName;
   }
   public Integer getCreatedBy() {
   	return createdBy;
   }
   public void setCreatedBy(Integer createdBy) {
   	this.createdBy = createdBy;
   }
   public Date getCreationDate() {
   	return creationDate;
   }
   public void setCreationDate(Date creationDate) {
   	this.creationDate = creationDate;
   }
   public Integer getModifyBy() {
   	return modifyBy;
   }
   public void setModifyBy(Integer modifyBy) {
   	this.modifyBy = modifyBy;
   }
   public Date getModifyDate() {
   	return modifyDate;
   }
   public void setModifyDate(Date modifyDate) {
   	this.modifyDate = modifyDate;
   }
}
```

**Provider**

```java
import java.util.Date;
public class Provider {
   private Integer id;   //id
   private String proCode; //供应商编码
   private String proName; //供应商名称
   private String proDesc; //供应商描述
   private String proContact; //供应商联系人
   private String proPhone; //供应商电话
   private String proAddress; //供应商地址
   private String proFax; //供应商传真
   private Integer createdBy; //创建者
   private Date creationDate; //创建时间
   private Integer modifyBy; //更新者
   private Date modifyDate;//更新时间

   public Integer getId() {
   	return id;
   }
   public void setId(Integer id) {
   	this.id = id;
   }
   public String getProCode() {
   	return proCode;
   }
   public void setProCode(String proCode) {
   	this.proCode = proCode;
   }
   public String getProName() {
   	return proName;
   }
   public void setProName(String proName) {
   	this.proName = proName;
   }
   public String getProDesc() {
   	return proDesc;
   }
   public void setProDesc(String proDesc) {
   	this.proDesc = proDesc;
   }
   public String getProContact() {
   	return proContact;
   }
   public void setProContact(String proContact) {
   	this.proContact = proContact;
   }
   public String getProPhone() {
   	return proPhone;
   }
   public void setProPhone(String proPhone) {
   	this.proPhone = proPhone;
   }
   public String getProAddress() {
   	return proAddress;
   }
   public void setProAddress(String proAddress) {
   	this.proAddress = proAddress;
   }
   public String getProFax() {
   	return proFax;
   }
   public void setProFax(String proFax) {
   	this.proFax = proFax;
   }
   public Integer getCreatedBy() {
   	return createdBy;
   }
   public void setCreatedBy(Integer createdBy) {
   	this.createdBy = createdBy;
   }
   public Date getCreationDate() {
   	return creationDate;
   }
   public void setCreationDate(Date creationDate) {
   	this.creationDate = creationDate;
   }
   public Integer getModifyBy() {
   	return modifyBy;
   }
   public void setModifyBy(Integer modifyBy) {
   	this.modifyBy = modifyBy;
   }
   public Date getModifyDate() {
   	return modifyDate;
   }
   public void setModifyDate(Date modifyDate) {
   	this.modifyDate = modifyDate;
   }
}
```

**User**

```java
import java.util.Date;
public class User {
   private Integer id; //id 
   private String userCode; //用户编码
   private String userName; //用户名称
   private String userPassword; //用户密码
   private Integer gender;  //性别
   private Date birthday;  //出生日期
   private String phone;   //电话
   private String address; //地址
   private Integer userRole;    //用户角色
   private Integer createdBy;   //创建者
   private Date creationDate; //创建时间
   private Integer modifyBy;     //更新者
   private Date modifyDate;   //更新时间
   
   private Integer age;//年龄
   private String userRoleName;    //用户角色名称


   public String getUserRoleName() {
   	return userRoleName;
   }
   public void setUserRoleName(String userRoleName) {
   	this.userRoleName = userRoleName;
   }
   public Integer getAge() {
   	Date date = new Date();
   	Integer age = date.getYear()-birthday.getYear();
   	return age;
   }
   public Integer getId() {
   	return id;
   }
   public void setId(Integer id) {
   	this.id = id;
   }
   public String getUserCode() {
   	return userCode;
   }
   public void setUserCode(String userCode) {
   	this.userCode = userCode;
   }
   public String getUserName() {
   	return userName;
   }
   public void setUserName(String userName) {
   	this.userName = userName;
   }
   public String getUserPassword() {
   	return userPassword;
   }
   public void setUserPassword(String userPassword) {
   	this.userPassword = userPassword;
   }
   public Integer getGender() {
   	return gender;
   }
   public void setGender(Integer gender) {
   	this.gender = gender;
   }
   public Date getBirthday() {
   	return birthday;
   }
   public void setBirthday(Date birthday) {
   	this.birthday = birthday;
   }
   public String getPhone() {
   	return phone;
   }
   public void setPhone(String phone) {
   	this.phone = phone;
   }
   public String getAddress() {
   	return address;
   }
   public void setAddress(String address) {
   	this.address = address;
   }
   public Integer getUserRole() {
   	return userRole;
   }
   public void setUserRole(Integer userRole) {
   	this.userRole = userRole;
   }
   public Integer getCreatedBy() {
   	return createdBy;
   }
   public void setCreatedBy(Integer createdBy) {
   	this.createdBy = createdBy;
   }
   public Date getCreationDate() {
   	return creationDate;
   }
   public void setCreationDate(Date creationDate) {
   	this.creationDate = creationDate;
   }
   public Integer getModifyBy() {
   	return modifyBy;
   }
   public void setModifyBy(Integer modifyBy) {
   	this.modifyBy = modifyBy;
   }
   public Date getModifyDate() {
   	return modifyDate;
   }
   public void setModifyDate(Date modifyDate) {
   	this.modifyDate = modifyDate;
   }

}
```

#### 1.9 编写基础公共类

##### 1.9.1 数据库配置文件

resources下新建db.properties文件

```properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306?useUnicode=true&characterEncoding=utf-8
username=root
password=123456
```

##### 1.9.2 编写数据库的公共类

在dao下新建BaseDao类用于读取上面的数据库配置文件

```java
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
//操作数据库的公共类
     public class BaseDao {     
         private static String driver;
         private static String url;
         private static String username;
         private static String password;
     
         //静态代码块，类加载的时候就初始化了
         static {
             Properties properties = new Properties();
             //通过类加载器读取对应的资源
             InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
     
             try {
                 properties.load(is);
             } catch (IOException e) {
                 e.printStackTrace();
             }
     
             driver = properties.getProperty("driver");
             url = properties.getProperty("url");
             username = properties.getProperty("username");
             password = properties.getProperty("password");
         }
     
         //获取数据库的链接
         public static Connection getConnection(){
             Connection connection = null;
             try {
                 Class.forName(driver);
                 connection = DriverManager.getConnection(url, username, password);
             } catch (Exception e) {
                 e.printStackTrace();
             }
             return connection;
         }
     
         //编写查询公共方法
         public static ResultSet execute(Connection connection,String sql,Object[] params,ResultSet resultSet,PreparedStatement preparedStatement) throws SQLException {
             //预编译的sql，在后面直接执行就可以了
             preparedStatement = connection.prepareStatement(sql);
     
             for (int i = 0; i < params.length; i++) {
                 //setObject,占位符从1开始，但是我们的数组是从0开始！
                 preparedStatement.setObject(i+1,params[i]);
             }
     
             resultSet = preparedStatement.executeQuery();
             return resultSet;
         }
     
     
         //编写增删改公共方法
         public static int execute(Connection connection,String sql,Object[] params,PreparedStatement preparedStatement) throws SQLException {
             preparedStatement = connection.prepareStatement(sql);
     
             for (int i = 0; i < params.length; i++) {
                 //setObject,占位符从1开始，但是我们的数组是从0开始！
                 preparedStatement.setObject(i+1,params[i]);
             }
     
             int updateRows = preparedStatement.executeUpdate();
             return updateRows;
         }
     
     
         //释放资源
         public static boolean closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
             boolean flag = true;
     
             if (resultSet!=null){
                 try {
                     resultSet.close();
                     //GC回收
                     resultSet = null;
                 } catch (SQLException e) {
                     e.printStackTrace();
                     flag = false;
                 }
             }
     
             if (preparedStatement!=null){
                 try {
                     preparedStatement.close();
                     //GC回收
                     preparedStatement = null;
                 } catch (SQLException e) {
                     e.printStackTrace();
                     flag = false;
                 }
             }
     
             if (connection!=null){
                 try {
                     connection.close();
                     //GC回收
                     connection = null;
                 } catch (SQLException e) {
                     e.printStackTrace();
                     flag = false;
                 }
             }
             return flag;
         }
     }
```

##### 1.9.3 编写字符编码过滤器

```java
import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request,response);
    }
    public void destroy() {

    }
}
```

然后在web.xml中注册

```xml
<!--字符编码过滤器-->
<filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>com.kuang.filter.CharacterEncodingFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

#### 1.10 导入静态资源

放在webapp目录下

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/0691585c7aff0cc5e78aafcefc32e5c5.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

[github地址](https://github.com/five517/SMBMS)
[gitee地址](https://gitee.com/mario517/SMBMS/tree/main/)

### 2.登录功能的实现

流程结构
![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/077f0790cefe6ea1689fb605bd4d6309.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

#### 2.1 编写前端页面

##### 2.1.1 登录界面login.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
    <script type="text/javascript">
    </script>
</head>
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>超市订单管理系统</h1>
        </header>
        <section class="loginCont">
	        <form class="loginForm" action="${pageContext.request.contextPath }/login.do"  name="actionForm" id="actionForm"  method="post" >
				<div class="info">${error}</div>
				<div class="inputbox">
                    <label>用户名：</label>
					<input type="text" class="input-text" id="userCode" name="userCode" placeholder="请输入用户名" required/>
				</div>	
				<div class="inputbox">
                    <label>密码：</label>
                    <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
                </div>	
				<div class="subBtn">
					
                    <input type="submit" value="登录"/>
                    <input type="reset" value="重置"/>
                </div>	
			</form>
        </section>
    </section>
</body>
</html>
```

##### 2.1.2 将登录页面设置为首页

在web.xml中加入这段话

```xml
<!--    设置欢迎页面-->
    <welcome-file-list>
        <welcome-file>login.jsp</welcome-file>
    </welcome-file-list>
```

##### 2.1.3 编写dao层用户登录的接口UserDao

在dao中建立一个user包，在包中建一个UserDao接口，在接口中写

```java
import com.mario.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    public User getLoginUser(Connection connection, String userCode, String userPassword) throws SQLException;

}
```

##### 2.1.4 编写UserDao接口的实现类UserDaoImpl

```java
import com.mario.dao.BaseDao;
import com.mario.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode,String userPassword) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection!=null){
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};
            //System.out.println(userPassword);
            rs = BaseDao.execute(connection,sql,params,rs,pstm);
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null,pstm,rs);
            if (!user.getUserPassword().equals(userPassword))
                user=null;
        }
        return user;
    }
}
```

##### 2.1.5 编写业务层接口

在service下建立user包，建立UserService接口

```java
import com.mario.pojo.User;

public interface UserService {
    //用户登录
    public User login(String userCode, String password);
}
```

##### 2.1.6 编写业务层接口的实现类

在service的user包中建立UserServiceImpl类

```java
import com.mario.dao.BaseDao;
import com.mario.dao.user.UserDao;
import com.mario.dao.user.UserDaoImpl;
import com.mario.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    //业务层都会调用dao层，所以我们要引入Dao层；
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }


    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体的数据库操作
            user = userDao.getLoginUser(connection, userCode,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }
//    @Test
//    public void test(){
//        UserServiceImpl userService = new UserServiceImpl();
//        User login = userService.login("test", "111");
//        System.out.println(login.getUserPassword());
//    }

}
```

##### 2.1.7 编写Servlet类

在Servlet包中创建user包，在user包中建立LoginServlet类

```java
import com.mario.pojo.User;
import com.mario.service.user.UserService;
import com.mario.service.user.UserServiceImpl;
import com.mario.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //Servlet:控制层，调用业务层代码

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("LoginServlet--start....");
        //获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        //和数据库中的密码进行对比，调用业务层；
        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);  //这里已经把登录的人给查出来了
        System.out.println(userCode);
        System.out.println(userPassword);
        if (user!=null){ //查有此人，可以登录
            //将用户的信息放到Session中;
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到主页重定向
            resp.sendRedirect("jsp/frame.jsp");
        }else {//查无此人，无法登录
            //转发回登录页面，顺带提示它，用户名或者密码错误；
            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

在web.xml中注册当前的Servlet

```xml
<!--    注册登录页面的Servlet-->
    <servlet>
        <servlet-name>login</servlet-name>
        <servlet-class>com.mario.servlet.user.LoginServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>login</servlet-name>
        <url-pattern>/login.do</url-pattern>
    </servlet-mapping>
```

### 3.登录功能的优化

#### 3.1 注销功能

移除session，返回登录页面,servlet.user下创建LogoutServlet类

```java
import com.mario.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //移除用户的session
        req.getSession().removeAttribute(Constants.USER_SESSION);
        resp.sendRedirect(req.getContextPath()+"/login.jsp");//返回登录页面
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
123456789101112131415161718192021
```

同理，在web.xml中注册注销servlet

```xml
<!--    注册注销页面-->
    <servlet>
        <servlet-name>LogoutServlet</servlet-name>
        <servlet-class>com.mario.servlet.user.LogoutServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>LogoutServlet</servlet-name>
        <url-pattern>/jsp/logout.do</url-pattern>
    </servlet-mapping>
```

#### 3.2 登录拦截器

在filter下创建SysFilter类

```java
import com.mario.pojo.User;
import com.mario.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //过滤器，从Session中获取用户，
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);

        if (user==null){ //已经被移除或者注销了，或者未登录
            response.sendRedirect("/smbms/error.jsp");
        }else {
            chain.doFilter(req,resp);
        }
    }

    public void destroy() {

    }
}
```

在web.xml中注册

```xml
    <filter>
        <filter-name>Sysfilter</filter-name>
        <filter-class>com.mario.filter.SysFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>Sysfilter</filter-name>
        <url-pattern>/jsp/*</url-pattern>
    </filter-mapping>
```

#### 3.3 密码修改

**自顶向下设计，自底向上实现**

先写基本逻辑，前端在测试后端的路上完善的

- 为了实这个功能需要自底向上逐一实现功能，修改密码需要更新数据库的相关行，所以这就需要dao层去进行增删改查操作数据

- dao层的需要的当前的一些信息，比如用户名，当前的密码，要修改的密码，所以这些就要dao层去从Service层获取这些参数

- service需要获取从Servlet层传过来的数据进行相应的处理，验证，核算，然后将最终的信息传递给dao层

- 而servlet直接与前端接触，返回当前页面上传递而来的用户输入触发的参数，转发到不同的页面，交给不同的service来处理这些请求

  意味着先从dao层开始写，分模块，先写接口，再写接口的实现类，依次写service和servlet，最后注册这个servlet，最后测试并完善前端页面

##### 3.3.1 编写dao层用户修改密码的接口UserDao

在dao.user.UserDao的接口下增加updatepwd

```java
//修改当前用户密码
//增删改都会影响数据库的变化，所以是返回int类型，说明有几行受到了影响
public int updatePwd(Connection connection,int id,String userPassword)throws SQLException;
```

##### 3.3.2 编写dao层用户修改密码的接口实现类

UserDaoImpl下增加

```java
//修改当前用户密码
//增删改都会影响数据库的变化，所以是返回int类型，说明有几行受到了影响
public int updatePwd(Connection connection, int id, String userPassword) throws SQLException {
    int updateRows=0;
    PreparedStatement pstm = null;
    if(connection!=null){
        String Sql="UPDATE `smbms_user` SET `userPassword`=? WHERE `id`=? ";
        Object []params={userPassword,id};
        updateRows=BaseDao.execute(connection,Sql,params,pstm);
    }
    BaseDao.closeResource(null,pstm,null);
    return updateRows;
}
```

##### 3.3.3 编写业务层Service的用户修改密码的接口

UserService下增加

```java
//根据用户id修改密码
public boolean updatePwd(int id,String password);
```

##### 3.3.4 编写业务层Service的用户修改密码的接口实现类

UserServiceImpl下增加

```java
//根据用户id修改密码
//通过返回的参数flag判断是否修改成功
public boolean updatePwd(int id, String password) {
    boolean flag = false;
    Connection connection = null;
    try{
        connection = BaseDao.getConnection();
        if(userDao.updatePwd(connection,id,password) > 0)
            flag = true;
    }catch (Exception e) {
        e.printStackTrace();
    }finally{
        BaseDao.closeResource(connection, null, null);
    }
    return flag;
}
```

##### 3.3.5 编写修改密码的Servlet类

servlet.user 下新增UserServlet类

```java
//实现Servlet复用，实现复用需要提取出方法，然后在doGet函数中调用即可
        String method = req.getParameter("method");
        if(method.equals("savepwd") && method!=null){
            this.updatePwd(req,resp);
        }


//在doGet外写复用方法
 public void updatePwd(HttpServletRequest req, HttpServletResponse resp){
        //从session中获得用户id,这里的attribute包括了用户的所用信息
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        //获得新密码
        String newpassword = req.getParameter("newpassword");
        boolean flag= false;
        //判断是否有这个用户是否存在，以及新密码不为空
        if(attribute!=null && !StringUtils.isNullOrEmpty(newpassword)){
            UserService userService = new UserServiceImpl();
            flag = userService.updatePwd(((User) attribute).getId(), newpassword);
            if (flag) {
                req.setAttribute(Constants.SYS_MESSAGE,"修改密码成功，请退出后重新登录");
                //密码修改成功后移除当前session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }else{
                req.setAttribute(Constants.SYS_MESSAGE,"密码修改失败请重新输入");
            }
        }else{
            req.setAttribute(Constants.SYS_MESSAGE,"新密码设置错误请重新输入");
        }
        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

##### 3.3.6 在web.xml中注册这个servlet

```xml
<!--    注册UserServlet页面-->
<servlet>
    <servlet-name>UserServlet</servlet-name>
    <servlet-class>com.mario.servlet.user.UserServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>UserServlet</servlet-name>
    <url-pattern>/jsp/user.do</url-pattern>
</servlet-mapping>
```

#### 3.4 使用Ajax优化密码修改

阿里巴巴的fastjson.jar包

```xml
<!-- https://mvnrepository.com/artifact/com.alibaba/fastjson -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.62</version>
</dependency>
```

编写验证旧密码的servlet类，还是servlet方法复用

```java
else if(method.equals("pwdmodify") && method!=null){//收到前端发来的请求，根据不同的method值来启动不同的Servlet应对
            this.modifyPwd(req,resp);
        }

//在下面继续写
//验证旧密码，session中可以获得旧密码，不需要重复去数据库中寻找
    public void modifyPwd(HttpServletRequest req, HttpServletResponse resp){
        //从session中获得用户的旧密码,这里的attribute包括了用户的所用信息
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        //从前端输入的页面中获得输入的旧密码
        String oldpassword = req.getParameter("oldpassword");
        //万能的Map
        Map<String, String> resultMap = new HashMap<String,String>();
        if (attribute==null){//取到的session为空，意味着session过期了
            resultMap.put("result","sessionerror");
        }else if (StringUtils.isNullOrEmpty(oldpassword)){//如果输入的旧密码为空
            resultMap.put("result","sessionerror");
        }else{//session不为空，输入的旧密码也不为空，则取出当前旧密码与之比较
            String userPassword = ((User) attribute).getUserPassword();
            if(oldpassword.equals(userPassword)){
                resultMap.put("result","true");
            }else {
                resultMap.put("result","false");
            }
        }
        try {
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.write(JSONArray.toJSONString(resultMap));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

### 4.用户管理模块实现

结构流程图

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/cece5afd8c9df1214d995095ba80dd82.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

静态资源需要导入分页的工具类

页面还需要导入用户列表

按照自底向上的流程，编写顺序

- **Dao**
- **DaoImpl**
- **Service**
- **ServiceImpl**
- **Servlet**

#### 4.1 获取用户的数量

首先是**UserDao**接口添加一个函数

```java
public int getUserCount(Connection connection, String userName, int userRole)throws Exception;
```

然后**UserDaoImpl**里实现上面接口里新增的函数

```java
//根据用户输入的名字或者角色id来查询计算用户数量
    public int getUserCount(Connection connection, String userName, int userRole) throws Exception {
        int count=0;
        PreparedStatement pstm = null;
        ResultSet rs=null;
        if (connection!=null) {
            StringBuffer sql=new StringBuffer();
            sql.append("SELECT COUNT(*) AS count FROM `smbms_user` u,`smbms_role` r WHERE u.`userRole`=r.`id`");
            ArrayList<Object> list = new ArrayList<Object>();//存放可能会放进sql里的参数，就是用来替代?的params
            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.username like ?");
                list.add("%"+userName+"%");//模糊查询，index:0
            }
            if(userRole>0){
                sql.append(" and u.userRole = ?");
                list.add(userRole);//index:1
            }
            Object[] params = list.toArray();//转换成数组
            System.out.println("当前的sql语句为------------>"+sql);
            rs = BaseDao.execute(connection, sql.toString(), params, rs, pstm);
            if(rs.next()){
                count=rs.getInt("count");

            }
            BaseDao.closeResource(null,pstm,rs);

        }
        return count;
    }
```

继续在**UserService**接口里面增加一个新的函数

```java
//根据条件（用户的查询输入）查询用户记录数
public int getUserCount(String queryUserName, int queryUserRole);
```

接口里新增后，在**UserServiceImpl**实现这个方法

```java
//根据条件（用户的查询输入）查询用户记录数
public int getUserCount(String queryUserName, int queryUserRole) {
    int count=0;
    Connection connection=null;
    try {
        connection = BaseDao.getConnection();
        count = userDao.getUserCount(connection, queryUserName, queryUserRole);
    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        BaseDao.closeResource(connection, null, null);
    }
    return count;
}
```

#### 4.2 根据输入的条件获取当前的用户列表

首先是**UserDao**接口添加一个函数

```java
//通过用户输入的条件查询用户列表
public List<User> getUserList(Connection connection,String userName,int userRole,int currentPageNo,int pageSize) throws  Exception;
```

然后**UserDaoImpl**里实现上面接口里新增的函数

```java
//通过用户输入的条件查询用户列表
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception {
        List<User> userList = new ArrayList<User>();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        if(connection!=null){
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
            List<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }
            if(userRole > 0){
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
          	//实现分页显示
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            Object[] params = list.toArray();
            System.out.println("sql ----> " + sql.toString());
            rs = BaseDao.execute(connection,sql.toString(),params,rs,pstm);
            while(rs.next()){
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(_user);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return userList;
    }
```

继续在**UserService**接口里面增加一个新的函数

```java
//根据条件查询用户列表
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
```

接口里新增后，在**UserServiceImpl**实现这个方法

```java
 public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<User> userList = null;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection, queryUserName,queryUserRole,currentPageNo,pageSize);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return userList;
    }
```

#### 4.3 根据用户输入的条件获取当前的用户角色栏

首先在dao层新建role目录，下面新建RoleDao接口

然后**UserDaoImpl**里实现上面接口里新增的函数

```java
import com.mario.pojo.Role;

import java.sql.Connection;
import java.util.List;

public interface RoleDao {
    //获取角色表
    public List<Role> getRoleList(Connection connection) throws Exception;
}
```

然后在dao层role目录下新建RoleDaoImpl实现接口

```java
import com.mario.dao.BaseDao;
import com.mario.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    public List<Role> getRoleList(Connection connection) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Role> roleList = new ArrayList<Role>();
        if(connection!=null){
            String sql="SELECT * FROM `smbms_role`";
            Object[] params={};
            rs = BaseDao.execute(connection, sql, params, rs, pstm);
            while(rs.next()){
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setRoleCode(rs.getString("roleCode"));
                role.setRoleName(rs.getString("roleName"));
                roleList.add(role);
            }
        }
        BaseDao.closeResource(null,pstm,rs);
        return roleList;
    }
}
```

在service层新建role目录，新建RoleService接口

```java
import com.mario.pojo.Role;

import java.util.List;

public interface RoleService {

    //得到用户角色表
    public List<Role> getRoleList();
}
```

在service层role目录下，新建RoleServiceImlp接口实现

```java
import com.mario.dao.BaseDao;
import com.mario.dao.role.RoleDao;
import com.mario.dao.role.RoleDaoImpl;
import com.mario.pojo.Role;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl  implements RoleService{
    //业务层都会调用dao层，所以我们要引入Dao层；
    private RoleDao roleDao;
    public RoleServiceImpl(){ roleDao=new RoleDaoImpl();}
    //方法
    //Service层一般步骤都是获取连接执行操作，返回结果就行
    public List<Role> getRoleList() {
        Connection connection=null;
        List<Role> roleList=null;
        try {
            connection= BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }
}
```

#### 4.4 用户管理query模块的Servlet编写

```java
else if (method.equals("query") && method!=null){
            this.query(req,resp);
        }



    //用户管理模块页面查询
    //怎么处理
    public  void query(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        //接收前端传来的参数
        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");//从前端传回来的用户角色码不知是否为空或者是有效角色码，所以暂存起来
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole=0;
        //先设置一个默认的用户角色码，若temp为空，则将这个传进sql语句中，这是真正放进sql语句中的角色码
        /*
            if(userRole > 0){
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
            这句便不会被执行
         */
        //通过UserServiceImpl得到用户列表,用户数
        UserServiceImpl userService = new UserServiceImpl();
        //通过RoleServiceImpl得到角色表
        RoleService roleService = new RoleServiceImpl();
        List<User> userList=null;//用来存储用户列表
        List<Role> roleList=null;//用来存储角色表
        //设置每页显示的页面容量
        int pageSize=Constants.pageSize;
        //设置当前的默认页码
        int currentPageNo=1;
        //输出控制台，显示参数的当前值
        System.out.println("queryUserName servlet--------"+queryUserName);
        System.out.println("queryUserRole servlet--------"+queryUserRole);
        System.out.println("query pageIndex--------- > " + pageIndex);

        //前端传来的参数若不符合查询sql语句，即如果用户不进行设置，值为空会影响sql查询，需要给它们进行一些约束
        if(queryUserName==null){//这里为空，说明用户没有输入要查询的用户名，则sql语句传值为""，%%，会查询所有记录
            queryUserName="";
        }
        if(temp!=null && !temp.equals("")){
            //不为空，说明前端有传来的用户所设置的userCode，更新真正的角色码
            queryUserRole=Integer.parseInt(temp);//强制转换，前端传递的参数都是默认字符串，要转成int类型
        }

        if(pageIndex!=null){//说明当前用户有进行设置跳转页面
            currentPageNo=Integer.valueOf(pageIndex);
        }

        //有了用户名和用户角色后可以开始查询了，所以需要显示当前查询到的总记录条数
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);
        //根据总记录条数以及当前每页的页面容量可以算出，一共有几页，以及最后一页的显示条数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        //可显示的总页数
        int totalPageCount=pageSupport.getTotalPageCount();

        //约束首位页，即防止用户输入的页面索引小于1或者大于总页数
        if(currentPageNo<1){
            currentPageNo=1;
        }else if(currentPageNo>totalPageCount){
            currentPageNo=totalPageCount;
        }
        //有了，待查询条件，当前页码，以及每页的页面容量后，就可以给出每页的具体显示情况了
        userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
        roleList = roleService.getRoleList();
        //得到了用户表与角色表以及各种经过处理后的参数，都存进req中
        req.setAttribute("userList",userList);
        req.setAttribute("roleList",roleList);
        req.setAttribute("queryUserName", queryUserName);
        req.setAttribute("queryUserRole", queryUserRole);
        req.setAttribute("totalPageCount", totalPageCount);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        //将所得到的的所有req参数送回给前端
        req.getRequestDispatcher("userlist.jsp").forward(req,resp);

    }
```

#### 4.5 用户管理模块的增删改查

**Dao**

```java
    //增加用户信息
    public  int add(Connection connection,User user) throws Exception;

    //通过用户id删除用户信息
    public int deleteUserById(Connection connection, Integer delId)throws Exception;

    //通过userId查看当前用户信息
    public User getUserById(Connection connection, String id)throws Exception;
    //修改用户信息
    public int modify(Connection connection, User user)throws Exception;
```

**DaoImpl**

```java
    //增加用户信息
    public int add(Connection connection, User user) throws Exception {
        PreparedStatement pstm=null;
        int updateNum=0;
        if(connection!=null) {
            String sql = "insert into smbms_user (userCode,userName,userPassword," +
                    "userRole,gender,birthday,phone,address,creationDate,createdBy) " +
                    "values(?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {user.getUserCode(), user.getUserName(), user.getUserPassword(),
                    user.getUserRole(), user.getGender(), user.getBirthday(),
                    user.getPhone(), user.getAddress(), user.getCreationDate(), user.getCreatedBy()};
            updateNum = BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateNum;
    }

    //根据用户id删除该用户
    public int deleteUserById(Connection connection, Integer delId) throws Exception {
        PreparedStatement pstm=null;
        int deleteNum=0;
        if(connection!=null){
            String sql="DELETE FROM `smbms_user` WHERE id=?";
            Object[] params={delId};
            deleteNum=BaseDao.execute(connection,sql,params,pstm);
            BaseDao.closeResource(null,pstm,null);
        }
        return deleteNum;
    }

    //通过userId查看当前用户信息
    public User getUserById(Connection connection, String id) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        User user = new User();
        if(connection!=null){
            String sql="select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.id=? and u.userRole = r.id";
            Object[] params={id};
            rs = BaseDao.execute(connection, sql, params, rs, pstm);
            while(rs.next()){
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
                user.setUserRoleName(rs.getString("userRoleName"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return user;
    }

    //修改用户的信息
    public int modify(Connection connection, User user) throws Exception {
        int updateNum = 0;
        PreparedStatement pstm = null;
        if(null != connection){
            String sql = "update smbms_user set userName=?,"+
                    "gender=?,birthday=?,phone=?,address=?,userRole=?,modifyBy=?,modifyDate=? where id = ? ";
            Object[] params = {user.getUserName(),user.getGender(),user.getBirthday(),
                    user.getPhone(),user.getAddress(),user.getUserRole(),user.getModifyBy(),
                    user.getModifyDate(),user.getId()};
            updateNum = BaseDao.execute(connection, sql,params,pstm);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateNum;
    }
```

**Service**

```java
//增加用户
public Boolean add(User user);

//修改用户信息
public Boolean modify(User user) throws Exception;

//根据用户编码，判断用户是否存在
public User selectUserCodeExist(String userCode);

//根据用户id删除用户
public boolean deleteUserById(Integer delId);

//根据用户id得到当前用户
public User getUserById(String id);
```

**ServiceImpl**

```java
    public Boolean add(User user) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();//获得连接
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = userDao.add(connection,user);
            connection.commit();
            if(updateRows > 0){
                flag = true;
                System.out.println("add success!");
            }else{
                System.out.println("add failed!");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();//失败就回滚
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    public Boolean modify(User user) {
        Boolean flag=false;
        Connection connection=null;
        try {
            connection=BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务
            int updateNum = userDao.modify(connection, user);//执行修改sql
            connection.commit();//提交事务
            if(updateNum>0){
                flag=true;
                System.out.println("修改用户成功");
            }else{
                System.out.println("修改用户失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //若抛出异常，则说明修改失败需要回滚
            System.out.println("修改失败，回滚事务");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    public User selectUserCodeExist(String userCode) {

        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }

    public boolean deleteUserById(Integer delId) {
        Boolean flag=false;
        Connection connection=null;
        connection=BaseDao.getConnection();
        try {
            int deleteNum=userDao.deleteUserById(connection,delId);
            if(deleteNum>0)flag=true;
        } catch (Exception e) {
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    public User getUserById(String id) {
        User user = new User();
        Connection connection=null;
        try {
            connection=BaseDao.getConnection();
            user = userDao.getUserById(connection,id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return  user;
    }
```

**增删改查Servlet**

```java
//整体的Servlet
    public void init() throws ServletException {
        // Put your code here
    }
    public UserServlet() {
        super();
    }
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        System.out.println("method----> " + method);
        if(method != null && method.equals("add")){
            //增加操作
            this.add(request, response);
        }else if(method != null && method.equals("query")){
            //查询用户操作
            this.query(request, response);
        }else if(method != null && method.equals("getrolelist")){
            //查询用户角色表
            this.getRoleList(request, response);
        }else if(method != null && method.equals("ucexist")){
            //查询当前用户编码是否存在
            this.userCodeExist(request, response);
        }else if(method != null && method.equals("deluser")){
            //删除用户
            this.delUser(request, response);
        }else if(method != null && method.equals("view")){
            //通过用户id得到用户
            this.getUserById(request, response,"userview.jsp");
        }else if(method != null && method.equals("modify")){
            //通过用户id得到用户
            this.getUserById(request, response,"usermodify.jsp");
        }else if(method != null && method.equals("modifyexe")){
            //验证用户
            this.modify(request, response);
        }else if(method != null && method.equals("pwdmodify")){
            //验证用户密码
            this.modifyPwd(request, response);
        }else if(method != null && method.equals("savepwd")){
            //更新用户密码
            this.updatePwd(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }





		//增加用户
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("当前正在执行增加用户操作");
        //从前端得到页面的请求的参数即用户输入的值
        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        //String ruserPassword = req.getParameter("ruserPassword");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");
        //把这些值塞进一个用户属性中
        User user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setAddress(address);
        user.setGender(Integer.valueOf(gender));
        user.setPhone(phone);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setUserRole(Integer.valueOf(userRole));
        user.setCreationDate(new Date());
        //查找当前正在登陆的用户的id
        user.setCreatedBy(((User)req.getSession().getAttribute(Constants.USER_SESSION)).getId());
        UserServiceImpl userService = new UserServiceImpl();
        Boolean flag = userService.add(user);
        //如果添加成功，则页面转发，否则重新刷新，再次跳转到当前页面
        if(flag){
            resp.sendRedirect(req.getContextPath()+"/jsp/user.do?method=query");
        }else{
            req.getRequestDispatcher("useradd.jsp").forward(req,resp);
        }
    }

    //得到用户角色表
    private void getRoleList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Role> roleList = null;
        RoleService roleService = new RoleServiceImpl();
        roleList = roleService.getRoleList();
        //把roleList转换成json对象输出
        resp.setContentType("application/json");
        PrintWriter outPrintWriter = resp.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(roleList));
        outPrintWriter.flush();
        outPrintWriter.close();
    }

    //判断当前输入用户编码是否可用，即是否与已经存在的编码发生冲突
    private void userCodeExist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //先拿到用户的编码
        String userCode = req.getParameter("userCode");
        //用一个hashmap，暂存现在所有现存的用户编码
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(StringUtils.isNullOrEmpty(userCode)){
            //userCode == null || userCode.equals("")
            //如果输入的这个编码为空或者不存在，说明可用
            resultMap.put("userCode", "exist");
        }else{//如果输入的编码不为空，则需要去找一下是否存在这个用户
            UserService userService = new UserServiceImpl();
            User user = userService.selectUserCodeExist(userCode);
            if(null != user){
                resultMap.put("userCode","exist");
            }else{
                resultMap.put("userCode", "notexist");
            }
        }
        //把resultMap转为json字符串以json的形式输出
        //配置上下文的输出类型
        resp.setContentType("application/json");
        //从response对象中获取往外输出的writer对象
        PrintWriter outPrintWriter = resp.getWriter();
        //把resultMap转为json字符串 输出
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();//刷新
        outPrintWriter.close();//关闭流
    }

    //删除用户，需要当前的Id，来找到这个用户然后删除
    private void delUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String id = req.getParameter("uid");
        Integer delId = 0;
        try{
            delId = Integer.parseInt(id);
        }catch (Exception e) {
            // TODO: handle exception
            delId = 0;
        }
        //需要判断是否能删除成功
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(delId <= 0){
            resultMap.put("delResult", "notexist");
        }else{
            UserService userService = new UserServiceImpl();
            if(userService.deleteUserById(delId)){
                resultMap.put("delResult", "true");
            }else{
                resultMap.put("delResult", "false");
            }
        }

        //把resultMap转换成json对象输出
        resp.setContentType("application/json");
        PrintWriter outPrintWriter = resp.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();
        outPrintWriter.close();
    }

    //通过id得到用户信息
    private void getUserById(HttpServletRequest req, HttpServletResponse resp,String url) throws ServletException, IOException{

        String id = req.getParameter("uid");
        if(!StringUtils.isNullOrEmpty(id)){
            //调用后台方法得到user对象
            UserService userService = new UserServiceImpl();
            User user = userService.getUserById(id);
            req.setAttribute("user", user);
            req.getRequestDispatcher(url).forward(req, resp);
        }
    }

    //修改用户信息
    private void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //需要拿到前端传递进来的参数
        String id = req.getParameter("uid");;
        String userName = req.getParameter("userName");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");

        //创建一个user对象接收这些参数
        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUserName(userName);
        user.setGender(Integer.valueOf(gender));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Integer.valueOf(userRole));
        user.setModifyBy(((User)req.getSession().getAttribute(Constants.USER_SESSION)).getId());
        user.setModifyDate(new Date());

        //调用service层
        UserServiceImpl userService = new UserServiceImpl();
        Boolean flag = userService.modify(user);

        //判断是否修改成功来决定跳转到哪个页面
        if(flag){
            resp.sendRedirect(req.getContextPath()+"/jsp/user.do?method=query");
        }else{
            req.getRequestDispatcher("usermodify.jsp").forward(req, resp);
        }

    }
```

### 5.订单管理模块

#### 5.1 BillDao

```java
package com.mario.dao.bill;

import com.mario.pojo.Bill;


import java.sql.Connection;
import java.util.List;

public interface BillDao {
    /**
     * 增加订单
     * @param connection
     * @param bill
     * @return
     * @throws Exception
     */
    public int add(Connection connection, Bill bill)throws Exception;


    /**
     * 通过查询条件获取供应商列表-模糊查询-getBillList
     * @param connection
     * @param bill
     * @return
     * @throws Exception
     */
    public List<Bill> getBillList(Connection connection, Bill bill)throws Exception;

    /**
     * 通过delId删除Bill
     * @param connection
     * @param delId
     * @return
     * @throws Exception
     */
    public int deleteBillById(Connection connection, String delId)throws Exception;


    /**
     * 通过billId获取Bill
     * @param connection
     * @param id
     * @return
     * @throws Exception
     */
    public Bill getBillById(Connection connection, String id)throws Exception;

    /**
     * 修改订单信息
     * @param connection
     * @param bill
     * @return
     * @throws Exception
     */
    public int modify(Connection connection, Bill bill)throws Exception;

    /**
     * 根据供应商ID查询订单数量
     * @param connection
     * @param providerId
     * @return
     * @throws Exception
     */
    public int getBillCountByProviderId(Connection connection, String providerId)throws Exception;
}
```

#### 5.2 BillDaoImpl

```java
package com.mario.dao.bill;

import com.mario.dao.BaseDao;
import com.mario.pojo.Bill;
import com.mysql.cj.util.StringUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class BillDaoImpl  implements BillDao{

    //根据用户输入的值，新增订单表
    public int add(Connection connection, Bill bill) throws Exception {
        int updateNum=0;
        PreparedStatement pstm=null;
        if(connection!=null){
            String sql = "insert into smbms_bill (billCode,productName,productDesc," +
                    "productUnit,productCount,totalPrice,isPayment,providerId,createdBy,creationDate) " +
                    "values(?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {bill.getBillCode(),bill.getProductName(),bill.getProductDesc(),
                    bill.getProductUnit(),bill.getProductCount(),bill.getTotalPrice(),bill.getIsPayment(),
                    bill.getProviderId(),bill.getCreatedBy(),bill.getCreationDate()};
            updateNum = BaseDao.execute(connection, sql, params,pstm);
            BaseDao.closeResource(null, pstm, null);
            System.out.println("dao--------修改行数 " + updateNum);
        }
        return updateNum;
    }

    //根据用户输入的值条件，查询订单表
    public List<Bill> getBillList(Connection connection, Bill bill) throws Exception {
        List<Bill> billList = new ArrayList<Bill>();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        if(connection!=null){
            StringBuffer sql=new StringBuffer();
            sql.append("SELECT b.*,p.proName AS providerName FROM smbms_bill b, smbms_provider p WHERE b.providerId = p.id");
            List<Object> list = new ArrayList<Object>();//用来暂存用户的输入
            if(!StringUtils.isNullOrEmpty(bill.getProductName())){//判断用户是否输入商品名称
                sql.append(" AND b.`productName` LIKE ?");
                list.add("%"+bill.getProductName()+"%");
            }
            if(bill.getProviderId()>0){//判断是否选择了供应商
                sql.append(" AND p.`providerId`=?");
                list.add(bill.getProviderId());
            }if(bill.getIsPayment()>0){//判断是否选择了是否付款
                sql.append(" AND b.`isPayment`=?");
                list.add(bill.getIsPayment());
            }
            Object[] params=list.toArray();
            rs= BaseDao.execute(connection, sql.toString(), params, rs, pstm);
            System.out.println("当前的sql是----->"+sql.toString());
            while(rs.next()){
                Bill _bill = new Bill();//创建一个bill对象存储查询到的属性
                _bill.setId(rs.getInt("id"));
                _bill.setBillCode(rs.getString("billCode"));
                _bill.setProductName(rs.getString("productName"));
                _bill.setProductDesc(rs.getString("productDesc"));
                _bill.setProductUnit(rs.getString("productUnit"));
                _bill.setProductCount(rs.getBigDecimal("productCount"));
                _bill.setTotalPrice(rs.getBigDecimal("totalPrice"));
                _bill.setIsPayment(rs.getInt("isPayment"));
                _bill.setProviderId(rs.getInt("providerId"));
                _bill.setProviderName(rs.getString("providerName"));
                _bill.setCreationDate(rs.getTimestamp("creationDate"));
                _bill.setCreatedBy(rs.getInt("createdBy"));
                billList.add(_bill);
            }
            BaseDao.closeResource(null,pstm,rs);
        }

        return billList;
    }

    //根据订单id删除该订单
    public int deleteBillById(Connection connection, String delId) throws Exception {
        int delNum=0;
        PreparedStatement pstm=null;
        if(connection!=null){
            String sql="DELETE FROM `smbms_bill` WHERE id=?";
            Object[] params={delId};
            delNum = BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null,pstm,null);
        }
        return delNum;
    }

    //通过订单id得到该订单的所有信息（正确）
    public Bill getBillById(Connection connection, String id) throws Exception {
        // TODO Auto-generated method stub
        Bill bill = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        if(null != connection){
            String sql = "select b.*,p.proName as providerName from smbms_bill b, smbms_provider p " +
                    "where b.providerId = p.id and b.id=?";
            Object[] params = {id};
            rs = BaseDao.execute(connection,sql, params,rs,pstm);
            if(rs.next()){
                bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setBillCode(rs.getString("billCode"));
                bill.setProductName(rs.getString("productName"));
                bill.setProductDesc(rs.getString("productDesc"));
                bill.setProductUnit(rs.getString("productUnit"));
                bill.setProductCount(rs.getBigDecimal("productCount"));
                bill.setTotalPrice(rs.getBigDecimal("totalPrice"));
                bill.setIsPayment(rs.getInt("isPayment"));
                bill.setProviderId(rs.getInt("providerId"));
                bill.setProviderName(rs.getString("providerName"));
                bill.setModifyBy(rs.getInt("modifyBy"));
                bill.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return bill;
    }

    //根据用户传递输入的值修改订单表
    public int modify(Connection connection, Bill bill) throws Exception {
        int modifyNum=0;
        PreparedStatement pstm=null;
        if(connection!=null){
            String sql = "update smbms_bill set productName=?," +
                    "productDesc=?,productUnit=?,productCount=?,totalPrice=?," +
                    "isPayment=?,providerId=?,modifyBy=?,modifyDate=? where id = ? ";
            Object[] params = {bill.getProductName(),bill.getProductDesc(),
                    bill.getProductUnit(),bill.getProductCount(),bill.getTotalPrice(),bill.getIsPayment(),
                    bill.getProviderId(),bill.getModifyBy(),bill.getModifyDate(),bill.getId()};
            modifyNum=BaseDao.execute(connection,sql,params,pstm);
            BaseDao.closeResource(null,pstm,null);
        }
        return modifyNum;
    }

    //通过供应商id得到该供应商总订单数(正确）
    public int getBillCountByProviderId(Connection connection, String providerId) throws Exception {
        int billcount=0;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        if(connection!=null){
            String sql="SELECT COUNT(1) as billCount FROM `smbms_bill` WHERE `providerId`=?";
            Object[] params={providerId};
            rs = BaseDao.execute(connection, sql, params, rs, pstm);
            while(rs.next()){
                billcount=rs.getInt("billCount");
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return billcount;
    }
//    @Test
//    public void test(){
//        BillDaoImpl billDao = new BillDaoImpl();
//        Connection connection=BaseDao.getConnection();
//        int billList=0;
//        try {
//            billList=billDao.deleteBillById(connection,"19");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        BaseDao.closeResource(connection,null,null);
//        System.out.println(billList);
//    }
}
```

#### 5.3 BillService

```java
package com.mario.service.bill;

import com.mario.pojo.Bill;

import java.util.List;

public interface BillService {
    /**
     * 增加订单
     * @param bill
     * @return
     */
    public boolean add(Bill bill);


    /**
     * 通过条件获取订单列表-模糊查询-billList
     * @param bill
     * @return
     */
    public List<Bill> getBillList(Bill bill);

    /**
     * 通过billId删除Bill
     * @param delId
     * @return
     */
    public boolean deleteBillById(String delId);


    /**
     * 通过billId获取Bill
     * @param id
     * @return
     */
    public Bill getBillById(String id);

    /**
     * 修改订单信息
     * @param bill
     * @return
     */
    public boolean modify(Bill bill);
}
```

#### 5.4 BillServiceImpl

```java
package com.mario.service.bill;

import com.mario.dao.BaseDao;
import com.mario.dao.bill.BillDao;
import com.mario.dao.bill.BillDaoImpl;
import com.mario.pojo.Bill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillServiceImpl implements BillService{

    //业务层都会调用dao层，所以我们要引入Dao层；
    private BillDao billDao;
    public BillServiceImpl(){
        billDao = new BillDaoImpl();
    }

    //增加订单表
    public boolean add(Bill bill) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();//获得连接
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = billDao.add(connection,bill);
            connection.commit();
            if(updateRows > 0){
                flag = true;
                System.out.println("add success!");
            }else{
                System.out.println("add failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();//失败就回滚
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally{
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    public List<Bill> getBillList(Bill bill) {
        List<Bill> billList = new ArrayList<Bill>();
        Connection connection=null;
        System.out.println("query productName ---- > " + bill.getProductName());
        System.out.println("query providerId ---- > " + bill.getProviderId());
        System.out.println("query isPayment ---- > " + bill.getIsPayment());
        try {
            connection=BaseDao.getConnection();
            billList=billDao.getBillList(connection,bill);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return billList;
    }

    public boolean deleteBillById(String delId) {
        boolean flag=false;
        int delNum=0;
        Connection connection=null;
        try {
            connection=BaseDao.getConnection();
            delNum=billDao.deleteBillById(connection,delId);
            if(delNum>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    public Bill getBillById(String id) {
        Bill bill = new Bill();
        Connection connection=null;
        try {
            connection=BaseDao.getConnection();
            bill = billDao.getBillById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return bill;
    }

    public boolean modify(Bill bill) {
        Boolean flag=false;
        int modifyNum=0;
        Connection connection=null;
        try {
            connection=BaseDao.getConnection();
            modifyNum=billDao.modify(connection,bill);
            if(modifyNum>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }
}
```

#### 5.5 BillServlet

```java
package com.mario.servlet.bill;

import com.alibaba.fastjson.JSONArray;
import com.mario.pojo.Bill;
import com.mario.pojo.Provider;
import com.mario.pojo.User;
import com.mario.service.bill.BillService;
import com.mario.service.bill.BillServiceImpl;
import com.mario.service.provider.ProviderService;
import com.mario.service.provider.ProviderServiceImpl;
import com.mario.util.Constants;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BillServlet extends HttpServlet {
    public void init() throws ServletException {
        // Put your code here
    }
    public BillServlet() {
        super();
    }
    public void destroy() {
        super.destroy();
    }
    public static void main(String[] args) {
        System.out.println(new BigDecimal("23.235").setScale(2,BigDecimal.ROUND_HALF_DOWN));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String totalPrice = request.getParameter("totalPrice");
        //23.234   45
        BigDecimal totalPriceBigDecimal =
        //设置规则，小数点保留两位，多出部分，ROUND_DOWN 舍弃
        //ROUND_HALF_UP 四舍五入(5入) ROUND_UP 进位
        //ROUND_HALF_DOWN 四舍五入（5不入）
        new BigDecimal(totalPrice).setScale(2,BigDecimal.ROUND_DOWN);*/
        String method = request.getParameter("method");
        System.out.println("method----> " + method);
        if(method != null && method.equals("query")){
            this.query(request,response);
        }else if(method != null && method.equals("add")){
            this.add(request,response);
        }else if(method != null && method.equals("view")){
            this.getBillById(request,response,"billview.jsp");
        }else if(method != null && method.equals("modify")){
            this.getBillById(request,response,"billmodify.jsp");
        }else if(method != null && method.equals("modifysave")){
            this.modify(request,response);
        }else if(method != null && method.equals("delbill")){
            this.delBill(request,response);
        }else if(method != null && method.equals("getproviderlist")){
            this.getProviderlist(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    private void getProviderlist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("getproviderlist ========================= ");

        List<Provider> providerList = new ArrayList<Provider>();
        ProviderService providerService = new ProviderServiceImpl();
        providerList = providerService.getProviderList("","");
        //把providerList转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(providerList));
        outPrintWriter.flush();
        outPrintWriter.close();
    }
    private void getBillById(HttpServletRequest request, HttpServletResponse response,String url)
            throws ServletException, IOException {
        String id = request.getParameter("billid");
        if(!StringUtils.isNullOrEmpty(id)){
            BillService billService = new BillServiceImpl();
            Bill bill = null;
            bill = billService.getBillById(id);
            request.setAttribute("bill", bill);
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private void modify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("modify===============");
        String id = request.getParameter("id");
        String productName = request.getParameter("productName");
        String productDesc = request.getParameter("productDesc");
        String productUnit = request.getParameter("productUnit");
        String productCount = request.getParameter("productCount");
        String totalPrice = request.getParameter("totalPrice");
        String providerId = request.getParameter("providerId");
        String isPayment = request.getParameter("isPayment");

        Bill bill = new Bill();
        bill.setId(Integer.valueOf(id));
        bill.setProductName(productName);
        bill.setProductDesc(productDesc);
        bill.setProductUnit(productUnit);
        bill.setProductCount(new BigDecimal(productCount).setScale(2,BigDecimal.ROUND_DOWN));
        bill.setIsPayment(Integer.parseInt(isPayment));
        bill.setTotalPrice(new BigDecimal(totalPrice).setScale(2,BigDecimal.ROUND_DOWN));
        bill.setProviderId(Integer.parseInt(providerId));

        bill.setModifyBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        bill.setModifyDate(new Date());
        boolean flag = false;
        BillService billService = new BillServiceImpl();
        flag = billService.modify(bill);
        if(flag){//判断是否修改成功
            response.sendRedirect(request.getContextPath()+"/jsp/bill.do?method=query");
        }else{
            request.getRequestDispatcher("billmodify.jsp").forward(request, response);
        }
    }
    private void delBill(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("billid");
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(!StringUtils.isNullOrEmpty(id)){
            BillService billService = new BillServiceImpl();
            boolean flag = billService.deleteBillById(id);
            if(flag){//删除成功
                resultMap.put("delResult", "true");
            }else{//删除失败
                resultMap.put("delResult", "false");
            }
        }else{
            resultMap.put("delResult", "notexit");
        }
        //把resultMap转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();
        outPrintWriter.close();
    }
    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String billCode = request.getParameter("billCode");
        String productName = request.getParameter("productName");
        String productDesc = request.getParameter("productDesc");
        String productUnit = request.getParameter("productUnit");

        String productCount = request.getParameter("productCount");
        String totalPrice = request.getParameter("totalPrice");
        String providerId = request.getParameter("providerId");
        String isPayment = request.getParameter("isPayment");

        Bill bill = new Bill();
        bill.setBillCode(billCode);
        bill.setProductName(productName);
        bill.setProductDesc(productDesc);
        bill.setProductUnit(productUnit);
        bill.setProductCount(new BigDecimal(productCount).setScale(2,BigDecimal.ROUND_DOWN));
        bill.setIsPayment(Integer.parseInt(isPayment));
        bill.setTotalPrice(new BigDecimal(totalPrice).setScale(2,BigDecimal.ROUND_DOWN));
        bill.setProviderId(Integer.parseInt(providerId));
        bill.setCreatedBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        bill.setCreationDate(new Date());
        boolean flag = false;
        BillService billService = new BillServiceImpl();
        flag = billService.add(bill);
        System.out.println("add flag -- > " + flag);
        if(flag){//判断是否修改成功
            response.sendRedirect(request.getContextPath()+"/jsp/bill.do?method=query");
        }else{
            request.getRequestDispatcher("billadd.jsp").forward(request, response);
        }
    }
    private void query(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Provider> providerList = new ArrayList<Provider>();
        ProviderService providerService = new ProviderServiceImpl();
        providerList = providerService.getProviderList("","");
        request.setAttribute("providerList", providerList);

        String queryProductName = request.getParameter("queryProductName");
        String queryProviderId = request.getParameter("queryProviderId");
        String queryIsPayment = request.getParameter("queryIsPayment");
        if(StringUtils.isNullOrEmpty(queryProductName)){
            queryProductName = "";
        }

        List<Bill> billList = new ArrayList<Bill>();
        BillService billService = new BillServiceImpl();
        Bill bill = new Bill();
        if(StringUtils.isNullOrEmpty(queryIsPayment)){
            bill.setIsPayment(0);
        }else{
            bill.setIsPayment(Integer.parseInt(queryIsPayment));
        }

        if(StringUtils.isNullOrEmpty(queryProviderId)){
            bill.setProviderId(0);
        }else{
            bill.setProviderId(Integer.parseInt(queryProviderId));
        }
        bill.setProductName(queryProductName);
        billList = billService.getBillList(bill);
        request.setAttribute("billList", billList);
        request.setAttribute("queryProductName", queryProductName);
        request.setAttribute("queryProviderId", queryProviderId);
        request.setAttribute("queryIsPayment", queryIsPayment);
        request.getRequestDispatcher("billlist.jsp").forward(request, response);

    }
}
```

web.xml注册订单管理模块

```xml
<!--    注册BillServlet页面-->
    <servlet>
        <servlet-name>BillServlet</servlet-name>
        <servlet-class>com.mario.servlet.bill.BillServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>BillServlet</servlet-name>
        <url-pattern>/jsp/bill.do</url-pattern>
    </servlet-mapping>
```

### 6.供应商管理模块

#### 6.1 ProviderDao

```java
package com.mario.dao.provider;

import com.mario.pojo.Provider;

import java.sql.Connection;
import java.util.List;

public interface ProviderDao {
    /**
     * 增加供应商
     * @param connection
     * @param provider
     * @return
     * @throws Exception
     */
    public int add(Connection connection, Provider provider)throws Exception;


    /**
     * 通过供应商名称、编码获取供应商列表-模糊查询-providerList
     * @param connection
     * @param proName
     * @return
     * @throws Exception
     */
    public List<Provider> getProviderList(Connection connection, String proName, String proCode)throws Exception;

    /**
     * 通过proId删除Provider
     * @param delId
     * @return
     * @throws Exception
     */
    public int deleteProviderById(Connection connection, String delId)throws Exception;


    /**
     * 通过proId获取Provider
     * @param connection
     * @param id
     * @return
     * @throws Exception
     */
    public Provider getProviderById(Connection connection, String id)throws Exception;

    /**
     * 修改用户信息
     */
    public int modify(Connection connection, Provider provider)throws Exception;
}
```

#### 6.2 ProviderDaoImpl

```java
package com.mario.dao.provider;

import com.mario.dao.BaseDao;
import com.mario.pojo.Provider;
import com.mysql.cj.util.StringUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProviderDaoImpl implements ProviderDao{
    public int add(Connection connection, Provider provider) throws Exception {
        PreparedStatement pstm = null;
        int flag = 0;
        if(null != connection){
            String sql = "insert into smbms_provider (proCode,proName,proDesc," +
                    "proContact,proPhone,proAddress,proFax,createdBy,creationDate) " +
                    "values(?,?,?,?,?,?,?,?,?)";
            Object[] params = {provider.getProCode(),provider.getProName(),provider.getProDesc(),
                    provider.getProContact(),provider.getProPhone(),provider.getProAddress(),
                    provider.getProFax(),provider.getCreatedBy(),provider.getCreationDate()};
            flag = BaseDao.execute(connection, sql, params,pstm);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    public List<Provider> getProviderList(Connection connection, String proName, String proCode) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Provider> providerList = new ArrayList<Provider>();
        if(connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select * from smbms_provider where 1=1 ");
            List<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(proName)){
                sql.append(" and proName like ?");
                list.add("%"+proName+"%");
            }
            if(!StringUtils.isNullOrEmpty(proCode)){
                sql.append(" and proCode like ?");
                list.add("%"+proCode+"%");
            }
            Object[] params = list.toArray();
            System.out.println("sql ----> " + sql.toString());
            rs = BaseDao.execute(connection, sql.toString(), params,rs,pstm);
            while(rs.next()){
                Provider _provider = new Provider();
                _provider.setId(rs.getInt("id"));
                _provider.setProCode(rs.getString("proCode"));
                _provider.setProName(rs.getString("proName"));
                _provider.setProDesc(rs.getString("proDesc"));
                _provider.setProContact(rs.getString("proContact"));
                _provider.setProPhone(rs.getString("proPhone"));
                _provider.setProAddress(rs.getString("proAddress"));
                _provider.setProFax(rs.getString("proFax"));
                _provider.setCreationDate(rs.getTimestamp("creationDate"));
                providerList.add(_provider);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return providerList;
    }

    public int deleteProviderById(Connection connection, String delId) throws Exception {
        PreparedStatement pstm = null;
        int flag = 0;
        if(null != connection){
            String sql = "delete from smbms_provider where id=?";
            Object[] params = {delId};
            flag = BaseDao.execute(connection, sql, params,pstm);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    public Provider getProviderById(Connection connection, String id) throws Exception {
        Provider provider = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        if(null != connection){
            String sql = "select * from smbms_provider where id=?";
            Object[] params = {id};
            rs = BaseDao.execute(connection, sql, params, rs, pstm);
            if(rs.next()){
                provider = new Provider();
                provider.setId(rs.getInt("id"));
                provider.setProCode(rs.getString("proCode"));
                provider.setProName(rs.getString("proName"));
                provider.setProDesc(rs.getString("proDesc"));
                provider.setProContact(rs.getString("proContact"));
                provider.setProPhone(rs.getString("proPhone"));
                provider.setProAddress(rs.getString("proAddress"));
                provider.setProFax(rs.getString("proFax"));
                provider.setCreatedBy(rs.getInt("createdBy"));
                provider.setCreationDate(rs.getTimestamp("creationDate"));
                provider.setModifyBy(rs.getInt("modifyBy"));
                provider.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return provider;
    }

    public int modify(Connection connection, Provider provider) throws Exception {
        int flag = 0;
        PreparedStatement pstm = null;
        if(null != connection){
            String sql = "update smbms_provider set proName=?,proDesc=?,proContact=?," +
                    "proPhone=?,proAddress=?,proFax=?,modifyBy=?,modifyDate=? where id = ? ";
            Object[] params = {provider.getProName(),provider.getProDesc(),provider.getProContact(),provider.getProPhone(),provider.getProAddress(),
                    provider.getProFax(),provider.getModifyBy(),provider.getModifyDate(),provider.getId()};
            flag = BaseDao.execute(connection, sql, params, pstm);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }
//    @Test
//    public void test() throws Exception {
//        ProviderDaoImpl providerDao = new ProviderDaoImpl();
//        Provider provider = new Provider();
//        Connection connection=BaseDao.getConnection();
//        provider=providerDao.getProviderById(connection,"1");
//        System.out.println(provider.getProName());
//    }
}
```

#### 6.3 ProviderService

```java
package com.mario.service.provider;

import com.mario.pojo.Provider;

import java.util.List;

public interface ProviderService {
    /**
     * 增加供应商
     * @param provider
     * @return
     */
    public boolean add(Provider provider);


    /**
     * 通过供应商名称、编码获取供应商列表-模糊查询-providerList
     * @param proName
     * @return
     */
    public List<Provider> getProviderList(String proName, String proCode);

    /**
     * 通过proId删除Provider
     * @param delId
     * @return
     */
    public int deleteProviderById(String delId);


    /**
     * 通过proId获取Provider
     * @param id
     * @return
     */
    public Provider getProviderById(String id);

    /**
     * 修改用户信息
     */
    public boolean modify(Provider provider);
}
```

#### 6.4 ProviderServiceImpl

```java
package com.mario.service.provider;

import com.mario.dao.BaseDao;
import com.mario.dao.bill.BillDao;
import com.mario.dao.bill.BillDaoImpl;
import com.mario.dao.provider.ProviderDao;
import com.mario.dao.provider.ProviderDaoImpl;
import com.mario.pojo.Provider;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class ProviderServiceImpl implements ProviderService {

    private ProviderDao providerDao;
    private BillDao billDao;
    public ProviderServiceImpl(){
        providerDao = new ProviderDaoImpl();
        billDao = new BillDaoImpl();
    }
    public boolean add(Provider provider) {
        // TODO Auto-generated method stub
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            if(providerDao.add(connection,provider) > 0)
                flag = true;
            connection.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    public List<Provider> getProviderList(String proName, String proCode) {
        Connection connection = null;
        List<Provider> providerList = null;
        System.out.println("query proName ---- > " + proName);
        System.out.println("query proCode ---- > " + proCode);
        try {
            connection = BaseDao.getConnection();
            providerList = providerDao.getProviderList(connection, proName,proCode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return providerList;
    }


    /**
     * 业务：根据ID删除供应商表的数据之前，需要先去订单表里进行查询操作
     * 若订单表中无该供应商的订单数据，则可以删除
     * 若有该供应商的订单数据，则不可以删除
     * 返回值billCount
     * 1> billCount == 0  删除---1 成功 （0） 2 不成功 （-1）
     * 2> billCount > 0    不能删除 查询成功（0）查询不成功（-1）
     *
     * ---判断
     * 如果billCount = -1 失败
     * 若billCount >= 0 成功
     */
    public int deleteProviderById(String delId) {
        // TODO Auto-generated method stub
        Connection connection = null;
        int billCount = -1;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            billCount = billDao.getBillCountByProviderId(connection,delId);
            if(billCount == 0){
                providerDao.deleteProviderById(connection, delId);
            }
            connection.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            billCount = -1;
            try {
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return billCount;
    }

    public Provider getProviderById(String id) {
        // TODO Auto-generated method stub
        Provider provider = null;
        Connection connection = null;
        try{
            connection = BaseDao.getConnection();
            provider = providerDao.getProviderById(connection, id);
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            provider = null;
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return provider;
    }

    public boolean modify(Provider provider) {
        // TODO Auto-generated method stub
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if(providerDao.modify(connection,provider) > 0)
                flag = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

}
```

#### 6.5 ProviderServlet

```java
package com.mario.servlet.provider;


import com.alibaba.fastjson.JSONArray;
import com.mario.pojo.Provider;
import com.mario.pojo.User;
import com.mario.service.provider.ProviderService;
import com.mario.service.provider.ProviderServiceImpl;
import com.mario.util.Constants;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ProviderServlet extends HttpServlet {

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method != null && method.equals("query")){
            this.query(request,response);
        }else if(method != null && method.equals("add")){
            this.add(request,response);
        }else if(method != null && method.equals("view")){
            this.getProviderById(request,response,"providerview.jsp");
        }else if(method != null && method.equals("modify")){
            this.getProviderById(request,response,"providermodify.jsp");
        }else if(method != null && method.equals("modifysave")){
            this.modify(request,response);
        }else if(method != null && method.equals("delprovider")){
            this.delProvider(request,response);
        }
    }

    private void delProvider(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("proid");
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(!StringUtils.isNullOrEmpty(id)){
            ProviderService providerService = new ProviderServiceImpl();
            int flag = providerService.deleteProviderById(id);
            if(flag == 0){//删除成功
                resultMap.put("delResult", "true");
            }else if(flag == -1){//删除失败
                resultMap.put("delResult", "false");
            }else if(flag > 0){//该供应商下有订单，不能删除，返回订单数
                resultMap.put("delResult", String.valueOf(flag));
            }
        }else{
            resultMap.put("delResult", "notexit");
        }
        //把resultMap转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();
        outPrintWriter.close();
    }

    private void modify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proContact = request.getParameter("proContact");
        String proPhone = request.getParameter("proPhone");
        String proAddress = request.getParameter("proAddress");
        String proFax = request.getParameter("proFax");
        String proDesc = request.getParameter("proDesc");
        String id = request.getParameter("id");
        Provider provider = new Provider();
        provider.setId(Integer.valueOf(id));
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProFax(proFax);
        provider.setProAddress(proAddress);
        provider.setProDesc(proDesc);
        provider.setModifyBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        provider.setModifyDate(new Date());
        boolean flag = false;
        ProviderService providerService = new ProviderServiceImpl();
        flag = providerService.modify(provider);
        if(flag){
            response.sendRedirect(request.getContextPath()+"/jsp/provider.do?method=query");
        }else{
            request.getRequestDispatcher("providermodify.jsp").forward(request, response);
        }
    }

    private void getProviderById(HttpServletRequest request, HttpServletResponse response,String url)
            throws ServletException, IOException {
        String id = request.getParameter("proid");
        if(!StringUtils.isNullOrEmpty(id)){
            ProviderService providerService = new ProviderServiceImpl();
            Provider provider = null;
            provider = providerService.getProviderById(id);
            request.setAttribute("provider", provider);
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proCode = request.getParameter("proCode");
        String proName = request.getParameter("proName");
        String proContact = request.getParameter("proContact");
        String proPhone = request.getParameter("proPhone");
        String proAddress = request.getParameter("proAddress");
        String proFax = request.getParameter("proFax");
        String proDesc = request.getParameter("proDesc");

        Provider provider = new Provider();
        provider.setProCode(proCode);
        provider.setProName(proName);
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProFax(proFax);
        provider.setProAddress(proAddress);
        provider.setProDesc(proDesc);
        provider.setCreatedBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        provider.setCreationDate(new Date());
        boolean flag = false;
        ProviderService providerService = new ProviderServiceImpl();
        flag = providerService.add(provider);
        if(flag){
            response.sendRedirect(request.getContextPath()+"/jsp/provider.do?method=query");
        }else{
            request.getRequestDispatcher("provideradd.jsp").forward(request, response);
        }
    }

    private void query(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String queryProName = request.getParameter("queryProName");
        String queryProCode = request.getParameter("queryProCode");
        if(StringUtils.isNullOrEmpty(queryProName)){
            queryProName = "";
        }
        if(StringUtils.isNullOrEmpty(queryProCode)){
            queryProCode = "";
        }
        List<Provider> providerList = new ArrayList<Provider>();
        ProviderService providerService = new ProviderServiceImpl();
        providerList = providerService.getProviderList(queryProName,queryProCode);
        request.setAttribute("providerList", providerList);
        request.setAttribute("queryProName", queryProName);
        request.setAttribute("queryProCode", queryProCode);
        request.getRequestDispatcher("providerlist.jsp").forward(request, response);
    }


    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}
```

web.xml注册订单管理模块

```xml
<!--    注册ProviderServlet页面-->
    <servlet>
        <servlet-name>ProviderServlet</servlet-name>
        <servlet-class>com.mario.servlet.provider.ProviderServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>ProviderServlet</servlet-name>
        <url-pattern>/jsp/provider.do</url-pattern>
    </servlet-mapping>
```

### 7 总结

#### 7.1 最终的结构目录图

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/4d38c1dd0adc526e3720961a0ba29be4.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/7f90b030f55a5efb92bc06dd57b1768a.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

![img](https://haobin-001.oss-cn-hangzhou.aliyuncs.com/imgs-for-typora/2cdceab2287b5e78be2e2f523ead60d4.png?x-oss-process=image/auto-orient,1/quality,q_90/watermark,text_56iL5bqP5ZGY5aW95Yaw,type_ZmFuZ3poZW5na2FpdGk,color_fef6f0,size_30,shadow_100,g_se,x_10,y_10)

#### 7.2 所有前端资源的下载地址

[github地址](https://github.com/five517/SMBMS)
[gitee地址](https://gitee.com/mario517/SMBMS/tree/main/)
