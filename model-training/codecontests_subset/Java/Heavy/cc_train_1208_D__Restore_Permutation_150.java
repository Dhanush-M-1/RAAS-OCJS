import java.awt.*;
import java.math.BigInteger;
import java.util.*;

public class Ada{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        SegmentTree s=new SegmentTree(n);
        for (int i=0;i<n;i++){
            s.increment(i,i,sc.nextLong());
        }
        int ans[]=new int[n];
        for (int i=1;i<=n;i++){
            s.minimum(0,n-1);
            int idx=s.idx[1];
            ans[idx]=i;
            s.increment(idx+1,n-1,-i);
            s.increment(idx,idx,Long.MAX_VALUE);
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<n;i++){
            sb.append(ans[i]+" ");
        }
        System.out.println(sb);
    }
    static class SegmentTree{
        int[] lo,hi,idx;
        long[] delta,min;
        SegmentTree(int n){
            lo=new int[4*n+1];
            hi=new int[4*n+1];
            delta=new long[4*n+1];
            min=new long[4*n+1];
            idx=new int[4*n+1];
            init(1,0,n-1);
        }
        void init(int i,int a,int b){
            lo[i]=a;
            hi[i]=b;
            if (a==b)return;
            int m=(a+b)/2;
            init(2*i,a,m);
            init(2*i+1,m+1,b);
        }
        void propagate(int i){
            delta[2*i]+=delta[i];
            delta[2*i+1]+=delta[i];
            delta[i]=0L;
        }
        long minimum(int a,int b){
            return minimum(1,a,b);
        }
        void increment(int a,int b,long val){
            increment(1,a,b,val);
        }

        void update(int i){
            if (min[2*i]+delta[2*i]<min[2*i+1]+delta[2*i+1]){
                idx[i]=idx[2*i];
                min[i]=min[2*i]+delta[2*i];
            }else {
                idx[i]=idx[2*i+1];
                min[i]=min[2*i+1]+delta[2*i+1];
            }
        }
        void increment(int i,int a,int b,long val){
            if (a>hi[i] || b<lo[i]){
                return;
            }
            if (hi[i]<=b && lo[i]>=a){
                delta[i]+=val;
                if (a==b)idx[i]=a;
                return;
            }
            propagate(i);
            increment(2*i,a,b,val);
            increment(2*i+1,a,b,val);
            update(i);
        }
        long minimum(int i,int a,int b){
            if (a>hi[i] || b<lo[i]){
                return Long.MAX_VALUE;
            }
            if (hi[i]<=b && lo[i]>=a){
                return min[i]+delta[i];
            }
            propagate(i);
            long minLeft=minimum(2*i,a,b);
            long minRight=minimum(2*i+1,a,b);
            update(i);
            return Math.min(minLeft,minRight);
        }

    }

}