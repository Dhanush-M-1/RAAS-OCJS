//package EducationalCodeforcesRound33;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n,a,b,s,temp,f=0,t;
		n=scanner.nextInt();
		s=3;
		a=1;
		b=2;
		
		for(int i=0;i<n;i++)
		{
			temp=scanner.nextInt();
			if(temp==s)
				f=1;
			else
			{
				if(temp==a)
				{
					t=s;
					s=b;
					b=t;
				}
				else
				{
					t=s;
					s=a;
					a=t;
				}
			}
		}
		if(f==1)
			System.out.println("NO");
		else
			System.out.println("YES");
		
	}

}
