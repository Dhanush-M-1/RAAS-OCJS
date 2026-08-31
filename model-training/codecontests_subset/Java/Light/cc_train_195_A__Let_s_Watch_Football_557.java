import java.util.Scanner;


public class Main{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		 int seg = 0;
		 int temp=0;
		  for (int i = temp; i<(a*c)-(b*c); i+=b) {
			seg++;
		  }
		    System.out.println(seg);
	}
}
	