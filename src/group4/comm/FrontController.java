package group4.comm;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns = {"*.do"}
			,initParams = {@WebInitParam(name="init", value="WEB-INF/prop.properties")} )
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request,response);
	}
	
	  private Map<String, Action> hm=Collections.synchronizedMap(new HashMap<String, Action>());
	  
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String param=config.getInitParameter("init");
		String realpath=config.getServletContext().getRealPath(param);
		
		Properties prop=new Properties();
		try {
			prop.load(new FileReader(realpath));
			Iterator ita=prop.keySet().iterator();
			while(ita.hasNext()) {
				String key=(String)ita.next();
				String value=(String)prop.get(key);
				Class c=Class.forName(value);
				Action act=(Action)c.newInstance();
				hm.put(key, act);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		Action act=hm.get(path);
		
		Forward f=act.execute(request, response);
		if(f.isForward())
		{
			RequestDispatcher disp=request.getRequestDispatcher(f.getPath());
			disp.forward(request, response);
		}else
			response.sendRedirect(f.getPath());
	}

}