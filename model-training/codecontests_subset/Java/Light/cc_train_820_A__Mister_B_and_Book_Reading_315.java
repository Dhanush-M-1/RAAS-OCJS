import java.util.Scanner;

public class A820 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int pages = scanner.nextInt();
		int initialSpeed = scanner.nextInt();
		int limit = scanner.nextInt();
		int speed = 0;
		int acceleration = scanner.nextInt();
		int extra = scanner.nextInt();
		int result = initialSpeed;
		int day = 1;
		while(result < pages) {
			speed = acceleration * day + initialSpeed;
			speed = Math.min(speed, limit);
			result += speed - extra;
			day++;
		}
		
		System.out.print(day);
	}
}
