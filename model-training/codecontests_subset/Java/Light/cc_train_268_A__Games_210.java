import java.util.*;
import java.io.*;
import java.math.*;
public class Main
{
    public static void main(String args[])
    {
	    Scanner scan=new Scanner(System.in);
	    int n=scan.nextInt();
	    int a[]=new int[n];
	    int b[]=new int[n];
	    for(int i=0;i<n;i++)
	    {
	        a[i]=scan.nextInt();
	        b[i]=scan.nextInt();
	    }
	    int count=0;
	    for(int i=0;i<n;i++ )
	    {
            for(int j=0;j<n;j++)
            {
                if(i!=j&&a[i]==b[j])
                    count++;
            }
        }
        System.out.println(count);
    }
}