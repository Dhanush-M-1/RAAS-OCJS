import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int s = 0;
		for (int i = 0; i < 5; i++) {
			s += in.nextInt();	
		}		
		if (s % 5 == 0 && s != 0) out.println(s / 5); else out.println(-1);
		out.close();
	}
}