import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int inA = in.nextInt();
	int inB = in.nextInt();
	int inC = in.nextInt();
	while (inA != -1 || inB != -1 || inC != -1) {
	 int s = inA * 3600 + inB * 60 + inC;
	 int a = 2 * 3600 - s;
	 int b = a * 3;
	 System.out.format("%02d:%02d:%02d", a / 3600,
		 (a % 3600) / 60, a % 60);
	 System.out.println();
	 System.out.format("%02d:%02d:%02d", b / 3600,
		 (b % 3600) / 60, b % 60);
	 System.out.println();
	 inA = in.nextInt();
	 inB = in.nextInt();
	 inC = in.nextInt();
	}
 }
}