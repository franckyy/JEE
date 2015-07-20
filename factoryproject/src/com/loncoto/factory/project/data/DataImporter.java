package com.loncoto.factory.project.data;

import java.io.File;
import java.util.Map;

public abstract class DataImporter implements IDataImporter {

	//public abstract Map<String, String> importData();
	
	//fonction "fabrique", celle qui choisira la classe concrete du dataimporter et qui saura comment l'instancier 
	public static DataImporter BuildDataImporter(String filename){
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
