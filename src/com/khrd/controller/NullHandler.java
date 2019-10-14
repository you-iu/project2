package com.khrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 error 발생
		return null;
	}

}
