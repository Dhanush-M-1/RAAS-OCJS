import java.util.Scanner;

public class HelpfulMaths {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		String loesung = "";
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1') {
				count1++;
			}
			if(s.charAt(i) == '2') {
				count2++;
			}
			if(s.charAt(i) == '3') {
				count3++;
			}
		}
		
		for(int i = 0; i < count1; i++) {
			loesung = loesung + "1+";
		}
		for (int i = 0; i < count2; i++) {
			loesung = loesung + "2+";
		}
		for(int i = 0; i < count3; i++) {
			loesung = loesung + "3+";
		}
		
		loesung = loesung.substring(0, loesung.length()-1);
		System.out.println(loesung);
	}
}
