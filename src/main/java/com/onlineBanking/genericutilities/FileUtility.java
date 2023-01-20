package com.onlineBanking.genericutilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility
{
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstantants.Filepath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
		
	}
	

}
