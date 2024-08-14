package com.ninza.hrm.api.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	
	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./config_envdata/config_envdata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		
		return data;
	}

}
