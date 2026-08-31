import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
     public static String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    } 
	public static void main(String[] args) throws java.lang.Exception{
	     Scanner sc=new Scanner(System.in);
	     int k=sc.nextInt();
	     String str=sc.next();
	    String res=sortString(str);
	    char c[]=res.toCharArray();
	    int count=0;
	    char ch=0;
	    for(int  i=0;i<res.length();i++) {
	        if(i%k==0) {
	            ch=c[i];
	        }
	        if(c[i]==ch)
	        count++;
	    }
	    if(count==res.length() && count%k==0) {
	        for(int i=0;i<k;i++) {
	            for(int l=0;l<res.length();l+=k) {
	                System.out.print(c[l]);
	            }
	        }
	    }
	    else 
	    System.out.println(-1);
	}
}