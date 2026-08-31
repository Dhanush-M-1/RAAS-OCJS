import java.util.Arrays;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			int num=sc.nextInt();
			int[] a=new int[num];
			int index=-1;
			for(int i=0;i<num;i++) {
				a[i]=sc.nextInt();
				if(a[i]>500000&&index==-1) index=i;
			}
			if(index==-1) {
				System.out.println(a[num-1]-1);
			}else {
				if(index!=0) {
					System.out.println((a[index-1]-1)>1000000-a[index]?a[index-1]-1:1000000-a[index]);
				}else {
					System.out.println(1000000-a[index]);
				}
			}
		}
	}
}