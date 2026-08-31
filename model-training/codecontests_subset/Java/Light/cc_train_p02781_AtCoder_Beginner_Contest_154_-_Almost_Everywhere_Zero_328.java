import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static long fun1(BigInteger a){
        String r=a+"";
        if(a.compareTo(BigInteger.TEN)<=0)
            return Long.valueOf(r);
        else{
            long p=0;
            p+=(r.length()-1)*9;
            p+=Integer.parseInt(r.charAt(0)+"");
            return p;
        }
    }

    public static long fun2(BigInteger a){
        String r=a+"";
        if(a.compareTo(BigInteger.TEN)<=0)
            return 0;
        else{
            long p = (Integer.parseInt(r.charAt(0) + "") - 1) * 9 * (r.length() - 1);
            p += (r.length() - 2) * (r.length() - 1) / 2 * 9 * 9;
            r=r.substring(1);
            a=new BigInteger(r);
            p+= Main.fun1(a);
            return p;
        }
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedInputStream(System.in));
        BigInteger a=sc.nextBigInteger();
        BigInteger c=new BigInteger("110");
        String r=a+"";
        int k=sc.nextInt();
        if(k==1)
            System.out.println( Main.fun1(a));
        if(k==2)
            System.out.println( Main.fun2(a));
        if(k==3){
            if(a.compareTo(c)==-1)
                System.out.println("0");
            else{
                long q = 0;
                long v = (r.length() - 1) * (r.length() - 2) * (r.length() - 3) / 6 * 9 * 9 * 9;
                v += 9 * 9 * (Integer.parseInt(r.charAt(0) + "") - 1) * (r.length() - 1) * (r.length() - 2) / 2;
                r = r.substring(1);
                a=new BigInteger(r);
                v+= Main.fun2(a);
                System.out.println(v);
            }
        }
    }
}
