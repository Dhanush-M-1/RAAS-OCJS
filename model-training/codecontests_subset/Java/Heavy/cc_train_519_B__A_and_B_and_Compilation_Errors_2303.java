import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ar[]=new int[n];
        int br[]=new int[n-1];
        int cr[]=new int[n-2];
        int a=0,b=0,c=0;
        for(int i=0;i<n;i++){
        ar[i]=sc.nextInt();
        a=a+ar[i];
        }
        for(int i=0;i<n-1;i++){
         br[i]=sc.nextInt();
         b=b+br[i];
        }
        for(int i=0;i<n-2;i++){
            cr[i]=sc.nextInt();
            c=c+cr[i];
        }
        int x=Math.abs(a-b);
        int y=Math.abs(b-c);
        System.out.println(x);
        System.out.println(y);
    }
}