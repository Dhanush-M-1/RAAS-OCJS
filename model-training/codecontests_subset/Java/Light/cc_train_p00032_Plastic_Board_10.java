import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);

		int rect = 0, diamond = 0;
		while (sc.hasNext()) {
			String[] ss = sc.next().split(",");
			int a = Integer.parseInt(ss[0]);
			int b = Integer.parseInt(ss[1]);
			int c = Integer.parseInt(ss[2]);
			if( a == b ) diamond++;
			if ( a * a + b * b == c * c)
				rect++;
		}
		System.out.println(rect);
		System.out.println(diamond);
		
	}

}