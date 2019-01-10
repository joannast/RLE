package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dekodowanie {

	String kod;
 
	
	public static String dekoduj (String kod) {
		StringBuilder tekst = new StringBuilder();
		Pattern pattern = Pattern.compile("[a-zA-Z0-9][0-9]*[\\,]");
		Matcher matcher=pattern.matcher(kod);
		System.out.println(kod);
		while(matcher.find()) {

            String mg = matcher.group(0);
            int dlBezPrzecinka = mg.length()-1;
            tekst.append(mg.substring(0, 1));
            
            if(dlBezPrzecinka>1) {
            		int wart = Integer.valueOf(mg.substring(1, dlBezPrzecinka));
            		for (int i=0; i<wart-1;i++) {tekst.append(mg.substring(0, 1));};
            }
           
		}
		
		return tekst.toString();
	}
	
	
	
	
}
