// package Quarantine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RestorePermutation {
    public static void update(long tree[],long lazy[],int s,int e,int l,int r,long val,int node){
        if(lazy[node]!=0){
            tree[node]+=lazy[node];
            if(s!=e){
                lazy[2*node]+=lazy[node];
                lazy[2*node+1]+=lazy[node];
            }
            lazy[node]=0;
        }
        if(s>r||e<l){
            return;
        }
        if(s>=l&&e<=r){
            tree[node]+=val;
            if(s!=e){
                lazy[2*node]+=val;
                lazy[2*node+1]+=val;
            }
            return;
        }
        int mid=(s+e)/2;
        update(tree,lazy,s,mid,l,r,val,2*node);
        update(tree,lazy,mid+1,e,l,r,val,2*node+1);
        tree[node]=Math.min(tree[2*node],tree[2*node+1]);
        return;
    }
    public static long query(long tree[],long lazy[],int s ,int e,int l,int r,int node){
        if(lazy[node]!=0){
            tree[node]+=lazy[node];
            if(s!=e){
                lazy[2*node]+=lazy[node];
                lazy[2*node+1]+=lazy[node];
            }
            lazy[node]=0;
        }
        if(s>r||e<l){
            return Long.MAX_VALUE;
        }
        if(s>=l&&e<=r){
            return tree[node];
        }
        int mid=(s+e)/2;
        long left=query(tree,lazy,s,mid,l,r,2*node);
        long right=query(tree,lazy,mid+1,e,l,r,2*node+1);
        return Math.min(left,right);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        long a[]=new long[n+1];
        for(int i=1;i<=n;i++){
            a[i]=Long.parseLong(st.nextToken());
        }
        int ans[]=new int[n+1];
        long tree[]=new long[4*n+4];
        long lazy[]=new long[4*n+4];
        long infinity=(long)Math.pow(10,11);
        for(int i=1;i<=n;i++){
            update(tree,lazy,1,n,i,i,a[i],1);
        }
        for(int i=1;i<=n;i++){
            int low=1,high=n;
            int reqd=1;
            while(low<=high){
                int mid=(low+high)/2;
                if(query(tree,lazy,1,n,mid,high,1)==0){
                    reqd=mid;
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
//            System.out.println(reqd);
            ans[reqd]=i;
            update(tree,lazy,1,n,reqd+1,n,-i,1);
            update(tree,lazy,1,n,reqd,reqd,infinity,1);
        }
        StringBuilder print=new StringBuilder();
        for(int i=1;i<=n;i++){
            print.append(ans[i]+" ");
        }
        System.out.println(print.toString());
    }
}
