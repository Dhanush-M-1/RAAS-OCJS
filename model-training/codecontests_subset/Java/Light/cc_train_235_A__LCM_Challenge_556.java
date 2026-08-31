import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.*;
public class Main
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long n=sc.nextInt();
		long ans=0;
		if(n<3){
			System.out.println(n);
		}
		else if(n==3){
			System.out.println("6");
		}
		else{
			if(n%2==0){
            	if(n%3==0)
                	ans=(n-1)*(n-2)*(n-3);
            	else
                	ans=n*(n-1)*(n-3);
        	}
        	else
            	ans=n*(n-1)*(n-2);
            System.out.println(ans);
		}
		
	}
}