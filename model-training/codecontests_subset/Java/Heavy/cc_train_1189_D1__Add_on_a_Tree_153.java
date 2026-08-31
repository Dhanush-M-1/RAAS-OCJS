
/*
9 2
        1 1 1 1 1 0 0 0 0
        1 2
        1 5
        5 6
        5 7
        2 3
        2 4
        3 8
        3 9
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Question {
    static int[][] arr;
    static LinkedList[] adj;
    static boolean visited[];
    static boolean ans = true;
    public static void main (String[] args) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        int[] arr = new int[n];
        adj = new LinkedList[n+1];
        visited = new boolean[n+1];
        for (int i = 1 ; i < n+1 ; i++){
            adj[i] = new LinkedList<>();
        }

        for (int i = 0 ; i < n-1 ; i++){
            int n1= Reader.nextInt();
            int n2 = Reader.nextInt();
            adj[n1].addLast(n2);
            adj[n2].addLast(n1);
        }
        int leaf = 0;
        for (int i = 1 ; i <=n ; i++){
            if (adj[i].size()==1){
                leaf = i;
                break;
            }
        }
        DFSUtil(leaf,0);
        if (ans){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }






    }

    static void DFSUtil(int v , int num)
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        //System.out.print(v+" ");
        if (adj[v].size()==2 && num==1){
            ans&=false;
        }

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n,1);
        }
    }


}

/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
/*
ArrayList<ArrayList<Integer>> list: to represent graph containing 'v'
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
    static int ans = 0;
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        ans = 0;
        for(int i = 0  ; i < V  ; i++){
            dfs(i , new boolean[V],list,new boolean[V]);
            if(ans==1){
                return true;
            }
        }
        return false;
    }

    static void dfs(int src , boolean[] visited,ArrayList<ArrayList<Integer>> list,boolean[] stack){
        if(stack[src]==true){
            ans = 1;
            return;
        }
        if (visited[src]){
            return;
        }
        stack[src] = true;
        visited[src] = true;
        for(int i = 0 ; i < list.get(src).size() ;i++){
            //int ans = 0;
            int n = list.get(src).get(i);
            if(!visited[n]){
                dfs(n,visited , list,stack);
            }
            else{
                System.out.println(n);
                ans = 1;
            }

        }
        stack[src] = false;

    }





    static void colSwap(int[][] arr , int x , int y,int m , int n){
        for (int i = 0 ; i < n ; i++){
            int temp = arr[i][x];
            arr[i][x] = arr[i][y];
            arr[i][y] = temp;
        }
    }






    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}

class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
}

class Node{
    int data;
    int freq;

    public Node(int data, int freq) {
        this.data = data;
        this.freq = freq;
    }

}
class GFG {

    // limit for array size
    static int N = 1000000;

    static int n; // array size

    // Max size of tree
    static int []tree = new int[2 * N];

    // function to build the tree
    static void build( char []arr,int n)
    {

        // insert leaf nodes in tree
        for (int i = 0; i < n-1; i++) {
            if (arr[i]!=arr[i+1]) {
                System.out.println(i);
                tree[n + i] = 1;
            }
        }

        // build the tree by calculating
        // parents
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i << 1] +
                    tree[i << 1 | 1];
    }

    static int query(int l, int r)
    {
        int res = 0;

        // loop to find the sum in the range
        for (l += n, r += n; l < r;
             l >>= 1, r >>= 1)
        {
            if ((l & 1) > 0)
                res += tree[l++];

            if ((r & 1) > 0)
                res += tree[--r];
        }

        return res;
    }

    // driver program to test the
    // above function

}

class SegmentTree{
    int[] arr ;
    int[] tree;

    SegmentTree(int[] arr ,int  n){
        this.arr = arr;
        tree = new int[2*n];
    }

    void updateRangeUtil(int si, int ss, int se, int us,
                         int ue, int val)
    {

        if (ss>se || ss>ue || se<us)
            return ;


        if (ss==se)
        {
            tree[si] |= val;
            return;
        }

        int mid = (ss+se)/2;
        updateRangeUtil(si*2+1, ss, mid, us, ue, val);
        updateRangeUtil(si*2+2, mid+1, se, us, ue, val);

        tree[si] = tree[si*2+1] + tree[si*2+2];
    }

    void constructSTUtil(int ss, int se, int si)
    {
        // out of range as ss can never be greater than se
        if (ss > se)
            return ;

        // If there is one element in array, store it in
        // current node of segment tree and return
        if (ss == se)
        {
            //tree[si] = arr[ss];
            System.out.println(tree[si]);
            return;
        }

        // If there are more than one elements, then recur
        // for left and right subtrees and store the sum
        // of values in this node
        int mid = (ss + se)/2;
        constructSTUtil(ss, mid, si*2+1);
        constructSTUtil(mid+1, se, si*2+2);

        //tree[si] = tree[si*2 + 1] + tree[si*2 + 2];
    }

}

class Heap{
    int[] Heap;
    int size;
    int maxSize;

    public Heap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[maxSize + 1];
        Heap[0] = Integer.MIN_VALUE;

    }

    int parent(int pos){
        return pos/2;
    }
    int left(int pos){
        return 2*pos;
    }
    int right(int pos){
        return 2*pos + 1;
    }

    boolean isLeaf(int pos){
        if (pos>=size/2 && pos<=size){
            return true;
        }
        return false;
    }

    void swap(int i , int j){
        int temp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j]= temp;
    }

    void minHeapify(int pos){
        if (!isLeaf(pos)){
            if (Heap[pos]>Heap[left(pos)] || Heap[pos] > Heap[right(pos)]){
                if (Heap[left(pos)] < Heap[right(pos)]) {
                    swap(pos, left(pos));
                    minHeapify(left(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, right(pos));
                    minHeapify(right(pos));
                }
            }
        }
    }

}

class Graph{



}
class DijkstraNode implements  Comparator<DijkstraNode>{
    public int node;
    public int cost;
    public int[] visited;
    public boolean[] settled;

    public DijkstraNode(int node, int cost,int vertices) {
        this.node = node;
        this.cost = cost;
        visited = new int[vertices];
        settled = new boolean[vertices];
    }

    @Override
    public int compare(DijkstraNode node1 , DijkstraNode node2){
        if (node1.cost < node2.cost){
            return -1;
        }
        if (node1.cost > node2.cost){
            return 1;
        }
        return 0;
    }


    ArrayList<Integer> list = new ArrayList<>(10000);


}


