import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int p = 0, c = 0;
		while(true) {
			if(!br.ready())
				break;
			
			String s = br.readLine();
			if(s.charAt(0) == '+')
				p++;
			else if(s.charAt(0) == '-')
				p--;
			else {
				String[] arr = s.split(":");
				if(arr.length != 1)
					c += p * arr[1].length();
			}
		}
		
		System.out.println(c);
	}
}

