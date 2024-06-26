参考链接：[https://zhuanlan.zhihu.com/p/53374516](https://zhuanlan.zhihu.com/p/53374516)

# 什么是“3次握手，4次挥手”

TCP是一种**面向连接的单播协议**，在发送数据前，通信双方必须在彼此间建立一条连接。所谓的“连接”，其实是客户端和服务器的内存里保存的一份关于对方的信息，如ip地址、端口号等。

TCP可以看成是一种字节流，它会处理IP层或以下的层的丢包、重复以及错误问题。在连接的建立过程中，双方需要交换一些连接的参数。这些参数可以放在TCP头部。

TCP提供了一种可靠、面向连接、字节流、传输层的服务，**采用三次握手建立一个连接。采用4次挥手来关闭一个连接。**

> 一个TCP链接由4个元组构成，分别是两个IP地址和两个端口号。一个TCP链接通常分为三个阶段：启动、数据传输、退出（关闭）

# 为什么要三次握手，四次挥手

## 三次握手

<kbd>第一次握手</kbd>：客户端发送网络包，服务端收到。

> 确定客户端的发送能力、服务端的接收能力正常。

<kbd>第二次握手</kbd>：服务端发包，客户端收到。

> 服务端的接收、发送能力，客户端的接收、发送能力正常。

<kbd>第三次握手</kbd>：客户端发包，服务端收到。

> 客户端的接收、发送能力，服务端的发送、接受能力正常。

### **过程：** 

> 1. 客户端发送一个SYN段，并指明客户端的初始序列号，即ISN(c).
> 2. 服务端发送自己的SYN段作为应答，同样指明自己的ISN(s)。为了确认客户端的SYN，将ISN(c)+1作为ACK数值。这样，每发送一个SYN，序列号就会加1. 如果有丢失的情况，则会重传。
> 3. 为了确认服务器端的SYN，客户端将ISN(s)+1作为返回的ACK数值。


## 四次挥手

TCP连接是双向传输的对等的模式。当有一方要关闭连接时，会发送指令给对方，对方会回一个ACK，此时一个方向的连接关闭。但是另一个方向仍然可以仍然可以继续传输数据，等到发送完所有数据后会发送一个FIN段来关闭此方向上的连接。接收方发送ACK确认关闭连接。

> 接收到FIN的一方只能回复一个ACK，它是无法马上返回一个FIN报文段的。

### **过程：**

> 1. 客户端发送一个FIN段，并包含一个希望接收者看到的自己当前的序列号K. 同时还包含一个ACK表示确认对方最近一次发过来的数据。
> 2. 服务端将K值加1作为ACK序号值，表明收到了上一个包。这时上层的应用程序会被告知另一端发起了关闭操作，通常这将引起应用程序发起自己的关闭操作。
> 3. 服务端发起自己的FIN段，ACK=K+1, Seq=L 4. 客户端确认。ACK=L+1

