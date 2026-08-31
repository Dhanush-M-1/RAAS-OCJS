/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.lang.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int mod= 1000000000;
	    mod+=7;
	    long fact=1;
	    long pow=1;
	    
	    for(int x=n;x>1;x--)
	    {
	        fact=(fact*x)%mod;
	        pow= (pow*2)%mod;
	    }
	    long ans=fact-pow;
	     if(ans<0l)
	    {
	        ans+=mod;
	    }
	    System.out.println(ans);
	    
	//	System.out.println(mod);
	}
}
