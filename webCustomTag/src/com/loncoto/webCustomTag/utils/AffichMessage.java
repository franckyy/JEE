package com.loncoto.webCustomTag.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AffichMessage extends SimpleTagSupport {
	private String message;
	private String bold;

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		PageContext pc = (PageContext)getJspContext();
		JspWriter writer = pc.getOut();
		
		ServletRequest req = pc.getRequest();
		
		List data = (List) req.getAttribute(message);
		boolean bool = Boolean.parseBoolean(bold);
		if(bool){
			System.out.println("true !");
		} else {
			System.out.println("false !!!");
		}
		String affich = (Boolean.parseBoolean(bold))? "<p><b>" + message + "</b></p>" : "<p>" + message + "</p>";
		writer.println(affich);
	}

	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}

	public String getBold() {return bold;}
	public void setBold(String bold) {this.bold = bold;}
}
