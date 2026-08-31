

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1 {

	public static void main(String []args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();
			
		//String input = "1000 352 146";
		
		String[] data = input.split(" ");
		int n = Integer.parseInt(data[0]);
		int x = Integer.parseInt(data[1]);
		int y = Integer.parseInt(data[2]);
		double r = (y/100.0) * n;
			
		System.out.println((Math.ceil(r) - x) > 0 ? (int)(Math.ceil(r) - x) : 0 );
	}
}
