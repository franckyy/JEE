package com.loncoto.webCustomTag.utils;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		PageContext pc = (PageContext)getJspContext();
		
		JspWriter writer = pc.getOut();
		
		writer.println("<h3>Bonjour, nous sommes le " + new Date() + "</h3>");
	}

	
}
