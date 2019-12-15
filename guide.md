# postOffice管理系统遇到的坑
## 数据库字符集混用：
- 原因：建表时，没有制定表的编码方式，mysql默认为binary
- 将已建的表导出dump文件，重新建表，使编码格式为utf8
## mybatis以对象传参时，传入参数为null
- 原因：insert时的格式为 id=#{id},
- 应该使用 (#{id})