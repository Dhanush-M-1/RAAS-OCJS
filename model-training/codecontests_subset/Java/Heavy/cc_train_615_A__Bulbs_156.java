import java.util.Arrays;
import java.util.Scanner;

 
public class Bulbs {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner (System.in);
		
		int button = scan.nextInt();
		int bulb = scan.nextInt();
		boolean asw = false;
		int nextscan;
		
		int thing1[] = new int[bulb];
		int thing2[] = new int[bulb];
		
		
		for (int i = 0; i < bulb; i++) {
			
			thing2[i] = i + 1;
			
		}
		for (int i =  0; i < button; i++) {
			
		    int jkty = scan.nextInt();
		    
		    for (int x = 0; x < jkty; x++) {
		    	
		    	nextscan = scan.nextInt() - 1;
		        thing2[nextscan] = 0;
		        
		    }}
		
		asw = Arrays.equals(thing1, thing2);
		if (true == asw) {
		    System.out.println("YES");
		} else {
		    System.out.println("NO");
		}}}