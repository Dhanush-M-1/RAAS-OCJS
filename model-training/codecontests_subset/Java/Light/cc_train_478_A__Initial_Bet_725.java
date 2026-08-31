import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class acming {
	public static void main(String [] args) throws java.lang.Exception {
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
	   String [] s = bf.readLine().split(" ");
	   int a = Integer.parseInt(s[0])+Integer.parseInt(s[1])+Integer.parseInt(s[2])+Integer.parseInt(s[3])+
			   Integer.parseInt(s[4]) ;
	   if (a%5==0 && a/5 != 0)
	          System.out.print(a/5);
	   else
		   System.out.print("-1");
}}
		
		
	
