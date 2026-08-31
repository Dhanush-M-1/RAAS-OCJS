
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr  = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[] num = new int[200001];
        int ans = Integer.MAX_VALUE;
        int[] count = new int[200001];
        for (int i=0;i<n;i++){
            int x = arr[i];
            int temp = 0;
            while(x!=0){
                num[x]++;
                count[x] += temp;
                if(num[x] == k) ans = Math.min(ans,count[x]);
                temp++;
                x /= 2;
            }
        }
        System.out.println(ans);
    }
}

		   		  	 	  	    	   	   	 	