package socket2;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			//서버에 접속할 소켓 만들기(클라이언트) 
			Socket socket = new Socket("127.0.0.1", 9998);
			System.out.println("클라이언트 ");
			//클라이언트가 접속을 하면 서버에서 바로 스트림을 통해 바로 전송
			//들어오는 데이터를 buf에 받고 출력
			byte[] buf = new byte[1024];
			socket.getInputStream().read(buf);
			for(byte b:buf)
			System.out.print((char)b);
			System.out.println();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
