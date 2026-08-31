import java.util.Scanner;

public class A30 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] a = new int[5];
		int max = -1;
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
			max = Math.max(max, a[i]);
		}

		int sum=0;
		boolean exist = false;
		for (int i = 0; i <= max; i++) {
			sum = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j] >= i)
					sum += a[j] - i;
				else
					sum -= i - a[j];
			}
			if(sum==0) {
				exist = true;
				sum=i;
				break;}
		}
		
		if(exist && max>0)
			System.out.println(sum);
		else
			System.out.println(-1);
		
	}
}
