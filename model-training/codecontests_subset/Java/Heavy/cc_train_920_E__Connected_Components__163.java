
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
public class Temp {
    static PrintWriter w = new PrintWriter(System.out);
    static int n,m;
    static TreeSet<Integer> arr[],un;
    static ArrayList<Integer> ans;
    static void dfs(int c,TreeSet<Integer>te){
        un.remove(c);
        te.add(c);
        ArrayList<Integer> v=new ArrayList<Integer>(); 
        for(int x:un)
            if(!arr[c].contains(x))
                v.add(x);
        for(int u:v)un.remove(u);
        for(int u:v)dfs(u,te);
    }
    
    
    public static void main (String[] args)throws IOException{
        Scanner sc=new Scanner(System.in);
       
    	n=sc.nextInt();
        m=sc.nextInt();
        arr=new TreeSet[n+1];
        un=new TreeSet<Integer>();
        ans=new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            un.add(i);
            arr[i]=new TreeSet<Integer>();
        }
      	for(int i=0;i<m;i++){
            int u=sc.nextInt(),v=sc.nextInt();
            arr[u].add(v);
            arr[v].add(u);   
        }
        for(int i=1;i<=n;i++){
            if(un.contains(i)){
                TreeSet<Integer> te=new TreeSet<>();
                dfs(i,te);
                
                ans.add(te.size());
               
            }
        }
        w.println(ans.size());
        Collections.sort(ans);
        for(int i:ans){
            w.print(i+" ");
        }
        w.println();
    	w.close();
    }
}