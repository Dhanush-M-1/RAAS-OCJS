import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		String s = in.next();
		
	    int inmn = 0;
	    
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) >= s.charAt(inmn)) {
                inmn = i;
			} else {
			    System.out.print("YES\n" + (inmn + 1) + " " + (i + 1));
			    System.exit(0);
			}
		}
		System.out.print("NO");
		
	}
}