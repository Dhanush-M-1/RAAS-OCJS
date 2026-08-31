import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class D {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		final char[] input = sc.next().toLowerCase().toCharArray();
		final int n = sc.nextInt();
		
		for(int i = 0; i < input.length; i++){
			int diff = input[i] - 'a';
			
			if(diff < n){
				input[i] += (char)('A' - 'a');
			}
		}
		
		System.out.println(input);
		
		sc.close();
	}
}
