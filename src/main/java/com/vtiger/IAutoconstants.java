package com.vtiger;

public interface IAutoconstants {
	
	/**
	 * User.dir will give you the current directory path.
	 * It will give you current project location 
	 */
	String dirpath = System.getProperty("user.dir");
	String profilepath=dirpath+"/Commondata.properties";
	String excelpath=dirpath+"/Exceldata.xlsx";


}
