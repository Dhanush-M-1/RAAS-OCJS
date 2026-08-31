import java.util.*;
import java.math.*;
import java.io.*;
public class Main
	{
	public static void main(String args[])	throws IOException
		{
		Scanner c=new Scanner(System.in);
		int N=c.nextInt();
		int W=c.nextInt();
		int X=c.nextInt();
		
		for(int ppl=0;ppl<=10000000;ppl++)
			{
			int tot=W+ppl;
			if((double)(tot*100)/N>=X)
				{
				System.out.println(ppl);
				return;
				}
			}
		}
	}

//must declare new classes here