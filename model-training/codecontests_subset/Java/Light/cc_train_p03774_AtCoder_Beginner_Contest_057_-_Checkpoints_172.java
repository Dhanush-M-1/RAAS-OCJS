import java.util.*;

class Main{
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	int[] a = new int[n];
	int[] b = new int[n];
	for(int i = 0; i < n; i++) {
		a[i] = sc.nextInt();
		b[i] = sc.nextInt();
	}
	int[] c = new int[m];
	int[] d = new int[m];
	for(int i = 0; i < m; i++) {
		c[i] = sc.nextInt();
		d[i] = sc.nextInt();
	}
	int tempD = 1000000000;
	int tempP = 0;
	for(int i = 0; i < n; i++) {
		tempD = 1000000000;
		for(int j = 0; j < m; j++) {
			if(Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]) < tempD) {
				tempP = j + 1;
				tempD = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
			}
		}
		System.out.println(tempP);
	}
}
}
