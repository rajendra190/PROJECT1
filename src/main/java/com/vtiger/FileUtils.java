package com.vtiger;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtils {

	public String Readdatafromprop(String key) throws Throwable {

		FileInputStream fis = new FileInputStream(IAutoconstants.profilepath);
		Properties Prop = new Properties();
		Prop.load(fis);

		return Prop.getProperty(key);
	}






}
