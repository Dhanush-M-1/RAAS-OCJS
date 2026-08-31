import java.io.*;
import java.math.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {  
		Scanner input = new Scanner(System.in);
		int A = input.nextInt();
		int B = input.nextInt();
		int C = input.nextInt();
		if (A+B==C||A+C==B||B+C==A) System.out.println("Yes");
		else System.out.println("No");
	}
}