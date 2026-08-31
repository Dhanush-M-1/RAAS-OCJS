/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();int k = 0; int g = 0;
        int x = 2*n;
        int[] a = new int[2*n];
        for(int i = 0; i < 2*n; i++)
        {
            a[i] = in.nextInt();
        }
        for(int i = 0; i < x; i = i + 2)
        {
            for(int j = 1; j < x; j = j + 2)
            {
                if(a[i] == a[j])
                g++;
            }
            //k = k + 2;
        }
        System.out.println(g);
	}
}