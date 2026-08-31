import java.util.*;

public class CF_313_D {
	public static void main(String[] args) {
		String frst, second;
		Scanner scanf = new Scanner(System.in);
		frst = scanf.next();
		second = scanf.next();
		if(equivalence(frst, second) == true)
		{
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	public static boolean equivalence(String a, String b)
	{
		int lnt = a.length();
		if(a.equals(b)) return true;
		else if(lnt % 2 == 0) {
			return  ((equivalence(a.substring(0, lnt/2),b.substring(lnt/2)) && equivalence(b.substring(0, lnt/2),a.substring(lnt/2))) || 
					(equivalence(a.substring(0,lnt/2),b.substring(0,lnt/2))&&equivalence(a.substring(lnt/2),b.substring(lnt/2))));				
		}
		return false;
	}
}