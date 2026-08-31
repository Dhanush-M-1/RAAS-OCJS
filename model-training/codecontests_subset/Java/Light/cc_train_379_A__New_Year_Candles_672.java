import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import javax.management.openmbean.ArrayType;

public class main 
{


	public static void main(String[] args) throws IOException
	{ 
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = 0;
		int answer=0;
		while(a>0)
		{
			answer+=a;
			c+=a;
			a=c/b;
			c-=a*b;
		}
		System.out.println(answer);
	}
		

}