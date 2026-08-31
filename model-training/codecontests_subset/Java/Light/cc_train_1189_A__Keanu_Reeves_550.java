import java.util.Scanner;
public class KeanuReeves {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int zahl = scan.nextInt();
		String s = scan.next();
		char [] zahlenreihe = s.toCharArray();
		int count0 = 0;
		int count1 = 0;
		for (int i = 0; i < zahlenreihe.length; i++) {
			if (zahlenreihe[i]=='0') {
				count0++;
			}
			else {	
			count1++;	
			}
		}
		if (count0!=count1) {
			System.out.println(1);
			System.out.println(s);
}
		else {
		String ausgabe="";
		for (int e = 1; e < zahlenreihe.length; e++) {
		ausgabe+=zahlenreihe[e];
		}
			System.out.println(2);
			System.out.println(zahlenreihe[0]);
			System.out.println(ausgabe);
		
			
		}

	}//Main

}//Class
