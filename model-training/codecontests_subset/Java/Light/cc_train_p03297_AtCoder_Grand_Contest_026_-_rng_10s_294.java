import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		long a[][]=new long[t][4];

		long gcd;
		long test;
		boolean ans;

		for(int i=0; i<t;i++) {
			for(int j=0;j<4;j++) {
				a[i][j]=sc.nextLong();
			}
		}
		for(int i=0;i<t;i++) {
			if(a[i][0]<a[i][1]||a[i][1]>a[i][3]) {
				ans=false;
			}
			else if(mod(a[i][3], a[i][1])==0) {
				test=mod(a[i][0], a[i][1]);
				ans=true;
				if(test>a[i][2]) {
					ans=false;
				}
			}
			else {
				a[i][0]=mod(a[i][0], a[i][1]);
				a[i][3]=mod(a[i][3], a[i][1]);

				ans=true;
				gcd=saidaikouyakusuu(a[i][3], a[i][1]);
				test=mod(a[i][1], gcd)-gcd;
				if(a[i][1]+test>a[i][2]) {
					ans=false;
				}

				/*
				test=0;
				ans=true;
				do{
					test=mod(test+gcd, a[i][1]);
					if(test<a[i][1]&&test>a[i][2]) {
						ans=false;
					}
				} while(test!=0);*/



			}


			if(ans) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}

	}

	public static long mod(long a,long b) {
		return(a%b);
	}

	public static long saidaikouyakusuu(long x, long y) {
		if(x<y) {
			long swap=x;
			x=y;
			y=swap;
		}
		if(y!=0) {
			long tmp;
	        while ((tmp = x % y) != 0) {
	            x = y;
	            y = tmp;
	        }

		}
		return y;
	}

}
