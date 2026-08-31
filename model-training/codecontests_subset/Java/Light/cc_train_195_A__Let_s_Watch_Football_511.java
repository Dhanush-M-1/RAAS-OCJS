import java.util.*;
import java.io.*;


public class codeforce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
        double time = 1.0*a*c/b;
        System.out.println((int)Math.ceil(time-c));
	}
}
