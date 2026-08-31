import java.math.*;
import java.io.*;
import java.util.*;
public class C635D
{
   public static long[] cAr, div;
   public static int N,K,A,B,Q;
   public static int[] numCycle;
   public static Map<Integer,Set<Integer>> map;
   public static long MOD = 1000000007;
   public static void main(String[] args) throws IOException{
      InputReader in=new InputReader(new InputStreamReader(System.in));
      //InputReader in=new InputReader(new FileReader("test.in"));
      PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out));
      int[] ar=in.nextIntAr();
      N=ar[0]; K=ar[1]; A=ar[2]; B=ar[3]; Q=ar[4];
      ar=new int[N];
      SegmentTree sumBefore=new SegmentTree(ar);
      SegmentTree sumAfter=new SegmentTree(ar);
      for(int x=0;x<Q;x++){
         int[] ar1=in.nextIntAr();
         int q=ar1[0];
         switch(q){
            case (1):
               {
                  int d=ar1[1]-1;
                  int a=ar1[2];
                  ar[d]+=a;
               
                  sumBefore.update(d,d,Math.min(ar[d],B));
                  sumAfter.update(d,d,Math.min(ar[d],A));
                  break;
               }
            case (2):
               {
                  int p=ar1[1]-1;
                  int total=0;
                  if(p>0)
                     total=sumBefore.RSQ(0,p-1);
                  if(p+K<N)
                     total+=sumAfter.RSQ(p+K,N-1);
                  out.println(total);
                  break;
               }
         }
      }
      out.close();
   }
   
   public static void setUpChoose(int t){
      cAr=new long[t+1];
      div=new long[t+1];
      cAr[0]=1;
      div[0]=1;
      
      for(int x=1;x<=t;x++){
         cAr[x]=(x*cAr[x-1])%(MOD);
         div[x]=pow(cAr[x],MOD-2);} 
   }
   
   public static long choose(int x,int y){
      long a=cAr[x+y];
      long b=div[x];
      long c=div[y];
      a=(a*b)%MOD;
      a=(a*c)%MOD;
      return a;
   } 
   
   public static long pow(long a,long b){
      if(b==1) 
         return a;
      long c=b/2;
      long temp=pow(a,c)%MOD;
      temp=(temp*temp)%MOD;
      if(b%2==1) temp=temp*a;
      return temp%MOD;
   }
}

class InputReader{
   private BufferedReader br;
   public InputReader(InputStreamReader in){
      br=new BufferedReader(in);
   }
   public int nextInt(){
      try{
         return Integer.parseInt(br.readLine());}
      catch(IOException e){throw new InputMismatchException();}
   }
   public int[] nextIntAr(){
      try{
         String[] s=br.readLine().split(" ");
         int[] ret=new int[s.length];
         for(int x=0;x<s.length;x++)
            ret[x]=Integer.parseInt(s[x]);
         return ret;}
         
      catch(IOException e){throw new InputMismatchException();}
   }
   
   public long nextLong(){
      try{
         return Long.parseLong(br.readLine());}
      catch(IOException e){throw new InputMismatchException();}
   }
   public long[] nextLongAr(){
      try{
         String[] s=br.readLine().split(" ");
         long[] ret=new long[s.length];
         for(int x=0;x<s.length;x++)
            ret[x]=Long.parseLong(s[x]);
         return ret;}
         
      catch(IOException e){throw new InputMismatchException();}
   }
   
   public String[] nextStringAr(){
      try{
         return br.readLine().split(" ");}
         
      catch(IOException e){throw new InputMismatchException();}
   }
   
   public String nextString(){
      try{
         return br.readLine();}
         
      catch(IOException e){throw new InputMismatchException();}
   }
}
   
class Pair implements Comparable<Pair>{
   long a;
   long b;
   
   public Pair(long ma, long mb){
      a = ma;
      b = mb;
   }
   
   public int compareTo(Pair o){
      if(a == o.a){
         if(b==o.b) 
            return 0;
         return b<o.b?-1:1;
      }
      return a<o.a?-1:1;
   }
}
class SegmentTree {

   private Node[] heap;
   private int[] array;
   private int size;

    /**
     * Time-Complexity:  O(n*log(n))
     *
     * @param array the Initialization array
     */
   public SegmentTree(int[] array) {
      this.array = Arrays.copyOf(array, array.length);
        //The max size of this array is about 2 * 2 ^ log2(n) + 1
      size = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double) array.length) / Math.log(2.0)) + 1)));
      heap = new Node[size];
      build(1, 0, array.length);
   }


   public int size() {
      return array.length;
   }

    //Initialize the Nodes of the Segment tree
   private void build(int v, int from, int size) {
      heap[v] = new Node();
      heap[v].from = from;
      heap[v].to = from + size - 1;
   
      if (size == 1) {
         heap[v].sum = array[from];
         heap[v].min = array[from];
      } 
      else {
            //Build childs
         build(2 * v, from, size / 2);
         build(2 * v + 1, from + size / 2, size - size / 2);
      
         heap[v].sum = heap[2 * v].sum + heap[2 * v + 1].sum;
            //min = min of the children
         heap[v].min = Math.min(heap[2 * v].min, heap[2 * v + 1].min);
      }
   }

    /**
     * Range Sum Query
     *
     * Time-Complexity: O(log(n))
     */
   public int RSQ(int from, int to) {
      return RSQ(1, from, to);
   }

   private int RSQ(int v, int from, int to) {
      Node n = heap[v];
   
        //If you did a range update that contained this node, you can infer the Sum without going down the tree
      if (n.pendingVal != null && contains(n.from, n.to, from, to)) {
         return (to - from + 1) * n.pendingVal;
      }
   
      if (contains(from, to, n.from, n.to)) {
         return heap[v].sum;
      }
   
      if (intersects(from, to, n.from, n.to)) {
         propagate(v);
         int leftSum = RSQ(2 * v, from, to);
         int rightSum = RSQ(2 * v + 1, from, to);
      
         return leftSum + rightSum;
      }
   
      return 0;
   }

    /**
     * Range Update Operation.
     * With this operation you can update either one position or a range of positions with a given number.
     * The update operations will update the less it can to update the whole range (Lazy Propagation).
     * The values will be propagated lazily from top to bottom of the segment tree.
     * This behavior is really useful for updates on portions of the array
     * <p/>
     * Time-Complexity: O(log(n))
     *
     * @param from
     * @param to
     * @param value
     */
   public void update(int from, int to, int value) {
      update(1, from, to, value);
   }

   private void update(int v, int from, int to, int value) {
   
        //The Node of the heap tree represents a range of the array with bounds: [n.from, n.to]
      Node n = heap[v];
   
        /**
         * If the updating-range contains the portion of the current Node  We lazily update it.
         * This means We do NOT update each position of the vector, but update only some temporal
         * values into the Node; such values into the Node will be propagated down to its children only when they need to.
         */
      if (contains(from, to, n.from, n.to)) {
         change(n, value);
      }
   
      if (n.size() == 1) 
         return;
   
      if (intersects(from, to, n.from, n.to)) {
            /**
             * Before keeping going down to the tree We need to propagate the
             * the values that have been temporally/lazily saved into this Node to its children
             * So that when We visit them the values  are properly updated
             */
         propagate(v);
      
         update(2 * v, from, to, value);
         update(2 * v + 1, from, to, value);
      
         n.sum = heap[2 * v].sum + heap[2 * v + 1].sum;
         n.min = Math.min(heap[2 * v].min, heap[2 * v + 1].min);
      }
   }

   private void propagate(int v) {
      Node n = heap[v];
   
      if (n.pendingVal != null) {
         change(heap[2 * v], n.pendingVal);
         change(heap[2 * v + 1], n.pendingVal);
         n.pendingVal = null; //unset the pending propagation value
      }
   }

   private void change(Node n, int value) {
      n.pendingVal = value;
      n.sum = n.size() * value;
      n.min = value;
      array[n.from] = value;
   
   }

    //Test if the range1 contains range2
   private boolean contains(int from1, int to1, int from2, int to2) {
      return from2 >= from1 && to2 <= to1;
   }

    //check inclusive intersection, test if range1[from1, to1] intersects range2[from2, to2]
   private boolean intersects(int from1, int to1, int from2, int to2) {
      return from1 <= from2 && to1 >= from2   //  (.[..)..] or (.[...]..)
                || from1 >= from2 && from1 <= to2; // [.(..]..) or [..(..)..
   }
}
    //The Node class represents a partition range of the array.
class Node {
   int sum;
   int min;
   Integer pendingVal = null;
   int from;
   int to;
   
   int size() {
      return to - from + 1;
   }
   
}