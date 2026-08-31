import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int k=0;k<t;k++){
            int a=s.nextInt();
            int b=s.nextInt();
            int n=s.nextInt();
            
            int v=check(a,b,n);
            System.out.println(v);
            
            }
    }
    public static int check(int a,int b,int n){
        if(n==0)
            return a;
        if(n==1)
            return b;
        if(n==2)
            return a^b;
         return check(a,b,n%3);
    }
}
