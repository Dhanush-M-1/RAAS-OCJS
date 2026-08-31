
import java.io.*;
import java.util.*;
public class GFG {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int c=0;
	    String ch=sc.next();
	    for(int i=0;i<n;i++)
	    {
	        if(ch.charAt(i)=='0')
	            c++;
	        else
	            c--;
	    }
	    if(c!=0)
	        System.out.println("1 \n"+ch);
	   else
	        System.out.println("2 \n"+ch.substring(0,1)+" "+ch.substring(1));
	}
}