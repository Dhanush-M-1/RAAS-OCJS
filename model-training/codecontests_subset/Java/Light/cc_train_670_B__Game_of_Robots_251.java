import java.util.Scanner;
public class Pair {
 
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int n = s.nextInt();
	    int k = s.nextInt();
	    int[] arr = new int[n+1];
	    for(int i=1;i<=n;i++){
	        arr[i] = s.nextInt();
        }
	    int count = 0;
	    for(int i=1;i<=n;i++){
	        count += i;
	        if(count>=k){
	            int minus = count - k;
                System.out.println(arr[i-minus]);
                break;
            }
	    }
    }
}