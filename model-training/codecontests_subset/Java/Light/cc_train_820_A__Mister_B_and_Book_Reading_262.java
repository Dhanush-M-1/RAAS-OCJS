
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int initialSpeed = sc.nextInt();
		int maxSpeed = sc.nextInt();
		int acceleration = sc.nextInt();
		int reRead = sc.nextInt();
		int read = initialSpeed;
		int count = 1;
		while (read < length) {
			read -= reRead;
			read += Math.min(maxSpeed, initialSpeed + (count * acceleration));
			count++;
		}
		System.out.println(count);
	}

}
