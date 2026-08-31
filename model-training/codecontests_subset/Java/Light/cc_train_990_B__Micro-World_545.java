import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		int countRemoved = 0;
		int countMightRemove = 0;
		int i;
		Random r = new Random();
		int index;
		
		for(i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		// shuffle
		for (i = n - 1; i > 0; i--) {
			index = r.nextInt(i + 1);
			if(i == index) 
				continue;
			a[i] = a[i] ^ a[index];
			a[index] = a[i] ^ a[index];
			a[i] = a[i] ^ a[index];
		}
		
		Arrays.sort(a);
		
		for (i = 1; i < n; i++) {
			
			if(a[i] == a[i-1]) {
				countMightRemove++;
				continue;
			}
			if(i > 1 && a[i] <= a[i-1] + k && a[i-1] == a[i-2]) {
				countRemoved += 1 + countMightRemove;
				countMightRemove = 0;
				continue;
			}
			if(a[i] <= a[i-1] + k) {
				countRemoved += 1;
				countMightRemove = 0;
				continue;
			}
			countMightRemove = 0;
		}
		
		int result = n - countRemoved;
		
		System.out.println(result);
		
	}

}
