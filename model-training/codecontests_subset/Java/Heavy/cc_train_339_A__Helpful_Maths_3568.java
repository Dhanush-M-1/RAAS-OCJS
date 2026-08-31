import java.util.Scanner;

public class helpFullMath {

	public static void main(String[] args) {
		Scanner ay = new Scanner(System.in);
		
		String a = ay.nextLine();
		
		String b = "";
		
		for(int i = 0; i < a.length(); i = i+2) {
			b += a.charAt(i);
		}
		char aa[] = new char[b.length()];
		
		for(int i = 0; i < b.length(); i++) {
			aa[i] = b.charAt(i);
		}
		
		for(int i = 0; i < b.length()-1; i++) {
			for(int j = i+1; j < b.length(); j++) {
				if(aa[i] > aa[j]) {
					char z = aa[i];
					aa[i] = aa[j];
					aa[j] = z;
					
				}
			}
		}
		
		for(int i = 0; i < b.length(); i++) {
			if(i<b.length()-1) {
				System.out.print(aa[i]+"+");
			}else {
				System.out.print(aa[i]);
			}
		}
		
	}

}