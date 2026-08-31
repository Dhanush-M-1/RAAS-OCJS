
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Young {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());
		
		Integer tab[] = new Integer[n];
	    for(int i=0; i<n; i++)
	    {
	    	tab[i] = Integer.parseInt(sc.next());
	    }
	    int max = 0;
	    for(int i=0; i<n-1; i++)
	    {
	    	max = Math.max(max, tab[i]-tab[i+1]-c);
	    }
	    System.out.println(max);
		
	}
	

		
	

}
