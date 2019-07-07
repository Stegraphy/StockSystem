# StockSystem
This is Hand Expirment Program
#
启动端口Spring port = 9090
#配置mysql数据源
#spring.datasource.url=jdbc:mysql://localhost:3306/stockdata?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true
#spring.datasource.username=root
#spring.datasource.password=123456

### 项目详情
后端实践项目前期准备
1.开发工具准备:git、jdk、idea、maven
2.基础知识储备:java、spring & spring mvc、json、sql

项目要求
1、项目使用maven作为包管理工具
2、项目使用java作为基础语言
3、需将代码提交至github上
4、代码库需要提供具体的readme.md用于描述代码库的配置及启动说明内容

1、使用Spring,Spring MVC开发一个股票信息下载，下载所有股票的前10年的价格信息
2、使用Job定时执行下载
3、添加股票列表，及单个股票的历史价格查询界面
4、开发一个展示前30天涨幅超过5%的次数的页面
5、对SQL进行优化
6、对表建索引
7、分别从腾讯和新浪下载股票信息

#### 项目进度
目前只实现了新浪抓取股票信息功能，未能实现所有股票10年数据储存，定时功能和页面展示功能
