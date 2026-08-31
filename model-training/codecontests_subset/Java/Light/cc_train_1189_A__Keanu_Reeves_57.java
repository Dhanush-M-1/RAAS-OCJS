import java.util.*;
import java.io.*;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String s = sc.next();
		int c = 0, v = 0;
		for(int i = 0; i < n; i++)
			if(s.charAt(i) == '0')
				c++;
			else
				v++;
		if(c != v) {
			System.out.println(1);
			System.out.println(s);
		} else {
			System.out.println(2);
			System.out.println(s.charAt(0) + " " + s.substring(1));
		}
	}
}
