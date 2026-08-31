import java.util.*;

public class GameOfRobot{
    public static void main (String[] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        long[] arr= new long[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextLong();
        }
        for(int i=1;i<=n;i++){
            if(k>i) k-=i;
        }

        System.out.println(arr[k-1]);
    }
}