package com.loncoto.factory.project.principal;

import com.loncoto.factory.project.data.CSVDataImporter;
import com.loncoto.factory.project.data.IDataImporter;
import com.loncoto.factory.project.data.xmlDataImporter;

public class DataBuilder {
	public static IDataImporter BuildDataImporter(String filename){
		String extension = filename.substring(filename.lastIndexOf("."));
		
		System.out.println("extension : " + extension);
		
		switch (extension) {
		case ".xml":
			return new xmlDataImporter(filename);
		case ".csv":
			return new CSVDataImporter(filename);
		}
		return null;
	}
}
