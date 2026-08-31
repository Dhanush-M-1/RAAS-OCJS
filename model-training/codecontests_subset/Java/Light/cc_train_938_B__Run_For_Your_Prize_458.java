import java.util.Scanner;

public class Main {

	private static int[] input = new int[100010];
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int i;
		for (i = 0;i < n;i ++) {
			input[i] = scan.nextInt();		
		}
		int ans = Math.min(input[n - 1] - 1 , 1000000 - input[0]);
		for (i = 0;i < n - 1;i ++) {
			int value1 = input[i] - 1;
			int value2 = 1000000 - input[i + 1];
			int temp = Math.max(value1 , value2);
			if (temp < ans) {
				ans = temp;
			}
		}
		System.out.println(ans);
		
	}
	
    
}











 