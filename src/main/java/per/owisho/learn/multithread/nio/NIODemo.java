package per.owisho.learn.multithread.nio;

import java.net.Socket;

public class NIODemo {

	
	
}

/*
interface ChannelHandler{
	
	void channelReadable(Channel channel);
	
	void channelWritable(Channel channel);
	
}

class Channel{

	Socket socket;
	
	Event event;
	
}

class IOThread extends Thread{
	public void run() {
		Channel channel;
		while(channel=Selector.select()) {//选择就绪的事件和对应的链接
			if(channel.event == accept) {
				registerNewChannelHandler(channel);//如果是新链接，则注册一个新的读写处理器
			}
			if(channel.event == write) {
				getChannelHandler(channel).channelWritable(channel);//如果可以写，则执行写事件
			}
			if(channel.event == read) {
				getChannelHandler(channel).channelReadable(channel);//如果可以度，则执行读事件
			}
		}
	}
	Map<Channel,ChannelHandler> handlerMap;//所有channel的对应事件处理器
}
*/