import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(f.readLine());
		
		String s = f.readLine();
		
		if(s.length() < 11 || s.indexOf("8") < 0) {
			System.out.println(0);
		} else {
			
			int e = 0;
			
			for(int i = 0; i < n; i++) {
				
				if(s.charAt(i) == '8') {
					e++;
				}
				
			}
			
			System.out.println(Math.min(e, s.length() / 11));
			
		}
		
		f.close();
		
	}
	
}