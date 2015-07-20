package com.loncoto.factory.project.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CSVDataImporter extends DataImporter {

	private File csvFile;
	public CSVDataImporter (String filename){
		csvFile = new File(filename);
	}
	
	@Override
	public Map<String, String> importData() {
		HashMap<String, String> data = new HashMap<String, String>();
		try {
			Scanner reader = new Scanner(csvFile);
			
			while(reader.hasNext()){
				String champs[] = reader.nextLine().split(";");
				data.put(champs[0], champs[1]);
			}
		} catch (FileNotFoundException e) {e.printStackTrace();}
		
		return data;
	}

}
