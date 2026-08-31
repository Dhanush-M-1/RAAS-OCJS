import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public final class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int v0 = sc.nextInt();
		int v1 = sc.nextInt();
		int a = sc.nextInt();
		int l = sc.nextInt();
		int i = 0;
		int count = 0;
		int total_read = 0;
		while(true) {
				int today_read =  (v0  +   i++ * a);
				if(today_read >= v1) {
					today_read = v1;
				}
				total_read += today_read;
				count++;
				if(total_read >= c) 
						break;
				else 
					total_read = (total_read - l);
		
		}
		System.out.println(count);
		
	}
}