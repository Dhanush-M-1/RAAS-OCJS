import java.util.*;
import java.lang.*;

public class helpfulMaths {
    
   
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    String str=sc.next();
	    char ch[]=str.toCharArray();
	    Arrays.sort(ch);
	    for(int i=0;i<str.length();i++)
	    {
	        if(ch[i]!='+'){
	         System.out.print(ch[i]);
	         if(i!=str.length()-1)
	          System.out.print("+");
	        }
	        
	    }
	   
	//code
	}
}