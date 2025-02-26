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
    一般是使用Ribbon，或者是整合Spring cloud loadbalancer来实现负载均衡。
    负载均衡的实现方式有很多种，例如轮询、随机、权重等。

## 说一下Nacos的负载均衡？

    Nacos一般是与ribbon或者是Spring cloud进行整合的

    Nacos is an open - source dynamic service discovery, configuration management, and service management platform developed

## 负载均衡的策略有哪些？

    1. 轮询：按照顺序依次分配请求，适用于服务器性能相近的情况
    2. 随机：随机分配请求，可以在一定程度上解决某台服务器过于繁忙的问题
    3. 加权轮询：每个服务器分配一个权重，给性能较好的服务器分配更高的权重，充分利用系统的资源
    4. 最小连接：将请求分配给当前连接数最少的服务器
    5. 哈希：根据请求的哈希值分配请求（id或者是ip来分配）

    Weighted Random Strategy
    Weighted Round - Robin Strategy

## 说一下多线程，介绍一下线程池

    线程池是一种管理线程的技术，把创建的线程比喻成一个池，当有任务需要执行的时候，就从线程池中取出一个线程来执行任务，执行完毕之后再将线程放回线程池中。
    线程池的优点：
    1. 减少了线程创建和销毁的开销
    2. 可以控制线程的数量，避免线程过多导致系统资源不足
    3. 可以提高系统的响应速度

    Thread pool can avoid the performance overhead caused by frequently creating and destroying threads, improving the system's response speed and resource utilization.

    常用的线程池创建方法
    1. Executors.newFixedThreadPool(int nThreads)：创建一个固定大小的线程池，适用于任务量已知，并且任务执行时间较短的情况。
    2. Executors.newCachedThreadPool()：创建一个可缓存的线程池，适用于任务量未知，并且任务执行时间较长的情况。
    3. Executors.newSingleThreadExecutor()：创建一个单线程的线程池，适用于任务量较少，并且任务执行时间较长的情况。

    线程池的核心参数
    1. corePoolSize：核心线程数，线程池中保持的线程数，即使线程处于空闲状态，也不会被销毁。
    2. maximumPoolSize：最大线程数，线程池中允许的最大线程数。
    3. keepAliveTime：空闲线程的存活时间，当线程处于空闲状态时，超过该时间就会被销毁。
    4. unit：空闲线程的存活时间单位。
    5. workQueue：任务队列，用于存放待执行的任务。
    6. threadFactory：线程工厂，用于创建线程。
    7. handler：拒绝策略，当任务队列已满，并且线程池中的线程数达到最大线程数时，就会触发拒绝策略。

## 说一下线程的生命周期
    1. 新建状态：当线程对象被创建时，线程就进入了新建状态。
    2. 就绪状态：当线程对象被创建后，调用了start()方法，线程就进入了就绪状态。
    3. 运行状态：当线程获得CPU时间片后，线程就进入了运行状态。
    4. 阻塞状态：当线程需要等待某个资源时，线程就进入了阻塞状态。
    5. 终止状态：当线程执行完毕或者出现异常时，线程就进入了终止状态。

## 了解RESTFUL API吗

    GET：用于获取资源的信息，应该是幂等的，即多次执行相同的 GET 请求应该返回相同的结果，不会对服务器资源产生副作用。
    POST：用于创建新的资源，通常会在请求体中包含要创建的资源的相关数据。
    PUT：用于更新资源的全部内容，需要提供完整的资源数据。
    DELETE：用于删除指定的资源。

    GET: It is used to obtain information about resources and should be idempotent. That is, executing the same GET request multiple times should return the same result without having side - effects on server resources.
    POST: It is used to create new resources. Usually, the data related to the resource to be created is included in the request body.
    PUT: It is used to update the entire content of a resource. Complete resource data needs to be provided.
    DELETE: It is used to delete the specified resource.
    
## 什么情况使用GET什么情况使用POST？

    使用GET的情景：获取资源，发起请求，不改变资源的状态，只需要获取资源的信息，不需要修改资源的内容。
    GET resource and did not change the resource state.

    使用POST的情景：创建资源，发起请求，改变资源的状态，需要修改资源的内容，需要创建新的资源。
    POST create resource and change the resource state.

## 使用GET请求有什么缺点？

    1. 数据量有限制，GET请求的URL长度有限制，一般为2048个字符。
    2. 安全性问题，GET请求的数据会暴露在URL中，也容易被爬虫获取到信息
    3. 具有可缓存性，GET请求可以被缓存，但是POST请求不可以被缓存。

    安全性比较低，数据长度有限制，不适合处理复杂的文件，不能用来上传文件，可能会有缓存不一致的问题（比如前端的缓存）
    It may lead to user privacy leakage and information security issues, posing potential risks to users and the system.
    t limits the amount of data that a GET request can carry, making it unsuitable for scenarios that require transmitting a large amount of data
    It is not conducive to handling complex business logic and data interaction, increasing the difficulty of development and maintenance.
    Have some cache issue, need to reflash the cache.