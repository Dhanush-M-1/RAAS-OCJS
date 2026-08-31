import java.util.Scanner;

public class PhoneNumbers {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		String s = sc.next();
		int z = 0;
		for (int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='8') z++;
		}
		int a = s.length()/11;
		int ergebnis;
		if(a<z) ergebnis =a;
		else ergebnis=z;
		
		System.out.println(ergebnis);
	}

}
