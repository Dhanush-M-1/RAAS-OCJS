import java.io.*;
import java.util.*;
import java.lang.*;

public class Multiplyby2divideby6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		main:
		while (t-- > 0) 
		{
			long n = sc.nextLong();
			long count=0;
			
			while(n!=1)
			{
				if(n%6 == 0)
				{
					n/=6;
					count++;
				}
				else 
				{
					if((n*2)%6 == 0)
					{
						n*=2;
						count++;
					}
					else 
					{
						System.out.println(-1);
						continue main;
					}
				}
			}
			System.out.println(count);
		}
	}
}
