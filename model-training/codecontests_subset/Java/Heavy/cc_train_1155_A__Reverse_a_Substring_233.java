/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes 
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.next();
		char[] ch=s.toCharArray();
		
		boolean poss = false;

        for(int i=1; i<n; i++)
        {
            if(ch[i]<ch[i-1])
            {
                System.out.println("YES");
                System.out.println(i+" "+(i+1));
                poss = true;
                break;
            }
        }

        if(!poss)
            System.out.println("NO");
        
    }
}