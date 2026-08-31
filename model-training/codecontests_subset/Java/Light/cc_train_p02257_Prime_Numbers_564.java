import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int sosu=0;
		boolean it;

		for(int i=0; i<count; i++) {
			int y = sc.nextInt();
			it=isprime(y);
			if(it) {
				sosu += 1;
			}
		}
		System.out.println(sosu);
	}
	public static boolean isprime(int num) {
		if (num < 2) return false;
		else if (num == 2) return true;
		else if (num % 2 == 0) return false;

		double sqrtNum = Math.sqrt(num);
		for (int i = 3; i <= sqrtNum; i += 2)
		{
			if (num % i == 0)
			{

				return false;
			}
		}

		return true;

	}
}
