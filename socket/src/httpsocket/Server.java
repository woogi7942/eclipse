package httpsocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//서버, 클라이언트, 클라이언트가 서버에 접속, 
//서버는 소켓을 생성하고 내보내는 스트림(outputstream)으로 클라이언트에게 데이터 바로 전송

public class Server {

	public static void main(String[] args) {
		try {
			int count=0;
			//서버 소켓 만들기(서버)
			ServerSocket server=new ServerSocket(9090);
			//반드시 반복문이 있어야 서비스 가능함
			//http프로토콜은 수신에 대한 응답형태로 이루어지기 때문 
			while(true) {
			//들어오기를 기다리는 중  
			System.out.println("서버 접속대기중...... ");
			Socket client=server.accept();
			String senddata="HTTP/1.1 200 OK Content-Type:text/html;charset=utf-8\r\n\n";
			//마지막에 \r\n\n  구분을 반드시 붙여줘야하고 이 코드는 http프로토콜의 header의 내용이다.
			senddata+="클라이언트 접속";
			senddata+=":"+count++;
			
			//byte[] b = new byte[1024];
			//client.getInputStream().read(b);
			client.getOutputStream().write(senddata.getBytes());
			client.getOutputStream().flush();
			client.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
