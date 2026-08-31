import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[m];
		int[] d = new int[m];
		for(int i = 0;i < n;i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for(int i = 0;i < m;i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		int min,num;
		for(int i = 0;i < n;i++) {
			int x = a[i] - c[0];
			int y = b[i] - d[0];
			if(x<0) {
				x = x * -1;
			}
			if(y<0) {
				y = y * -1;
			}
			min = x + y;
			num=1;
			int z = 0;
			for(int k = 1;k < m;k++) {
				x = a[i] - c[k];
				y = b[i] - d[k];
				if(x<0) {
					x = x * -1;
				}
				if(y<0) {
					y = y * -1;
				}
				z = x +y ;
				if(min > z) {
					min = z;
					num = k+1;
				}
			}
			System.out.println(num);
		}
	}

}