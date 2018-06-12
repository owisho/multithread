# multithread 多线程编程学习

包per.owisho.learn.mutithread.base基础知识学习


# volatile关键字
1.保障线程对修饰变量的可见性（但不能代表被修饰的数据线程安全，可见后的数据仍然可以被多个线程修改，导致错误写入）   
2.禁止虚拟机指令重排序   
禁止重排序的伪代码如下：   
```
  Map configOptions;
  char[] configText;
  // 次变量必须定义为volatile
  volatile boolean initialized = false;
  
  //假设以下代码在线程A中执行
  //模拟读取配置信息，当读取完成后将initialized设置为true以通知其他线程配置可用
  configOptions = new HashMap();
  configText = readConfigFile(fileName);
  processConfigOptions(configText,configOptions);
  initialized = true;
  
  
  //假设以下代码是在线程B中执行
  //等待initialized为true,代表线程A已经把配置信息初始化完成
  while(!initialized){
    sleep();
  }
  //使用线程A中初始化好的配置信息
  doSomethingWithConfig();
```
