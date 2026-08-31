import java.util.*;

public class Solve{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int  n=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int ans=0;
        for(int i=0;i<=a;i+=2){
            for(int j=0;j<=b;j++){
                int val=n-i/2-j;
                if(val>=0 && val%2==0 && val<=2*c) ans++;
            }
        }
        System.out.println(ans);
    }
}