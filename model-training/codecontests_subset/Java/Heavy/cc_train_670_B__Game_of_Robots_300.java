import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.image.BandedSampleModel;
import java.util.*;

public class Example {
    static long[][] dp;
    //  static    int[]  ar;
    static int mod = 1000000000 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();
        int k=sc.nextInt();
        int[] arr =new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=1;i<=n;i++){
            if(k-i>0){
                k=k-i;
            }else{
                break;
            }
        }
        System.out.println(arr[k]);

    }
    public  static int Naser(int[] coins ,int amont,int  i){



        if(amont==0)
            return 0;
        if(amont<0)
            return 0;
        if(i<0)
            return 0;
        return Math.min(1+Naser(coins,amont-coins[i],i),Naser(coins,amont,i-1));


    }



}






