package com.loncoto.factory.project.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xmlDataImporter extends DataImporter {

	private File xmlFile;
	
	public xmlDataImporter(String filename) {
		xmlFile = new File(filename);
	}
	
	@Override
	public Map<String, String> importData() {
		HashMap<String, String> data = new HashMap<String, String>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFile);
			NodeList nl = doc.getElementsByTagName("entry");
			
			for(int i = 0; i < nl.getLength(); i++) {
				Element el = (Element)nl.item(i);
				
				data.put(el.getAttribute("cle"), el.getAttribute("valeur"));
			}
		}
		catch (ParserConfigurationException e) {e.printStackTrace();} 
		catch (SAXException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}

		return data;
	}

}
