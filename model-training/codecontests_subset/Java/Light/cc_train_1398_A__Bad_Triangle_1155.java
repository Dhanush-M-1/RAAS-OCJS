import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int o = sc.nextInt();
		while(o-->0) {
			int n = sc.nextInt();
			int[] x=new int[n];
			for(int i=0;i<n;i++)
				x[i] = sc.nextInt();
			if(x[0]+x[1]>x[n-1]) {
				System.out.println(-1);
			}else {
				System.out.println("1 2 "+n);
			}
		}
	}
}
