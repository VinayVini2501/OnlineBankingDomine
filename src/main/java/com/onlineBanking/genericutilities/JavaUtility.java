package com.onlineBanking.genericutilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	/**
	 * it is used to genrate the random number
	 * @return int data
	 */
	public int getRanDomNumber()
	{
		Random random = new Random();
		int Random = random.nextInt(1000);
		return Random;	
	}
	/**
	 * used to get system date & time in IST formet
	 * @return
	 */
	
	public String getSystemDateAndTime()
	{
		Date date = new Date();
		return date.toString();
	}
	
	/**
	 * it is used to get system date in YYYY-MM-DD Format
	 * @return
	 */
	public String  getSystemDateWithFormate()
	{
		Date date = new Date();
		SimpleDateFormat f=new SimpleDateFormat("YYYY-MM-DD");
		String finalFormate=f.format(date);
//		String dateAndTime = date.toString();
//		
//		String YYYY = dateAndTime.split(" ")[5];
//		String DD = dateAndTime.split(" ")[2];
//		int MM = date.getMonth()+1;
//		
//		String finalFormate= YYYY+"-"+MM+"-"+DD;
		return finalFormate;		
	}
	
	public String getSystemDateAndTimeInFormet()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date systemdate = new Date();
		String getDateAndTime = dateformat.format(systemdate);
		System.out.println(getDateAndTime);
		return getDateAndTime.replaceAll(":", "-");
	}

}
