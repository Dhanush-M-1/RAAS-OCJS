import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    void solve() {
        int n=ni();
        a=new long[n+1];
        for(int i=1;i<=n;i++) a[i]=nl();
        tree=new Node[4*n+1];
        lazy=new long[4*n+1];

        build(1,1,n);
        int ans[]=new int[n+1];
        for(int i=1;i<=n;i++){
            int id=query(1,1,n,1,n).id;
            update(1,id,id,1,n,Long.MAX_VALUE);
            update(1,id+1,n,1,n,-i);
            ans[id]=i;


        }
        for(int i=1;i<=n;i++) pw.print(ans[i]+" ");
        pw.println("");
    }
    long a[];
    long lazy[];
    Node tree[];
    void build(int id,int l,int r){
        if(l==r){
            tree[id]=new Node(l,a[l]);
        }else {
            int mid=(l+r)>>1;
            build(2*id,l,mid);
            build(2*id+1,mid+1,r);
            merge(id);
        }
    }
    void update(int id,int x,int y,int l,int r,long val){
        if(x>y) return;
        push(id,l,r);
        if(r<x || l>y) return;
        if(x<=l && r<=y){
            tree[id].val+=val;
            if(l!=r){
                lazy[2*id]+=val;
                lazy[2*id+1]+=val;
            }
            return;
        }
        int mid=(l+r)>>1;
        update(2*id,x,y,l,mid,val);
        update(2*id+1,x,y,mid+1,r,val);
        merge(id);
    }
    Node query(int id,int x,int y,int l,int r){
        push(id,l,r);
        if(r<x || l>y) return new Node(Integer.MAX_VALUE,Long.MAX_VALUE);
        if(x<=l && r<=y) return tree[id];
        int mid=(l+r)>>1;
        Node nd1=query(2*id,x,y,l,mid);
        Node nd2=query(2*id+1,x,y,mid+1,r);
        if(nd1.val<nd2.val) return nd1;
        else if(nd1.val>nd2.val) return nd2;

        return new Node(Math.max(nd1.id,nd2.id),nd1.val);

    }

    void push(int id,int l,int r){
        if(lazy[id]==0) return;
        tree[id].val+=lazy[id];
        if(l!=r){
            lazy[2*id]+=lazy[id];
            lazy[2*id+1]+=lazy[id];
        }
        lazy[id]=0;
    }

    void merge(int id){

        if(tree[2*id].val<tree[2*id+1].val){
            tree[id]=new Node(tree[2*id].id,tree[2*id].val);
        }else if(tree[2*id].val>tree[2*id+1].val){
            tree[id]=new Node(tree[2*id+1].id,tree[2*id+1].val);
        }else tree[id]=new Node(Math.max(tree[2*id].id,tree[2*id+1].id),tree[2*id].val);
    }
    class Node {
        int id;
        long val;
        public Node(int id,long val){
            this.id=id;
            this.val=val;
        }
    }
    long M = (long)1e9+7;

    // END
    PrintWriter pw;
    StringTokenizer st;
    BufferedReader br;

    void run() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
    }
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    String ns() {
        while (st == null || !st.hasMoreElements()) {

            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    String nextLine() throws Exception {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            throw new Exception(e.toString());
        }
        return str;
    }

    int ni() {
        return Integer.parseInt(ns());
    }

    long nl() {
        return Long.parseLong(ns());
    }

    double nd() {
        return Double.parseDouble(ns());
    }
}