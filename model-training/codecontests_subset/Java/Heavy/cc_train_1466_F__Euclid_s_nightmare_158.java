// package NickMikeMurderers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EuclidNightmare {
    public static int findPar(int v,int par[]){
        if(par[v]==v){
            return v;
        }
        int p=findPar(par[v],par);
        par[v]=p;
        return p;
    }
    public static void union(int u,int v,int par[],int size[]){
        int p1=findPar(u,par);
        int p2=findPar(v,par);
        if(size[p1]>=size[p2]){
            size[p1]+=size[p2];
            par[p2]=p1;
        }
        else{
            size[p2]+=size[p1];
            par[p1]=p2;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder print=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int par[]=new int[m+1];
        int size[]=new int[m+1];
        for(int i=0;i<=m;i++){
            par[i]=i;
            size[i]=1;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            int k=Integer.parseInt(st.nextToken());
            int x,y;
            if(k==1){
                x=0;
                y=Integer.parseInt(st.nextToken());
            }
            else{
                x=Integer.parseInt(st.nextToken());
                y=Integer.parseInt(st.nextToken());
            }
            int p1=findPar(x,par);
            int p2=findPar(y,par);
            if(p1!=p2){
                ans.add(i);
                union(x,y,par,size);
            }
        }
        long t=1;
        int mod=1000000007;
        for(int i=0;i<=m;i++){
            if(par[i]==i){
                long temp=modexp(2,size[i]-1,mod);
                t=(t*temp)%mod;
            }
        }
        print.append(t).append(" ").append(ans.size()).append("\n");
        for(int i:ans){
            print.append(i+" ");
        }
        System.out.println(print.toString());
    }
    public static long modexp(long a,long power,int mod){
        if(power==0){
            return 1;
        }
        if(power==1){
            return a;
        }
        long small=modexp(a,power/2,mod);
        long ans=(small%mod*small%mod)%mod;
        if(power%2!=0){
            ans=(ans%mod*a%mod)%mod;
        }
        return ans;
    }
}
