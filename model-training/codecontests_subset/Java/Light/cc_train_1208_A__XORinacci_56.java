
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		for (int i = 0; i<c; i++) {
			String s = br.readLine();
			  String sf[]=s.split(" ");
		        int a=Integer.parseInt(sf[0]);
		        int b=Integer.parseInt(sf[1]);
		        int n=Integer.parseInt(sf[2]);
		        if (n%3==0) {
		        	System.out.println(a);
		        	continue;
		        }
		        if (n%3==1) {
		        	System.out.println(b);
		        	continue;
		        }
		        else
		        {
		        	System.out.println(a^b);
		        }
		}
	}
}
