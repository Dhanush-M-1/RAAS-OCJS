////////////////////---------------------------SHUBHAM CHAUDHARI-------------------------------///////////////////////


import java.util.*;

public class Main {
    static int mod=100000000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        long A[]=new long[n];
        long x=0;
        long sum=0;
        for(int i=0;i<n;i++)
        {
            A[i]=in.nextLong();
            sum+=A[i];
            x=Math.max(A[i],x);
        }
        x=(long)Math.max(x,Math.ceil((double)sum/(n-1)));
        System.out.println(x);

    }

}