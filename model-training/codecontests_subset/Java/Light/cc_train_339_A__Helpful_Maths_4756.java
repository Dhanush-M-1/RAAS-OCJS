/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner scan=new Scanner(System.in);
        String s=scan.next();
        int x=0;
        String[] sarr=s.split("\\+");
        int[] arr=new int[sarr.length];
        
        for(String str:sarr){
        int n=Integer.parseInt(str);
        arr[x]=n;
        
    
        x++;
        }
        Arrays.sort(arr);
        for(int i=0; i<sarr.length; i++){
          if(i<(sarr.length-1))  
        System.out.print(arr[i]+"+");
        else
        System.out.print(arr[i]);
        }
	}
}
