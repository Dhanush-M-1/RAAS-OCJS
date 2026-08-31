import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Test {
    
    static BufferedReader in;
    static class Node{
        int val;
        int depth;
        Node(int val, int depth){
            this.val = val;
            this.depth = depth;
        }
    }
    static void make(Node a[],int i,int j, int depth){
        if(i > j) return;

        int m = i;
        for(int k = i; k <= j; k++){
            if(a[m].val < a[k].val)
                m = k;
        }
        a[m].depth = depth;
        make(a, i, m-1, depth+1);
        make(a,m+1,j ,depth+1);

    }
    public static void solve() throws Exception{
       int n = Integer.parseInt(in.readLine());
       Node[] a = new Node[n];
       String s[] = in.readLine().split(" ");
       for(int i = 0; i < n; i++){
           a[i] = new Node(Integer.parseInt(s[i]),0);
       }
       make(a,0,n-1,0);
       StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
            sb.append(a[i].depth+" ");
        System.out.println(sb.toString());
    }   
    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            solve();
        }
 


    }
}