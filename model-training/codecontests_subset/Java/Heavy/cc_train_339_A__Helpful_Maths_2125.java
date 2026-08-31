/* package whatever; // don't place package name! */
import java.util.regex.*;  
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.replace("+","@");
        String[] a = s.split("@");
        int x = a.length;
        int[] b = new int[x];
        for(int i = 0; i < x; i++)
        {
            b[i] = Integer.parseInt(a[i]);
        }
        Arrays.sort(b);
        for(int i = 0; i < x; i++)
        {
            System.out.print(b[i]);
            if(i != x-1)
            System.out.print("+");
        }
	}
}