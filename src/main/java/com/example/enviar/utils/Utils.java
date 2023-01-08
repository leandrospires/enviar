package com.example.enviar.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static String daHoraLog() {
		
		Date data = new Date();
		
		SimpleDateFormat fmt = new SimpleDateFormat("[dd-MM-yyyy hh:mm:ss] - ");
		
		String dtFmt = fmt.format(data);
		
		return dtFmt;
	}
}