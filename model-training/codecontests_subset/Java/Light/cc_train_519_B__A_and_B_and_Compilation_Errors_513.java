import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class B {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		int n = input.nextInt();
		
		for(int i = 0; i < n; i ++){
			int aa = input.nextInt();
			a += aa;
		}
		
		for(int i = 0; i < n - 1; i++){
			int bb = input.nextInt();
			b += bb;
		}		
		System.out.println(a - b);
		
		for(int i = 0; i < n - 2; i++){
			int cc = input.nextInt();
			c += cc;
		}
		
		System.out.println(b-c);
		
				
		
		
		input.close();
	}

}
