package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class Controller extends HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String sep="/main/";
	String page="section.jsp";
	String uri=request.getRequestURI();
	System.out.println(uri);
	String[] uris=uri.substring(1).split("/");
	
	for(String s:uris) System.out.println(s);
	
	if(uris.length<2) {
		if(uris[0].equals("") || uris[0].equals("index")) {
			sep="/main/";
			page="section.jsp";
		}
	}else if(uris.length<3) {
		
	}
	request.setAttribute("page",sep+page);
	request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	
}
}
