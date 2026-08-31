import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		int hc = 0;
		String check;
		while((check = sc.readLine()) != null){
			String[] temp = check.split(",");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);
			if(pow(a,2) + pow(b,2) == pow(c,2)){
				tc++;
			}
			if(a == b && (a + b > c || abs(a-b) < c)){
				hc++;
			}
		}
		System.out.println(tc);
		System.out.println(hc);
	}
}