import java.util.ArrayList;
import java.util.Scanner;


public class CompilationError {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int a=0,b=0,c=0;
		
		for(int i=0; i<num; i++)
			a+=sc.nextInt();
		for(int i=0; i<num-1; i++)
			b+=sc.nextInt();
		for(int i=0; i<num-2; i++)
			c+=sc.nextInt();
		
		System.out.println(a-b);
		System.out.println(b-c);
	
	
	
	}
		
}
