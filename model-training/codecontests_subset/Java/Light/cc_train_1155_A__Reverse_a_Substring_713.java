import java.util.Scanner;

/*
 *  7
 *	abacaba
 * 	YES
 *	2 5
 *	a acab ba
 *
 * 6
 * aabcfg
 * NO
 * zlzzzzzz
 */
public class Reverse {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		String str = "";
		do {
			str = in.next().toLowerCase();
		}while(str.length()!=n);
		
		int flag1 = -1, min = -1;
		for(int i=0; i<str.length()-1; i++) {
			if((int)str.charAt(i)>(int)str.charAt(i+1)) {
				flag1 = i+1;
				min = (int)str.charAt(i);
				break;
			}
		}
		if(flag1 == -1) {
			System.out.println("NO");
			return;
		}
		
		int flag2 = -1;
		for(int i=flag1-1; i<str.length(); i++) {
			//min = ((int)str.charAt(i)<min)?(int)str.charAt(i):min;
			if((int)str.charAt(i)<=min) {
				min = (int)str.charAt(i);
				flag2 = i+1;
			}
		}
		
		System.out.println("YES");
		System.out.println(flag1+" "+flag2);
		
	}

}
