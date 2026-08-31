import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            System.out.println(getAns(a,b,c));
        }
    }
    public static int getAns(int a,int b, int c){
        int ans=0;
        int f=Math.min(b,c/2);
        ans+=f*3;
        b-=f;
        if(b>=2) ans+=Math.min(a,b/2)*3;
        return ans;
    }
}