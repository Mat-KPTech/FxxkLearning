## mysql主键索引和复合索引的区别？

    主键索引是基于数据库表的主键字段来建立的，不允许重复和不允许空值。主键索引通常会在建立主键的时候就会由数据库建立。
    复合索引是基于数据库表的多个字段来建立的，复合索引是允许有空值。需要手动创建。

    A table can have only one primary key, so the primary key index is also unique and does not allow null values.
    It can include two or more columns, and these columns are combined to improve query efficiency

    The primary key index is automatically created after specifying the primary key when creating the table and is usually automatically maintained by the database system.
    Composite indexes need to be created manually, and when inserting, updating, and deleting data, the database needs additional overhead to maintain the composite index.    
    Composite indexes cant have null value.

## 主键索引的失效场景是什么？
    类型不匹配，使用了函数比如 year() 函数之类的就会导致失效，还有使用了or，使用了模糊查询，使用了索引列的运算。
    SELECT * FROM table WHERE primary_key_column > 10 AND primary_key_column = 20;在对主键范围进行查询并且还有等值运算的也会失效。

    Type mismatch
    Using functions
    Equality query after range query:

## 复合索引的失效场景是什么？

    最左原则，最左匹配原则，从左向右匹配，如果左边的字段没有匹配上，那么右边的字段就不会匹配上。
    使用了or的连接也会导致失效。
    索引列使用了函数或者存在表达式的情况也会失效。

    Not following the left - most prefix principle
    Using OR to connect conditions
    Using functions or expressions on index columns

## 如何保证项目的高可用和高并发？

    从硬件的方面：
    1. 服务器集群，负载均衡，当其中一台服务器发生故障的时候，可以自己将请求转发到其他的服务上，避免单点故障影响系统的使用。
    2. 冗余设计，比如使用主从复制或者集群的方式部署数据库，如果出现问题也可以快速切换
    3. 简历监控系统，当cpu使用率或者是内存使用率等指标出现异常的时候可以让运维人员及时处理问题
    4. 故障自动恢复：使用脚本检测，当出现故障时自动重启或者切换节点，减少人工干预所需要的时间
    5. 异地多活：服务器部署在不同的地方

    从软件方面看
    1. 缓存：
    2. 异步处理：把一些非核心的业务重构为异步的处理方式，避免阻塞主线程。例如使用消息队列（如 RabbitMQ、Kafka）将请求放入队列中，后台的工作线程再从队列中取出任务进行处理。这样可以避免同步处理带来的阻塞，提高系统的并发处理能力。
    3. 数据库优化：合理设计数据库结构
    4. 代码优化

## 说一下SpringCloud的负载均衡？

    负载均衡是指在多个服务器之间分配请求，以达到提高系统性能和可用性的目的。

## 说一下Nacos的负载均衡？

## 说一下多线程，介绍一下线程池
