//package A;

import java.util.Scanner;

public class p820A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int v0 = sc.nextInt();
		int v1 = sc.nextInt();
		int a = sc.nextInt();
		int l = sc.nextInt();
		int count = 0;
		int daycount = 0;
		while( count < c) {
			//System.out.println("v0 is "+ v0+" and a is "+a);
			if(count > 0) {
				count -= l;
				v0 += a;
				if (v0 > v1) {
					v0 = v1;
				}
				//v0+=a<v1?v0:v1;				
			}
			count += v0;
			daycount +=1;
			
		}
		System.out.println(daycount);
	}
}
