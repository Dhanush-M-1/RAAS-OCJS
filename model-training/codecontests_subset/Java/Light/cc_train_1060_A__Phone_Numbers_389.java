import java.util.*;
public class PhoneNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String s = scan.nextLine();
		
		int x = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '8') {
				x++;
			}	
			//System.out.println("found");
		}
	//	System.out.println(s);
	//	System.out.println(x);
		System.out.println(Math.min(n/11, x));

	}

}
