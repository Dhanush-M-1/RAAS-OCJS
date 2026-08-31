//package CodeForces;

import java.util.Scanner;

public class Stones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			int c=s.nextInt();
			int count=0;
			int temp=c/2;
			if(b>=temp)
			{
				b=b-temp;
				count=count+temp*3;
			}
			else
			{
				count=count+(b)*3;
				b=0;
			}
			temp=b/2;
			if(a>=temp)
			{
				a=a-temp;
				count=count+temp*3;
			}
			else
			{
				count=count+a*3;
				a=0;
			}
			System.out.println(count);
			t--;
		}

	}

}
