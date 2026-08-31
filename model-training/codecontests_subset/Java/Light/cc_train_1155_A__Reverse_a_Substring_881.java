import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int len = scan.nextInt();
		
		scan.nextLine();
		
		String s = scan.next();
		
		char last = s.charAt(0);
		
		for (int i = 1; i < len; i++) {
		    char curr = s.charAt(i);
		    
		    if (curr < last) {
		        System.out.println("YES");
		        System.out.println(i + " " + (i + 1));
		        return;
		    }
		    
		    last = curr;
		}
		
		System.out.println("NO");
	}
}
