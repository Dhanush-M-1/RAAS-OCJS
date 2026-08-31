import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class Main{

    public static void main(String arg0[]){
        //DecimalFormat df=new DecimalFormat("0.0000");
        //df.setRoundingMode(RoundingMode.HALF_UP);
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long max=0;long sum=0;
        for (int i=0;i<n;i++){
            long t=in.nextLong();
            max=Math.max(max, t);
            sum+=t;
        }
        long ans=max;
        while (ans*(n-1)<sum){
            ans++;
        }
        System.out.println(ans);
        
    }
}
