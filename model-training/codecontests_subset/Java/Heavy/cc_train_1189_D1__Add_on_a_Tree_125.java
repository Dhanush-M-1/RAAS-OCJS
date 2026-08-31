import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;

public class Main {
    int flag=1; 
    public void dfs(ArrayList<Integer>[] tree,int[] visited,int s) {
            visited[s]=1;
            int count=0;
            for(int i:tree[s]) {
                if(visited[i]==0) {
                    count++;
                    this.dfs(tree, visited, i);
                }
            }
            if(count==1) {
                flag=0;
            }
        }
    public static void main(String[] args) throws Exception{
        FastReader sc=new FastReader(); 
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        Main mm=new Main();
        int n=sc.nextInt();
        ArrayList<Integer>[] tree=new ArrayList[n];
        for(int i=0;i<n;i++) {
            tree[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<n-1;i++) {
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            tree[a].add(b);
            tree[b].add(a);
        }
        int flag=1;
        for(int i=0;i<n;i++) {
            if(tree[i].size()==2) {
                flag=0;
                break;
            }
        }
        if(flag==1) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }  
}

class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
        br = new BufferedReader(new
                 InputStreamReader(System.in)); 
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
} 

