import java.util.Scanner;

public class CR168A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		double needPeople = n * (y / 100.0);
		int shortage =  Math.ceil(needPeople - x) > 0 ? (int)Math.ceil(needPeople - x) : 0;
		
		System.out.println(shortage);
		
		scanner.close();
	}

}
