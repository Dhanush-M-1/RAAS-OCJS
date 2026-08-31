import java.util.Arrays;
import java.util.Scanner;

public class Elections {

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        
        int n = input.nextInt();
        int []arr = new int[n];
        int sum = 0;
        
        for(int i=0 ; i<n ; i++){
            arr[i] = input.nextInt();
            sum += arr[i];
        }
        
        Arrays.sort(arr);
        int max = arr[n-1];
                 
        for(int k=max ; k<10000 ; k++){
            if(k*n - sum > sum) {
                System.out.println(k);
		break;    
            }
        } 
    }
}