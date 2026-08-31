import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;

public class KeanuReeves {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		int len = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int zeros = 0;
		int ones = 0;
		
		if(len%2==1) {
			out.println(1);
			out.print(str);
		}
		else {
			for(int i=0; i<len; i++) {
				if(str.charAt(i)=='0')
					zeros++;
				else
					ones++;
			}
			if(zeros!=ones) {
				out.println(1);
				out.print(str);	
			}
			else {
				out.println(2);
				out.print(str.substring(0, 1)+ " " + str.substring(1, len));
			}
			
		}
		out.flush();
		
		
	}
}
