import java.util.*;
public final class Main{
   /* static int f(int n,int a,int b){
        if(n==0)
        return a;
        else if(n==1)
        return b;
        return f(n-1,a,b)^f(n-2,a,b);
    }*/
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int n=sc.nextInt();
            if(n%3==0)
            System.out.println(a);
            else if(n%3==1)
            System.out.println(b);
            else 
            System.out.println(a^b);
        }
    }
}