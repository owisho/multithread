package per.owisho.learn.socketclient;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class SocketClientTest {

	public static void main(String[] args) throws URISyntaxException {
		WebSocketClient client = new WebSocketClient(new URI("ws://10.199.2.18:8061/video_track?url=rtsp://admin:admin@10.169.0.200&limit=5&crop=face,body&group=56&threshold=180,22,22,0.9&alert=70&name=deployes_32_56_10.156.0.180&keepclip=1800")) {
			
			@Override
			public void onOpen(ServerHandshake handshakedata) {
				
			}
			
			@Override
			public void onMessage(String message) {
				System.out.println(message);
			}
			
			@Override
			public void onError(Exception ex) {
				ex.printStackTrace();
			}
			
			@Override
			public void onClose(int code, String reason, boolean remote) {
				System.out.println(reason);
				System.out.println(code);
			}
		};
		client.connect();
	}
	
}
