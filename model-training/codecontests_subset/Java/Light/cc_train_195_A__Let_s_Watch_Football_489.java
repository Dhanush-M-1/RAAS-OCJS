import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
        int req=a*c;
        int ans=req/b;
        if(req%b!=0)ans++;
        System.out.println(Math.max(0,ans-c));
    }
}