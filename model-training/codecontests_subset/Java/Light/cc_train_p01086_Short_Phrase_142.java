

import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while(true) {
			n=sc.nextInt();
			if(n==0)break;
			int ans[] = new int[n];
			String test;

			for(int i=0;i<n;i++) {
				test  = sc.next();
				ans[i] = test.length();
			}

			boolean flag[] = new boolean[5];


			for(int i=0;i<n;i++) {
				int f1=0,f2=0,f3=0,f4=0,f5=0;
				int ansdata = 0;

				while(ansdata<=5) {
					ansdata += ans[i+f1];
					f1++;
					if(ansdata==5) {
						flag[0]=true;
						break;
					}
				}

				ansdata=0;
				while(ansdata<=7) {
					ansdata += ans[i+f1+f2];
					f2++;
					if(ansdata==7) {
						flag[1]=true;
						break;
					}
				}

				ansdata =0;
				while(ansdata<=5) {
					ansdata += ans[i+f1+f2+f3];
					f3++;
					if(ansdata==5) {
						flag[2]=true;
						break;
					}
				}


				ansdata=0;
				while(ansdata<=7) {
					ansdata += ans[i+f1+f2+f3+f4];
					f4++;
					if(ansdata==7) {
						flag[3]=true;
						break;
					}
				}


				ansdata=0;
				while(ansdata<=7) {
					ansdata += ans[i+f1+f2+f3+f4+f5];
					f5++;
					if(ansdata==7) {
						flag[4]=true;
						break;
					}
				}




				if(flag[0]&&flag[1]&&flag[2]&&flag[3]&&flag[4]) {
					System.out.println((i+1));
					for(int j=0;j<5;j++)flag[j]= false;
					f1=0;f2=0;f3=0;f4=0;f5=0;
					break;
				}else {
					for(int j=0;j<5;j++)flag[j]= false;
					f1=0;f2=0;f3=0;f4=0;f5=0;
				}


			}




		}

		sc.close();
	}
}
