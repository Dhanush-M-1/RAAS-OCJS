import java.io.*;
import java.util.*;
public class A {
	static Scanner scan = new Scanner (System.in);
	static PrintStream out = System.out;
	
	public static void main (String[] args) {
		int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
		out.println((a*c-b*c+b-1)/b);
	}
}
