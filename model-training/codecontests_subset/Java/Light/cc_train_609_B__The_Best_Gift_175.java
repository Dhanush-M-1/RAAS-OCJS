
import java.util.*;
import java.math.*;

/**
 *
 * @author sarthak
 */
public class educationalRound3_B {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();int m=s.nextInt();
        int[] ar=new int[n];
        int[] gn=new int[11];
        for(int i=0;i<n;i++)
        {
            int g=s.nextInt();
            gn[g]++;
        }
        int[] sf=new int[11];
        
        long an=0;
        for(int i=1;i<=10;i++)
        {
            long sum=0;
            for(int j=i+1;j<=10;j++)
                sum=sum+gn[j];
            an=an+(long)(((long)gn[i])*sum);
        }        
        System.out.println(an);
            
            
        
        
    }

}
