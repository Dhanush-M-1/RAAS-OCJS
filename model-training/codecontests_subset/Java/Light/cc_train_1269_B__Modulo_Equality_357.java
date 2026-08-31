import java.util.*;
public class qb{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }
        Arrays.sort(b);
        long x=m;
        for(int i=0;i<n;i++){
            x=Math.min(check(i,a,b,m),x);;
        }
        System.out.println(x);
    }
    static int  check(int val,int[] a,int[] b,long m){
        int temp[]=new int[a.length];
        for(int i=0;i<a.length;i++){
            temp[i]=a[i];
        }
        int ans=(int)((b[val]-a[0]+m)%m);
        temp[0]=b[val];
        for(int i=1;i<a.length;i++){
            temp[i]=(int)((temp[i]+ans)%m);
        }
        Arrays.sort(temp);
        for(int i=0;i<a.length;i++){
            if(b[i]!=temp[i]) return (int)m;
        }
        return ans;
    }
}