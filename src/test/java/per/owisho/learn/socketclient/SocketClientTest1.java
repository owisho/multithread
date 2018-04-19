package per.owisho.learn.socketclient;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class SocketClientTest1 {

	public static void main(String[] args) throws URISyntaxException, InterruptedException {
		WebSocketClient client = new WebSocketClient(new URI("ws://10.199.2.18:8061/video_offline?url=http://10.156.0.147:8080/vedios/3.mp4")) {
			
			@Override
			public void onOpen(ServerHandshake handshakedata) {
				System.out.println("连接建立");
			}
			
			@Override
			public void onMessage(String message) {
				System.out.println("消息获取中");
				System.out.println(message);
			}
			
			@Override
			public void onError(Exception ex) {
				ex.printStackTrace();
			}
			
			@Override
			public void onClose(int code, String reason, boolean remote) {
				System.out.println("连接关闭");
				System.out.println(reason);
				System.out.println(code);
			}
		};
		client.connect();
		Thread.sleep(100000);
	}
	
}
