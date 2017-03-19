package br.com.eicon.teste.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
	
	public static Date limparHoraMin(Date data){
		//Seta a hora inicial  
		Calendar inicial = Calendar.getInstance(); 
		inicial.setTime(data);
		inicial.set(Calendar.HOUR_OF_DAY, 0);  
		inicial.set(Calendar.MINUTE, 0);
		inicial.set(Calendar.SECOND, 0);
		inicial.set(Calendar.MILLISECOND, 0);
		return inicial.getTime();
	}

	public static Date converterStringParaDate(String data){
		DateFormat formatter = null;
		
		if(data.contains("/")){
			formatter = new SimpleDateFormat("dd/MM/yyyy");
		}else{
			formatter = new SimpleDateFormat("dd-MM-yyyy");
		}
		
		
		Date date = null;
		try {
			date = Util.limparHoraMin((Date)formatter.parse(data));	
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String converterDateParaString(Date data){
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data).toString();
	}
}
