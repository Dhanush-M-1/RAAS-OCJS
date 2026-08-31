import java.util.Scanner;

public class treasure {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String tst = in.next();
		int last = 0;
		int an = 0;
		boolean flag = true;
		for (int i = 0; i < tst.length(); i++) {
			if (tst.charAt(i) == '(')
				an++;
			else {
				an--;
				if (tst.charAt(i) == '#')
					last = i;
			}
			if (an < 0) {
				flag = false;
				break;
			}
		}

		if (!flag)
			System.out.println(-1);
		else {
			int bn = 0;
			for (int i = 0; i < tst.length(); i++) {
				bn += (tst.charAt(i) == '(' ? 1 : (i == last ? (-an - 1) : -1));
				if (bn < 0)
					break;
			}
			if (bn < 0)
				System.out.println(-1);
			else {
				for (int i = 0; i < last; i++)
					if (tst.charAt(i) == '#')
						System.out.println(1);
				System.out.println(an + 1);
			}
		}
		in.close();
	}

}
