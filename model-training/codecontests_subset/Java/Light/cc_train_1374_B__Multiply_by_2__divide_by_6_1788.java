import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(;t>0;t--){
            long n=in.nextLong();
            int c3=0,c2=0;
            for(;n%3==0;){
                n/=3;
                c3++;
            }
            for(;n%2==0;){
                n/=2;
                c2++;
            }
            if((n!=1) || (c3<c2))
                System.out.println(-1);
            else
                System.out.println((c3-c2)+c3);
        }
    }
}