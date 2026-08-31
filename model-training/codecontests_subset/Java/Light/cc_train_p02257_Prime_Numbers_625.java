
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] arr = new int[size];
		
		int count = 0;
		for(int i=0; i<size; i++) {
			arr[i] = scanner.nextInt();
		}
		for(int i=0; i<size; i++) {
			if(!isPrime(arr[i])) {
				count++;
			}
		}
		scanner.close();
		
		System.out.println(count);
		
	}

	public static boolean isPrime(int num) {
		for (int i = 2; i <= (int)Math.sqrt(num); i++) {
			if (num % i == 0) {
				return true;
			}
		}
		return false;
	}
}

