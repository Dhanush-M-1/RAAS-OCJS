import java.util.*;
import java.io.*;

public class A_Keanu_Reeves {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter printr = new PrintWriter(System.out);
		int n=Integer.parseInt(br.readLine());
		String s=br.readLine();
		int pieces;
		if(s.length()%2==1) {
			printr.println("1");
			printr.println(s);
		}
		else {
			int count=0;
			for(int i1=0;i1<s.length();i1++) {
				if(s.charAt(i1)=='0') {
					count++;
				}
			}
			if(count*2!=s.length()) {
				printr.println("1");
				printr.println(s);
			}
			else{
				printr.println("2");
				printr.println(s.substring(0, 1)+" "+s.substring(1));
				
			}
			
		}
		
		printr.close();
		
	}

}
