import java.util.Scanner;

public class Main {
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int N = in.nextInt();
		int sum1 = 0, k = 0;
		int max = 0;
		
		for(int i=0; i<N ; i++) {
			k = in.nextInt();
			sum1 += k;
			if (max < k)	max = k;
		}
		
		int sum2 = N*max - sum1;
		if(sum2 > sum1)
			System.out.println(max);
		else 
			while(true) {
				max++;
				sum2 = N*max - sum1;
				if( sum2 > sum1) {
					System.out.println(max);
					break;		
				}

			}
			
	}
}
