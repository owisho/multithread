# multithread 多线程编程学习

包per.owisho.learn.mutithread.base基础知识学习


# volatile关键字
1.保障线程对修饰变量的可见性（但不能代表被修饰的数据线程安全，可见后的数据仍然可以被多个线程修改，导致错误写入）   
2.禁止虚拟机指令重排序   
禁止重排序的伪代码如下：   
