import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {

	public static void main(String[] args)throws java.lang.Exception
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine()),a=0,b=0,c=0,d=0;
		while(n-->0) {
			String s=br.readLine();
			if(s.equals("AC")) ++a;
			else if(s.equals("WA")) ++b;
			else if(s.equals("TLE")) ++c;
			else ++d;
		}
		System.out.println("AC"+" x "+a+"\n"+"WA"+" x "+b+"\n"+
						"TLE"+" x "+c+"\n"+"RE"+" x "+d+"\n");

	}

}