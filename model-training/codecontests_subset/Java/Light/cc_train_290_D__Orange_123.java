
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class Orange {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String s = "";
		String[] lineOne = null;
		if ((s = in.readLine()) != null)
			lineOne = s.split("\\s+");
		String[] lineTwo = null;
		if ((s = in.readLine()) != null)
			lineTwo = s.split("\\s+");

		in.close();
		
		String s27 = lineOne[0];
		int i16 = Integer.parseInt(lineTwo[0]);
		s27 = s27.toLowerCase();
		String s4 = "";
		for (int i26 = 0; i26 < s27.length(); i26++) {
			char s19 = s27.charAt(i26);
			if ((int)s19 < i16+97)
				s4 += String.valueOf(s19).toUpperCase();
			else
				s4 += String.valueOf(s19).toLowerCase();
		}
		
		System.out.println(s4);
	}

}
