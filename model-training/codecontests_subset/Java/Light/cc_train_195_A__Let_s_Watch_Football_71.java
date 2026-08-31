import java.util.*;
import java.math.*;
import java.io.*;

public class Main
	{
	public static void main(String args[]) throws IOException
		{
		Scanner c=new Scanner(System.in);
		int A=c.nextInt();
		int B=c.nextInt();
		int C=c.nextInt();
		
		for(int i=1;i<=1000003;i++)
			{
			//data downloaded till end
			if((C+i)*B>=C*A)
				{
				System.out.println(i);
				return;
				}
			}
		}
	}

//must declare new classes here