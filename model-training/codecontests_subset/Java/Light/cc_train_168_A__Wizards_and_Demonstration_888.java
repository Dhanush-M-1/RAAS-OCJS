import java.util.Scanner;

public class A_168_Wizards_and_Demonstration {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = sc.nextInt();
		double x = sc.nextInt();
		double y = sc.nextInt();
		int clone = (int) (Math.ceil((n * y) / 100) - x);
		if (clone > 0)
			System.out.println(clone);
		else
			System.out.println(0);
	}
}
