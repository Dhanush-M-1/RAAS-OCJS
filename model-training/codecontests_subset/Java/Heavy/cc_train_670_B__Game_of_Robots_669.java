import org.omg.Messaging.SyncScopeHelper;

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  j , t;
        int i, sum = 0;
        long [] a = new long[100005];
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        for(i = 1;i<=n;i++) {
            a[i] = scanner.nextLong();
        }
        for(i=0;i<=n;i++) {
            if((sum+i)>=k)
                break;
            else
                sum+=i;
        }
        int c = (int)(k-sum);
        System.out.println(a[c]);
    }
}


			   	 		    		  		 	 	  	   	