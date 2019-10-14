package com.khrd.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ControllerUsingURI extends HttpServlet {
	private HashMap<String, CommandHandler> commandHandlerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		//configFile =/WEB-INF/commandHandler.properties
		String configFile = getInitParameter("configFile");
		//properties파일의 절대 주소를 가져옴
		String configFilePath = getServletContext().getRealPath(configFile);
		
		Properties prop = new Properties();
		//properties 파일안의 내용을 읽어들임
		try (FileReader fis = new FileReader(configFilePath)){
			 prop.load(fis);//다음
		} catch (Exception e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String command = (String) keyIter.next();
			//handlerClassName = com.khrd.handler.SimpleHandler
			String handlerclassName = prop.getProperty(command);
			try {
				// handler = new SimpleHandler();
				Class<?> handlerClass = Class.forName(handlerclassName);
				CommandHandler handlerInstance = (CommandHandler)handlerClass.newInstance();
				commandHandlerMap.put(command, handlerInstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI();
		if(command.indexOf(request.getContextPath())==0) {
			// request.getContextPath(): /chapter18
			command = command.substring(request.getContextPath().length());
			//command = /simple.do
		}
		CommandHandler handler = commandHandlerMap.get(command);
		if(handler == null) {
			handler = new NullHandler();
		}
		String viewPage = null;// 화면에 보일 jsp파일
		try {
			viewPage = handler.process(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		if(viewPage != null) {//forward 처리
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
			
}
