
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	int a = Integer.parseInt(scan.next());
	int b = Integer.parseInt(scan.next());
	int c = Integer.parseInt(scan.next());

	int total = a + b + c;
	boolean ans = (total - a == a) || (total - b == b) || (total - c == c);

	System.out.println(ans ? "Yes" : "No");
	scan.close();
    }
}
