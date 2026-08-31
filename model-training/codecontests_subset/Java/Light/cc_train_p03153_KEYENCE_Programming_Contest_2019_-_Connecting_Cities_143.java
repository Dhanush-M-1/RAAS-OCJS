import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Node[] plusTree, minusTree; // plus records A+Di, minus records A-Di
    Node maxiNode;
    int N=1;
    int[] id;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
//        main.solve();
//        out.flush();
        System.out.println(main.solve());
    }
    long solve() throws IOException {
        Long INF = Long.MAX_VALUE/2;
        maxiNode = new Node(INF,-1);
        String[] buf = reader.readLine().split(" ");
        int n = Integer.parseInt(buf[0]); long D = Long.parseLong(buf[1]);
        while(N<n) N *= 2;
        plusTree = new Node[2*N-1]; minusTree = new Node[2*N-1];
        for(int i=0;i<2*N-1;i++){
            plusTree[i] = new Node(INF,-1);
            minusTree[i] = new Node(INF,-1);
        }
        buf = reader.readLine().split(" ");
        long[] arr = new long[n];
        int[][] idxVal = new int[n][];
        for(int i=0;i<n;i++) {
            int cur = Integer.parseInt(buf[i]);
            arr[i]=cur;
            idxVal[i] = new int[]{i,cur};
            update(i,INF,plusTree);
            update(i,INF,minusTree);
        }
        Arrays.sort(idxVal,Comparator.comparingInt(e->e[1]));
        PriorityQueue<Edge> pq = new PriorityQueue<>(2*n);
        TreeSet<Integer> used = new TreeSet<>();
        for(int i=0;i<n;i++){
            int[] cur = idxVal[i];
            int idx = cur[0]; long val = cur[1];
            Integer left = used.lower(idx), right = used.higher(idx);
            if(left!=null){
                Node node = query(0,0,idx-1,0,N-1,minusTree);
                long weight = node.val+idx*D+val;
                pq.add(new Edge(node.minIdx,idx,weight));
            }
            if(right!=null){
                Node node = query(0,idx+1,n-1,0,N-1,plusTree);
                long weight = node.val-idx*D+val;
                pq.add(new Edge(node.minIdx,idx,weight));
            }
            update(idx,val+idx*D,plusTree);
            update(idx,val-idx*D,minusTree);
            used.add(idx);
        }
        id = new int[n];
        for(int i=0;i<n;i++) id[i]=i;
        long ans = 0;
        while(pq.size()>0){
            Edge e = pq.poll();
            int i = find(e.from), j = find(e.to);
            if(i==j) continue;
            ans += e.weight;
            join(i,j);
        }
        return ans;
    }
    Node query(int k, int qStart, int qEnd, int nStart, int nEnd, Node[] seg){
        if(qEnd<nStart || nEnd<qStart) return maxiNode;
        if(qStart <= nStart && nEnd <= qEnd) return seg[k];
        int mid = (nStart+nEnd)/2;
        Node left = query(2*k+1,qStart,qEnd,nStart,mid,seg);
        Node right = query(2*k+2,qStart,qEnd,mid+1,nEnd,seg);
        if(left.val<right.val) return left;
        else return right;
    }
    void update(int k, long newVal, Node[] seg){
        // here update is to change the exact value of single point
        // instead of in the lazy tag case
        k += N-1;
        seg[k].val = newVal;
        seg[k].minIdx = k-(N-1);
        while(k>0){
            k = (k-1)/2;
            Node left = seg[2*k+1], right = seg[2*k+2], son;
            if(left.val<=right.val) son = left;
            else son = right;
            seg[k].val = son.val; seg[k].minIdx = son.minIdx;
        }
    }
    class Node{
        int minIdx;
        long val;
        public Node(long v, int i){val=v;minIdx=i;}
        public Node(){}
    }
    class Edge implements Comparable<Edge>{
        int from,to;
        long weight;
        public Edge(int f, int t, long w){from=f;to=t;weight=w;}
        public int compareTo(Edge e){
            return Long.compare(weight,e.weight);
        }
    }
    int find(int p){
        while(p!=id[p]){
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
    void join(int p, int q){
        int i = find(p), j = find(q);
        if(i!=j) id[i]=j;
    }
}

