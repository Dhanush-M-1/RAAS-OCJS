import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int pnum = 0;
		int a[] = new int[n];
		int b[] = new int[n];
		int c[] = new int[n-1];
		int sum = 0;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		for(int i = 0; i < n-1; i++) {
			c[i] = sc.nextInt();
		}

		for(int i = 0; i < n; i++) {
			if(pnum != 0) {
				if((pnum+1) == a[i])
					sum += c[pnum-1];
			}
			int num = a[i];
			sum += b[num-1];
			pnum = num;
			//System.out.println(sum);
		}
		System.out.println(sum);
	}


}
