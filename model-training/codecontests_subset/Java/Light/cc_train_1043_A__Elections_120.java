import java.util.Scanner;

public class Elections {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), sum = 0, max = 0;
		for(int i = 0; i < n; i++) {
			int r = scan.nextInt();
			sum += r;
			max = Math.max(max,  r);
		}
		max = Math.max(max, sum*2/n + 1);
		System.out.println(max);	
	}

}
