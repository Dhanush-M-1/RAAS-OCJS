import java.util.Arrays;
import java.util.Scanner;

public class cf938b {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int prizes = sc.nextInt();
		
		int[] a = new int[prizes];
		
		for (int i =0 ; i < prizes; i++) {
			
			a[i] = sc.nextInt();
			
		}
		
		Arrays.sort(a);
		
		int min = 1000000;
		
		for (int i =0 ; i < prizes-1; i++) {
			
			min = Math.min(Math.max(a[i]-1, (1000000-a[i+1])), min);
			
		}
		
		min = Math.min(min, a[prizes-1]-1);
		min = Math.min(min, 1000000 - a[0]);
		
		System.out.println(min);
		
	}

}
