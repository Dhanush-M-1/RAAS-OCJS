import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class Orange {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		String s = in.readLine();
		int num = Integer.parseInt(in.readLine());
		char c ;
		char ch ;
		for(int i=0;i<s.length();i++){
			ch = Character.toLowerCase(s.charAt(i));
			int temp =ch-'a';
			if(temp<num){
				c=  (char) (ch-('a'-'A'));
				out.print(c);
			}	
			else{
				c = Character.toLowerCase(ch);
				out.print(c);
			}	
		}
		out.close();
	}
}
