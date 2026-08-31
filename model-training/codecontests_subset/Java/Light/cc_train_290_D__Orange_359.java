import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder d = new StringBuilder();
		
		String a, e;
		int b;
		
		a = scan.readLine();
		b = Integer.parseInt(scan.readLine());
		
		a = a.toLowerCase();
		e = a.toUpperCase();
		for(int i = 0; i < a.length(); i++)
		{
			char c = a.charAt(i);
			if(c < b+97)
			{
				d.append(e.charAt(i));
			}
			else
			{
				d.append(c);
			}	
		}
		System.out.println(d);
		
	}
}
