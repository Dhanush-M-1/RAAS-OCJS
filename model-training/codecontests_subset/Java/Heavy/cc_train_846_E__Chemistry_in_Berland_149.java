import java.math.*;

import java.util.*;



public class Main {

    

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);

        

        int n=in.nextInt();

        int[] fa=new int[n+1];

        BigInteger[] a=new BigInteger[n+1], k=new BigInteger[n+1], b=new BigInteger[n+1];

        for(int i=1; i<=n; i++) a[i]=in.nextBigInteger();

        for(int i=1; i<=n; i++) b[i]=in.nextBigInteger();

        for(int i=2; i<=n; i++) {

            fa[i]=in.nextInt();

            k[i]=in.nextBigInteger();

        }

        

        BigInteger inf=BigInteger.TEN.pow(20).negate();

        int ok=1;

        for(int i=n; i>0; i--) {

            a[i]=a[i].subtract(b[i]);

            if(i==1) break;

            if(a[i].compareTo(BigInteger.ZERO)>0) a[fa[i]]=a[fa[i]].add(a[i]);

            else a[fa[i]]=a[fa[i]].add(k[i].multiply(a[i]));

            if(a[fa[i]].compareTo(inf)<0) {ok=0; break;}

        }

        if(ok==1 && a[1].compareTo(BigInteger.ZERO)>=0) System.out.println("YES");

        else System.out.println("NO");

    }

}
                             