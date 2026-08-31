//package jan19;
import java.util.*;
import java.lang.*;
import java.io.*;


public class Round58P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int q=scn.nextInt();
		while(q-->0)
		{
			long l=scn.nextLong();
			long r=scn.nextLong();
			long d=scn.nextLong();
			if(d<l)
			{
				System.out.println(d);
			}
			else
			{
				long x=r/d;
				System.out.println((x+1)*d);
			}
		}

	}

}
