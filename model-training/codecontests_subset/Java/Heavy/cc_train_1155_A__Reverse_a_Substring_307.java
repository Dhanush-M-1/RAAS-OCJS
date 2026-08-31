import java.io.*;
import java.util.*;
import java.math.*;

public class A {

	public void realMain() throws Exception {

		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);

		String in = fin.readLine();

		String[] ar = in.split(" ");

		int n = Integer.parseInt(ar[0]);
		
		String s = fin.readLine();

		boolean can = false;
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) > s.charAt(i + 1)) {
				System.out.println("YES");
				System.out.println((i + 1) + " " + (i + 2));
				return;
			}
		}

		System.out.println("NO");



	}


	public static void main(String[] args) throws Exception {
		A a = new A();
		a.realMain();
	}
}