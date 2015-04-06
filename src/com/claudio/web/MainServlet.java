
package com.claudio.web;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.claudio.bean.Chord;
import com.claudio.business.Chords;
import com.claudio.controller.CifraController;
import com.claudio.controller.IndexController;
import com.claudio.controller.MainController;
import com.claudio.dao.ChordDAO;

public class MainServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		processRequest(req, resp);
	}//fim de doGet

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		processRequest(req, resp);
	}//fim de doPost
	
	//responsavel por executar dPost e doGet
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
		MainController instance = null;
		Class<?> classe = null;
		Method method = null;
		
		String[] url= urlBreaker(req);
		
		String className = null;
		String methodName = null;
		int lengthParam = 0;
		String []urlParameters;
		
		if (url.length > 2 ){lengthParam = url.length-2;}
		urlParameters = new String[lengthParam];
		
		switch (url.length) {
		case 5:
			urlParameters[2] = req.getParameter(url[4]);
		case 4:
			urlParameters[1] = req.getParameter(url[3]);
		case 3:
			urlParameters[0] = req.getParameter(url[2]);
		case 2:
			methodName = url[1];
		default:
			if(url[0].length()>2){
				className = "com.claudio.controller."+url[0]+"Controller";
			}//fim do if
			else{
				instance = new IndexController();
;			}//fim do else
			break;
		}//fim do switch
		
		
		try {
			if(instance == null){
				classe = Class.forName(className);
				instance = (MainController) classe.newInstance();
			}//fim do if
			instance.setReq(req);
			instance.setResp(resp);
			
			if(methodName != null){
				Class[] parameter = geraParametros(lengthParam);
				method = classe.getDeclaredMethod(methodName, parameter);
				method.invoke(instance,urlParameters);
			}//fim do if
			

			RequestDispatcher rd ;
			rd = req.getRequestDispatcher("/"+instance.getView()+".jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*try {
			CifraController cc = new CifraController();
			cc.setReq(req);
			cc.setResp(resp);
			cc.testa();
			Chords ch = new Chords();
			List<Chord> chords = ch.chordList();
			String result = "<form action='action_page.php'>";
			result += "<select name='cars'>";
			for (int i = 0; i < chords.size(); i++) {
				result += "<option value='"+chords.get(i).getChord_letter()+"'>"+chords.get(i).getChord_letter()+"</option>";
				//result +=i;
			}//fim do for

			result +=  "</select>";
			result += "<br><br>";
			result += "<input type='submit'>";
			result += "</form>";
			req.setAttribute("letter", result);
			//fim do for
			//Chord chord = dao.getChord(4);
			//resp.getOutputStream().print(result);
			
			RequestDispatcher rd ;
			rd = req.getRequestDispatcher("/main.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}//fim de processRequest
	
	private String[] urlBreaker(HttpServletRequest req){
		String url = req.getRequestURI();
		url = url.replace(".do", "");
		String[] urlSplit = url.split("/");
		String[] result = new String[urlSplit.length - 2];
		for (int i = 2; i < urlSplit.length; i++) {
			result[i - 2] = urlSplit[i];
		}// fim do for
		return result;
	}//fim de urlBreaker
	
	public Class[] geraParametros(int valor){
		Class[] result = new Class[valor];
		for (int i = 0; i < valor; i++) {
			result[i] = String.class;
		}
		return result;
	}//fim de geraParametros
	
}//fim da classe MainServlet
