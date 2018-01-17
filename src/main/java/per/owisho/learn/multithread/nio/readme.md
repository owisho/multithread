nio 非阻塞io
是一种在等待就绪过程中不进行阻塞的io处理方式

NIO的核心事件有：读就绪，写就绪，有新的链接到来

核心概念：
Selector
 
用一个死循环来选择就绪事件，会调用系统（linux2.6之前是select，poll，2.6之后是epoll，Windows是IOCP），还会阻塞的等待新事件的到来。
新事件到来的时候，会在selector上注册标记，标志可读，可写或者有链接到来。

注意，select是阻塞的，无论是通过操作系统的通知（epoll）还是不停的轮询（select，poll），这个函数是阻塞的。所以你可以放心大胆地在一个while（true）里面调用这个函数而不用担心CPU空转。

