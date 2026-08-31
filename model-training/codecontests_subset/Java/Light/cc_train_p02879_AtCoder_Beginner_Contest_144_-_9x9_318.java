import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int a = in.nextInt();
		int b = in.nextInt();

		if (a > 9 || b > 9)
			System.out.println(-1);
		else
			System.out.println(a*b);
	}
}

