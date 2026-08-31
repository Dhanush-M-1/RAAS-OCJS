import java.util.*;

public class Practise {

    static int[][] dp;

    static long sum=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int c=sc.nextInt();
        int[] xx=new int[n];
        for(int i=0;i<n;i++)
            xx[i]=sc.nextInt();
        int ans=0;
        for(int i=0;i<n-1;i++){
            int x=0;
            if(xx[i]>xx[i+1]){
                x=(xx[i]-xx[i+1]-c);
            }
            if(x>=ans)
            {
                ans=x;
            }
        }
        System.out.println(ans);
    }
}
   	 	 		 													 					 	