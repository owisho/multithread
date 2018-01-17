package per.owisho.learn.multithread.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIODemo {

	public static void main(String[] args) throws IOException {
		ExecutorService executor = Executors.newFixedThreadPool(100);//线程池
		ServerSocket serverSocket = new ServerSocket(8088);
		while(!Thread.currentThread().isInterrupted()) {
			Socket socket = serverSocket.accept();
			executor.submit(new ConnectIOHandler(socket));
		}
		
	}
	
}

class ConnectIOHandler extends Thread{
	
	private Socket socket ;
	
	public ConnectIOHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		while(!Thread.currentThread().isInterrupted()&&!socket.isClosed()) {
//			String someThing = socket.read();//读取数据
//			if(someThing != null) {
				//处理数据
//				socket.write();//会写数据
//			}
		}
	}
}
