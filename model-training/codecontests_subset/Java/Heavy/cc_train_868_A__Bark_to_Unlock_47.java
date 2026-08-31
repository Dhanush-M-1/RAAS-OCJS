import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;


public class B348 {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
	
	
	Scanner sc= new Scanner(System.in);
	
	String pass= sc.next();
	
	int n=sc.nextInt();
	
	String[]trials= new String[n];
	
	for(int i=0;i<n;i++)
	{
		trials[i]=sc.next();
	
		if(trials[i].equals(pass))
		{
			System.out.println("YES");
			return;
		}
	}

	boolean f=false;
	boolean l=false;
for(int i=0;i<n;i++)
{
	if(trials[i].charAt(1)==pass.charAt(0))
	{
		f=true;
	}
	if(trials[i].charAt(0)==pass.charAt(1))
		l=true;
}
	
	
if(f&&l)	
System.out.println("YES");
else 
	System.out.println("NO");
	
}
}