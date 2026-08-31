import java.util.*;
import java.io.*;
import java.awt.Point;

public class p168A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(), x = in.nextInt(), y = in.nextInt();

		System.out.println(Math.max((int)(Math.ceil((y/100.0)*n-x)), 0));
	}
}