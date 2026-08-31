import java.util.*;
import java.io.*;

public class SolutionB{
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int count = 0;
		for(int i = 0 ; i <= a ; i++){
			if(i%2 == 1) continue;
			for(int j = 0 ; j <= b ; j++){
				int left = n - ((i/2) + j);
				if(left >= 0 && left%2 == 0 && left/2 <= c) count++;
			}
		}
		System.out.println(count);
	}
	
}