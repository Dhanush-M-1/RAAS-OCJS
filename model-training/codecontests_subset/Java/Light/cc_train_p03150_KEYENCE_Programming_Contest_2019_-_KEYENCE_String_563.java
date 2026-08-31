import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	 static Scanner in = new Scanner(System.in);
	 
   
	public static void main(String args[])throws IOException  {
   
    	
        String s=in.nextLine(); 
        int len1=s.length();
        String s1=s;
        String str="keyence";
        int len=str.length();
        int pos=s.indexOf(str);
        if(pos!=-1&&(pos==0||pos==len1-len))
        {
    		System.out.println("YES");
    		return ;
    	}
        int t=len1-len;
        for(int i=1;i<len1-t;i++)
        {
        	s=s.substring(0,i)+s.substring(i+t,len1);
        	if(s.equals(str))
        	{
        		System.out.println("YES");
        		return ;
        	}
        	s=s1;
        }
    		System.out.println("NO");	
     	
    }

	
	
 
	
}