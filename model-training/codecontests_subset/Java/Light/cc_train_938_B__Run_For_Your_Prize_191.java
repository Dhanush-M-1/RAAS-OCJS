import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int temp;
		int max1 = 0, max2 = 0;
		for(int i = 0; i < n; i++) {
			if((temp = sc.nextInt()) > (1e6)/2) {
				max2 = Math.max(max2, (int)1e6 - temp);
			}else max1 = Math.max(max1, temp - 1); 
		}
		
		
		System.out.println(Math.max(max1, max2));
		
		
	}
}
