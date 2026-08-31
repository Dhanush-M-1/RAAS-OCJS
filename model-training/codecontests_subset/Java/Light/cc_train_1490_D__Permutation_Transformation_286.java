import java.io.*;
import java.util.*;
import java.lang.*;
public class A1473 {
    public static int[] ans=new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        while (t-- != 0) {
            int n=Integer.parseInt(bf.readLine());
            String[] s=bf.readLine().split(" ");
            int[] a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(s[i]);

            solve(a,0,n-1,0);
            for(int i=0;i<n;i++)
                System.out.print(ans[i]+" ");
            System.out.println();
        }
    }
    public static void solve(int[] a,int l,int r,int d){
        if(l>r)
            return;
        if(l==r){
            ans[l]=d;
            return;
        }
        int max=a[l];int id=l;
        for(int i=l;i<=r;i++){
            if(a[i]>max){
                max=a[i];
                id=i;
            }
        }
        ans[id]=d;
        //System.out.println("hi"+id);
        solve(a,l,id-1,d+1);
        solve(a,id+1,r,d+1);
    }
}
