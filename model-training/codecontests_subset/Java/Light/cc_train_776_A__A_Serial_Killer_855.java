import java.util.*;

public class jon{
	public static void main(String ... args){
		Scanner in = new Scanner(System.in);
		String name1 = in.next();
		String name2 = in.next();
		long n = in.nextLong();
		System.out.println(name1 + " " + name2);
		while (n-- > 0) {
			String nextKill = in.next();
			String appear = in.next();
			if (nextKill.equals(name1)) {
				name1 = appear;
			} else if (nextKill.equals(name2)) {
				name2 = appear;
			}
			System.out.println(name1 + " " + name2);
		}
	}
}