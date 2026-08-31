import java.util.Scanner;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[] prev = new int[n];
	    for(int i = 0; i < n; i++) prev[i] = sc.nextInt();
	    Arrays.sort(prev);
	    for(int loop = 0; loop < 2; loop++){
	        n--;
	        int[] curr = new int[n];
	        for(int i = 0; i < n; i++) curr[i] = sc.nextInt();
	        Arrays.sort(curr);
	        
	        int out = prev[n];
	        for(int i = 0; i < n; i++){
	            if(curr[i] != prev[i]){
	                out = prev[i];
	                break;
	            }
	        }
	        System.out.println(out);
	        if(loop == 1) break;
	        prev = new int[n];
	        for(int i = 0; i < n; i++) prev[i] = curr[i];
	    }
	}
}