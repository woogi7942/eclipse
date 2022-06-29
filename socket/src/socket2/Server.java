package socket2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//서버, 클라이언트, 클라이언트가 서버에 접속, 
//서버는 소켓을 생성하고 내보내는 스트림(outputstream)으로 클라이언트에게 데이터 바로 전송

public class Server {

	public static void main(String[] args) {
		try {
			//서버 소켓 만들기(서버)
			ServerSocket server=new ServerSocket(9998);
			//들어오기를 기다리는 중  
			System.out.println("서버 접속대기중...... ");
			Socket client=server.accept();
			System.out.println("클라이언트 접속 ");
			
			//1.byte전송 
			/*
			byte[] buf={65,66,67};
			//접속해오면 바로 클라이언트에게 내보내는 스트림을 통해 데이터 보내
			client.getOutputStream().write(buf);
			client.getOutputStream().flush();
			*/
			
			//2.string 전송 
			String data="hello";
			client.getOutputStream().write(data.getBytes());
			client.getOutputStream().flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
