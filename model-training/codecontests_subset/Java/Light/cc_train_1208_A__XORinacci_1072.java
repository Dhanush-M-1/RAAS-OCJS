import java.util.*;
import java.io.*;
public final class Example{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t>0){
            long a,b,n;
            a=scanner.nextLong();
            b=scanner.nextLong();
            n=scanner.nextLong();
            n=n%3;
            if(n==0){
                System.out.println(a);
            }
            else if(n==1){
                System.out.println(b);
            }
            else{
                System.out.println(a^b);
            }
            t--;
        }
    }
}