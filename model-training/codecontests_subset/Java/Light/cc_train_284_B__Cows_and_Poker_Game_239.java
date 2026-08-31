import java.util.*;

public class S {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		int n = scan.nextInt();
		String c = scan.next();
		int a = 0;
		int i = 0;
		
		for(int j=0; j<n; j++) {
			if(c.charAt(j) == 'A') 
				a++;
			if(c.charAt(j) == 'I')
				i++;
		}
		
		if(i == 0) 
			System.out.println(a);
		else if(i == 1)
			System.out.println(i);
		else if(i > 1)
			System.out.println(0);
		
	}

}
