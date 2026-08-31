import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = input.nextInt();
		}
		
		System.out.println(total(arr));
		input.close();
	}
	public static boolean prime(int x) {
		for(int i = 2; i <= (int) Math.sqrt(x); ++i) {
            if(x % i == 0) {
                return false;
            }
        }
		return true;
	}
	
	public static int total(int[] arr) {
		int total = 0;
		for(int i = 0; i < arr.length; i++) {
			if(prime(arr[i])) {
				total++;
			}
		}
		return total;
	}
	
}
