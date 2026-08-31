import java.util.Scanner;
public class Phone {
public static void main(String[] args) {
	Scanner scanner = new Scanner (System.in);
	int n = scanner.nextInt();
	String s = scanner.next();
	int d=0;
	for (int i=0;i<n;i++) {
		if (s.charAt(i)=='8') d++; 
	}
	int x = n/11;
	System.out.println(Math.min(x, d));
	scanner.close();
}
}