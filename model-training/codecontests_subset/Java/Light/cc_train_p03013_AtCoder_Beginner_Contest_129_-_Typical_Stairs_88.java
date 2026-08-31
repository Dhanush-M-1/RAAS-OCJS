import java.util.Arrays;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in); 
		
		int N  = keyboard.nextInt();
		int M  = keyboard.nextInt();
		
		int[] B = new int[N+1];
        
        for(int i = 0; i < M; i++){
          int tmp  = keyboard.nextInt();
          B[tmp]= 1; 
        }
        
		long[] sum = new long[N+1];
		sum[0] = 1;
		sum[1] = 1 - B[1] ;
		
		for(int j = 2; j < N+1; j++){
			if(B[j] != 1){
          sum[j] = (sum[j-1]+sum[j-2])%1000000007 ;
          }
        }
        
		System.out.println(sum[N]);
		keyboard.close();	
	}
}
