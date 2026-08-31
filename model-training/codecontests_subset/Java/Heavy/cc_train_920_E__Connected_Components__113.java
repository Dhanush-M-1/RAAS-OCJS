
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
public class Temp {
    static PrintWriter w = new PrintWriter(System.out);
    static int n,m,p[],r[],d[];
    static TreeSet<Integer> arr[];
    static int find(int a){
        if(p[a]==a)return a;
        return p[a]=find(p[a]);
    }
    static void union(int a,int b){
        int x=find(a);
        int y=find(b);
        if(x==y)return;
        if(r[x]>=r[y]){
            p[y]=a;
            r[x]+=r[y];
        }
        else{
            p[x]=y;
            r[y]+=r[x];
        }
    }
    
    public static void main (String[] args)throws IOException{
        Scanner sc=new Scanner(System.in);
       
    	n=sc.nextInt();
        m=sc.nextInt();
        p=new int[n+1];
        r=new int[n+1];
        d=new int[n+1];
        arr=new TreeSet[n+1];
        for(int i=1;i<=n;i++){
            p[i]=i;
            r[i]=1;
            d[i]=n-1;
            arr[i]=new TreeSet<Integer>();
        }
      	for(int i=0;i<m;i++){
            int u=sc.nextInt(),v=sc.nextInt();
            arr[u].add(v);
            arr[v].add(u);  
            d[u]--;d[v]--;
        }
        ArrayList<Integer> ar=new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            if((2*d[i])>n)ar.add(i);
        }
        for(int i=0;i<ar.size()-1;i++){
            union(ar.get(i),ar.get(i+1));
        }
        for(int i=1;i<=n;i++){
            if((2*d[i])<=n){
                for(int j=1;j<=n;j++){
                    if(!arr[i].contains(j)){
                        union(i,j);
                    }
                }
            }
        }
        ArrayList<Integer> t=new ArrayList<Integer>();
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=1;i<=n;i++){
            int p=find(i);
            if(map.containsKey(p)){
                ArrayList<Integer> te=map.get(p);
                te.add(i);
                map.replace(p, te);
            }
            else{
                map.put(p,new ArrayList<Integer>(Arrays.asList(i)));
            }
        }
        w.println(map.size());
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int k:map.keySet()){
            ans.add(map.get(k).size());   
        }
        Collections.sort(ans);
        for(int i=0;i<ans.size();i++)w.print(ans.get(i)+" ");
        w.println();
    	w.close();
    }
}