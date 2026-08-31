import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long[] num = new long[200010];
        long[] sum = new long[200010];
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();//
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        //找到一共有多少个数可以变成arr[i]以及他们所需要的次数
        long ans=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int count = 0;
            while (x > 0) {
                num[x]++;
                sum[x] += count++;
                if (num[x] == k) {
                    ans = Math.min(ans, sum[x]);
                }
                x /= 2;
            }
        }
        System.out.println(ans);
    }
}

  	 	  	 	  	  	  		  			    	