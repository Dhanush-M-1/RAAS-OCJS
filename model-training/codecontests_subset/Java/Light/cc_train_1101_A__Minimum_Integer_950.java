//package test;

import java.util.*;

public class CF2 {
	
	public static final long M = 998244353;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		while(q-->0)
		{
			long l = s.nextLong();
			long r = s.nextLong();
			long d = s.nextLong();
			if(d<l)
				System.out.println(d);
			else
			{
				double p = (double)r/(double)d;
				if((p-Math.floor(p))==0)
					System.out.println(r+d);
				else
					System.out.println((long)(Math.ceil(p)*d));
			}
		}
	}
}