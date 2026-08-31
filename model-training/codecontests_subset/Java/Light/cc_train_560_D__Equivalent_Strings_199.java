import java.util.Scanner;


public class EquivalentStrings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.next();
		String b = scanner.next();
		
		a = eqSort(a);
		b = eqSort(b);
		if(a.equals(b)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	public static String eqSort(String a) {
		if(a.length()%2 == 1) return a;
		String a1 = eqSort(a.substring(0, a.length()/2));
		String a2 = eqSort(a.substring(a.length()/2, a.length()));
		
		if(a1.compareTo(a2)>0) {
			return a2 + a1;
		}
		return a1 + a2;
	}
	
}
