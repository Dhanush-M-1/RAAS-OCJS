
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[] sarray=new int[13];
		int[] harray=new int[13];
		int[] carray=new int[13];
		int[] darray=new int[13];

		for(int i=0; i<n; i++) {
			char ch = sc.next().charAt(0);
			int num = sc.nextInt();
			if(ch=='S') {
				sarray[num-1]=num;
			}else if(ch=='H') {
				harray[num-1]=num;
			}else if(ch=='C') {
				carray[num-1]=num;
			}else if(ch=='D') {
				darray[num-1]=num;
			}
		}
		for(int i=0; i<13; i++) {
			if(sarray[i]==0) {
				System.out.println("S " + (i+1));
			}
		}
		for(int i=0; i<13; i++) {
			if(harray[i]==0) {
				System.out.println("H " + (i+1));
			}
		}
		for(int i=0; i<13; i++) {
			if(carray[i]==0) {
				System.out.println("C " + (i+1));
			}
		}
		for(int i=0; i<13; i++) {
			if(darray[i]==0) {
				System.out.println("D " + (i+1));
			}
		}
	}
}
