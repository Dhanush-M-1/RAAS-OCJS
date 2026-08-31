import java.util.Scanner;

class Main {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[] array = new int[num];
		int count = 0;

		for (int i = 0; i < num; i++) {
			array[i] = scan.nextInt();
			if(isprime(array[i])) {
				count+=1;
			}
		}
		System.out.println(count);

		scan.close();
	}

	private static boolean isprime(int x) {
		if (x == 2) {
			return true;
		}

		if (x < 2 || x % 2 == 0) {
			return false;
		}
		int i = 3;
		while (i <= Math.sqrt(x)) {
			if (x % i == 0) {
				return false;
			}
			i += 2;
		}
		return true;
	}

}
