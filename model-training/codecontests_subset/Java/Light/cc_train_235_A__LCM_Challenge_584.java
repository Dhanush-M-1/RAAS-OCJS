import java.util.*;
public class LCM {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        long n = sc.nextLong();
        if(n<=2)
        System.out.println(n);
        else if(n%2!=0)
        {
        long a =n-1;
        long b=n-2;
        long sum=n*a*b;
        if(n%2!=0)
        System.out.println(sum);
        }
        else 
        {
            if(n%3!=0)
            System.out.println((long)(n*(n-1)*(n-3)));
            else
            System.out.println((long)(n-1)*(n-2)*(n-3));
        }

    }

    
}