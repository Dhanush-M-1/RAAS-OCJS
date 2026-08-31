import java.util.Arrays;
import java.util.Scanner;
public class mafia {
    public static void main(String[] args) {
    	
    	
    	//http://codeforces.com/problemset/problem/348/A
    	Scanner sc = new Scanner(System.in);
    	
    	//lo mismo opcion 2
    	int n = sc.nextInt();
		double sum = 0;
		int[] rounds = new int[n];
		for (int i = 0; i < n; i++) {
			rounds[i] = sc.nextInt();
			sum += rounds[i];
		}
		
		Arrays.sort(rounds);
		System.out.println((int) Math.max(Math.ceil(sum / (n - 1)), rounds[n-1]));
		
    }
    
}