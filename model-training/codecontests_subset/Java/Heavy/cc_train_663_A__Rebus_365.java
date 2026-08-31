import java.util.*;
import java.io.*;

public class B664
{

	public static void main(String[] args) throws Exception
	{
		Scanner in = new Scanner(System.in);
		String reb = in.nextLine();
		StringTokenizer st = new StringTokenizer(reb);
   		int plus = 0, minus = 0, n = 0;
		while (st.hasMoreTokens()){
			String next = st.nextToken();
			if (next.equals("?")) {
				if(plus == 0)
					plus++;
			}
			else if (next.equals("+")) {
				plus++;
			}
			else if (next.equals("-")) {
				minus++;
			}
			else if (next.equals("=")) {
			}
			else n = Integer.parseInt(next);
		}

		int[] ps = new int[plus];
		int[] ms = new int[minus];
		
		int p = n/plus;
		int mod = n%plus+minus;

		fill(ms, 1);

		if (p < 1) {
			p = 1;
			if(mod >= plus) {
				mod -= plus;
			}
			else {
				int add = plus - mod;
				if(!assign(add, ms, n))
				{
					System.out.println("Impossible");
					return;
				}
				mod = 0;
			}
		}
		fill(ps, p);
		
		if (assign(mod, ps, n)) {
			System.out.println("Possible");
			int temp = 1;
			int curp = 0;
			int curm = 0;
			for (int i = 0; i < reb.length(); i++) {
				if (reb.charAt(i) == '?') {
					if(temp == 1)
						System.out.print(ps[curp++]);
					else
						System.out.print(ms[curm++]);
				}
				else 
				{
					if (reb.charAt(i) == '-') 
						temp = 2;
					if (reb.charAt(i) == '+') 
						temp = 1;
					System.out.print(reb.charAt(i));
				}
			}
			System.out.println();
		}
		else {
			System.out.println("Impossible");
		}
	}

	public static void fill(int[] array, int value)
	{
		for (int i = 0; i < array.length; i++) {
			array[i] = value;
		}
	}

	public static boolean assign(int mod, int[] array, int n)
	{
		int cur = 0;
		while (cur < array.length && mod > 0) {
			if (array[cur] < n) {
				array[cur]++;
				mod--;
			}
			else
				cur++;
		}
		if (cur >= array.length || mod > 0) {
			return false;
		}
		return true;
	}
}