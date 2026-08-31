import java.util.Scanner;

public class Project {
	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		
		int a = (int)Math.ceil((double)y / 100.0 * (double)n);
		System.out.println((a-x)<0?0:(a-x));
	}
}