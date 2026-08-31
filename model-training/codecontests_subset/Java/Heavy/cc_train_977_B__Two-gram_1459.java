/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	Scanner sc;
	PrintWriter pw;
     
  	public Ideone(){
		sc = new Scanner(System.in);
      
		int s = sc.nextInt();
		String text = sc.next();

		String res = "";
		int max = 0;
		for(int i = 0; i < text.length()-1; i++){
			String now = text.charAt(i) +""+ text.charAt(i+1);
			int count = 1;
			for(int j = i+1; j < text.length() -1; j++){
				String forCheck = text.charAt(j) +""+ text.charAt(j+1);
				if(forCheck.equals(now)){
					count++;
				}
			}
			if(max < count){
				max = count;
				res = now;
			}
		}
	
		System.out.println(res);

	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		new Ideone();
	}
}