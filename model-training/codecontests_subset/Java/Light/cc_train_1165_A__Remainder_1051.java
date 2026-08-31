import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		char[] arr = sc.next().toCharArray();
		int counter = n-1;
		int res =0;
//		int onesCount = 0;
//		for (int i=0;i<n;i++) {
//			if (arr[i]=='1')
//				onesCount ++;
//		}
		for (int i=0;i<x;i++) {
			char cur = arr[counter];
//			if (i==x) {
//				if (cur!='1') {
//					res++;
//					onesCount--;
//				}
//			}
//			else
			if(i==y) {
				if (cur!='1') {
					res++;
				}
			}
			else {
				if (cur!='0') {
					res++;
				}
			}
			counter--;
		}
		System.out.print(res);
	}
}
