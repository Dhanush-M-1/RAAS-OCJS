/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		String s=scan.next();
		Map fr=new HashMap();
		String res="";
		int max=0;
		for(int i=0;i<n-1;i++){
			String t=s.substring(i,i+2);
			if(!fr.containsKey(t)){
				fr.put(t,1);
			}
			else{
				int count=(int)fr.get(t);
				fr.put(t,count+1);
			}
			int x=(int)fr.get(t);
			if(x>max){
				max=x;
				res=t;
			}
			
		}
		System.out.println(res);
	}
}