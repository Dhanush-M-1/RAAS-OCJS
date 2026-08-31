import java.util.*;
import java.lang.*;
import java.io.*;
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int x = s.nextInt();
		int y = s.nextInt();
		int c = 0;
		String st = s.next();
		for (int i = n - x; i < n; i++) {
			char a = st.charAt(i);
			if (i == n - y - 1) {
			    if (a == '0') {
			        c += 1;
			    }
			}
			else {
			    if (a == '1') {
			        c += 1;
			    }
			}
		}
		System.out.println(c);
	}
}