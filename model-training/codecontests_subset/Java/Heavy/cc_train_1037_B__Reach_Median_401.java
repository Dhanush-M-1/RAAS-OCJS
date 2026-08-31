import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Main {
    public  static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0)
        {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }


    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static PrintWriter pw=new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Scanner S = new  Scanner(System.in);
        int n=S.nextInt();
        int k=S.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=S.nextInt();
        }
        Arrays.sort(a);
        long ans=0;
        ans+=Math.abs(k-a[n/2]);
        for (int i = (n/2)+1; i < n; i++) {
            if(a[i]<k)ans+=(k-a[i]);
        }
        for (int i = 0; i < (n/2); i++) {
            if(a[i]>k)ans+=(a[i]-k);
        }
        System.out.println(ans);

    }
}


