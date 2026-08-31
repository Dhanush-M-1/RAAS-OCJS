import java.util.*;
 
public class Main {
	public static void main(String args[]){
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int a[] = new int[n + 1];
		int b[] = new int[n + 1];
		int c[] = new int[n];
		int sum = 0;
		
		for(int i = 1; i <= n; i++){
		    a[i] = stdIn.nextInt();
		}
		
		for(int i = 1; i <= n; i++){
		    b[i] = stdIn.nextInt();
		}
		
		for(int i = 1; i <= n - 1; i++){
		    c[i] = stdIn.nextInt();
		}
		
		int index = -100;
		for(int i = 1; i <= n; i++){
		    sum += b[a[i]];
		    if(index + 1 == a[i]){
		        sum += c[a[i] - 1];
		    }
		    index = a[i];
		}
		
		System.out.println(sum);
		
	}
}