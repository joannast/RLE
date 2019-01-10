package application;

public class Kodowanie {
	

	static int licznik;
    String tekst;
    
	public static String koduj (String tekst) {
		StringBuilder kod = new StringBuilder();
		for (int i = 0; i<tekst.length(); i++) {
			int licznik=1;
			while (i+1<tekst.length()&&tekst.charAt(i)==tekst.charAt(i+1)) {licznik++;i++;}
			
			kod.append(tekst.charAt(i));
			kod.append(licznik +",");
			
			}
		
		return kod.toString();
	}
	


}
