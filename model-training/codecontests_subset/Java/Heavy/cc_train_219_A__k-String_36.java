import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		String s = sc.next();
		
		
		int a[] = new int[26];
		for(int i=0;i<s.length();i++){
		    a[s.charAt(i)-'a']++;
		}
		
		String x = "";
		int flag = 0;
		for(int i=0;i<26;i++){
		    if(a[i]%k != 0){
		        System.out.println("-1");
		        flag=1;
		        break;
		    }
		    
		    int t = a[i]/k;
		    for(int j=1;j<=t;j++){
		        x =x + (char)(i+'a');
		    }
		}
		
		if(flag==0){
		    for(int i=1;i<=k;i++){
		        System.out.print(x);
		    }
		    
		    System.out.println();
		}
	}
}
