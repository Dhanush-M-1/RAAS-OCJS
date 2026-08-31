import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.awt.geom.*;
import java.io.*;

import static java.lang.Math.*;
import static java.lang.Character.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Long.*;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class A {
	
	int m,n;
	int ret = 0;
	
	void solveProblem() {
		in.nextLine();
		String s = in.nextLine().trim();
		for (int i = 0; i < s.length()-1; i++) {
			if (s.charAt(i) > s.charAt(i+1)) {
				out.println("YES");
				out.println((i+1) + " " + (i+2));
				return;
			}
		}
		out.println("NO");
	}
	
    Scanner in = new Scanner(System.in);
    PrintStream out = System.out; 
	
	public static void main(String[] args) {
		A a = new A();
		a.solveProblem ();
	}

}