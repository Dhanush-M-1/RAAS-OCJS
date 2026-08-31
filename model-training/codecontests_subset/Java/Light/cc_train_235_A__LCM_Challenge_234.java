import java.util.Scanner;

public class Main {

    public static long gcd_binary(long a, long b)
    {   a=Math.abs(a); b=Math.abs(b);
       if (a==b) return a;
       else if (a==0) return b;
       else if (b==0||a==1) return a;
       else if (b==1) return b;
       else if (a%2==0&&b%2==0) return 2*gcd_binary(a/2,b/2);
       else if (a%2==0&&b%2!=0) return gcd_binary(a/2,b);
       else if (a%2!=0&&b%2==0) return gcd_binary(b/2, a);
       else if (a<b) return gcd_binary((b-a)/2, a);
       else return gcd_binary((a-b)/2, b);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n;
        n=sc.nextLong();
       



        if (n<3) System.out.println(n);
        //else if (n==2) System.out.println(2);
        else if (n%2!=0) System.out.println(n*(n-1)/gcd_binary(n,(n-1))*(n-2)/gcd_binary(n*(n-1)/gcd_binary(n,(n-1)),(n-2)));
        else if (n%3!=0)System.out.println(n*(n-1)/gcd_binary(n,(n-1))*(n-3)/gcd_binary(n*(n-1)/gcd_binary(n,(n-1)),(n-3)));
        else System.out.println((n-1)*(n-2)/gcd_binary((n-1),(n-2))*(n-3)/gcd_binary((n-1)*(n-2)/gcd_binary((n-1),(n-2)),(n-3)));
    }
}