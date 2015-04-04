package com.claudio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MainController {

	private HttpServletRequest req; 
	private HttpServletResponse resp;
	protected String view;
	
	public MainController(String view){
		this.view = view;
	}
	
	protected void setAttribute(String key, Object value){
		if(req!= null){
			req.setAttribute(key, value);
		}
	}
	
	protected void setTitlePage(String title){
		setAttribute("title", title);
	}//fim de setTitlePage
	
	public abstract String getView();

	public void setReq(HttpServletRequest request) {
		// TODO Auto-generated method stub
		req = request;
	}
	public void setResp(HttpServletResponse response) {
		// TODO Auto-generated method stub
		resp = response; 
	}


	
}//fim da classe mainCOntroller
