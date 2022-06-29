package socket1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
public static void main(String[] args) {
	// 클라이언트 인스턴스 생성 (프로그램이 종료 될때 자동 close)
	try (Socket client = new Socket()) {
	// 로컬:9999 포트에 서버에 접속한다.
	InetSocketAddress ip = new InetSocketAddress("127.0.0.1", 9999);
	// 접속
	client.connect(ip);
	// OutputStream과 InputStream를 받는다.
	try (OutputStream send = client.getOutputStream();
	InputStream recv = client.getInputStream();) {
	// 콘솔 출력
	System.out.println("Client connected IP address =" + client.getRemoteSocketAddress().toString());
	// 메시지 받기 스레드 풀
	ExecutorService receiver = Executors.newSingleThreadExecutor();
	receiver.execute(() -> {
	try {
	// 메시지 무한 대기
	while (true) {
	// 버퍼 생성
	byte[] b = new byte[1024];
	// 메시지를 받는다.
	recv.read(b, 0, b.length);
	// 콘솔 출력
	System.out.println(new String(b));
	}
	} catch (Throwable e) {
	// 에러 콘솔 출력
	e.printStackTrace();
	}
	});
	// 콘솔로 메시지 받기
	try (Scanner sc = new Scanner(System.in)) {
	// 콘솔 메시지 무한 대기
	while (true) {
	// 메시지를 받는다.
	String msg = sc.next() + "\r\n";
	// byte 변환
	byte[] b = msg.getBytes();
	// 서버로 메시지 전송
	send.write(b);
	// exit일 경우 접속 종료
	if ("exit\r\n".equals(msg)) {
	break;
	}
	}
	}
	}
	} catch (Throwable e) {
	// 에러 발생시 콘솔 출력
	e.printStackTrace();
	}


}
}
