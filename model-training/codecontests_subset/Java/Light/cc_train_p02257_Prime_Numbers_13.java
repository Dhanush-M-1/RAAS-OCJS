import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] array = new long[n];
		int count=0;

		for(int i=0;i<n;i++) {
			array[i] = sc.nextLong();
		}

		for(long buff:array) {
			if(judge(buff)) count++;
		}
		System.out.println(count);

	}

	public static boolean judge(long input) {
		if(input == 2) {
			return true;
		}
		if(input <= 1 || input%2 ==0) {
			return false;
		}

		for(int i=3;i<=Math.sqrt(input);i+=2) {
			if(input % i == 0) return false;
		}
		return true;
	}
}

