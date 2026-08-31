import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class D {
  // Modify the following 5 methods to implement your custom operations on the tree.
 // This example implements Add/Max operations. Operations like Add/Sum, Set/Max can also be implemented.
long modifyOperation(long x, long y) {
   return x + y;
 }

 // query (or combine) operation
long queryOperation(long leftValue, long rightValue) {
   return Math.min(leftValue, rightValue);
 }

long deltaEffectOnSegment(long delta, int segmentLength) {
   // Here you must write a fast equivalent of following slow code:
   // int result = delta;
   // for (int i = 1; i < segmentLength; i++) result = queryOperation(result, delta);
   // return result;
   return delta;
 }

long getNeutralDelta() {
   return 100000L*100000L*100000L;
 }

 long getInitValue() {
   return getNeutralDelta();
 }

 // generic code
 int n;
 public static long[] a;
 long[] value;
 long[] delta; // delta[i] affects value[i], delta[2*i+1] and delta[2*i+2]

 long joinValueWithDelta(long value, long delta) {
   if (delta == getNeutralDelta()) return value;
   return modifyOperation(value, delta);
 }

  long joinDeltas(long delta1, long delta2) {
   if (delta1 == getNeutralDelta()) return delta2;
   if (delta2 == getNeutralDelta()) return delta1;
   return modifyOperation(delta1, delta2);
 }

 void pushDelta(int root, int left, int right) {
   value[root] = joinValueWithDelta(value[root], deltaEffectOnSegment(delta[root], right - left + 1));
   if(left!=right) {
   delta[2 * root + 1] = joinDeltas(delta[2 * root + 1], delta[root]);
   delta[2 * root + 2] = joinDeltas(delta[2 * root + 2], delta[root]);
  }
   delta[root] = getNeutralDelta();
 }

 public D(int n) {
   this.n = n;
   value = new long[4 * n];
   delta = new long[4 * n];
   init(0, 0, n - 1);
 }

 void init(int root, int left, int right) {
   if (left == right) {
     value[root] = a[left];
     delta[root] = getNeutralDelta();
   } else {
     int mid = (left + right) >> 1;
     init(2 * root + 1, left, mid);
     init(2 * root + 2, mid + 1, right);
     value[root] = queryOperation(value[2 * root + 1], value[2 * root + 2]);
     delta[root] = getNeutralDelta();
   }
 }

 public long query(int from, int to) {
   return query(from, to, 0, 0, n - 1);
 }

 public int indexOfMin() {
   int start = 0; int left = 0; int right = n-1;
   pushDelta(start, left, right);
   while(left != right) {
      pushDelta(2*start+1, left, (left+right)/2);
      pushDelta(2*start+2, (left+right)/2+1, right);
     if(value[2*start+1] < value[2*start+2]) {
       start=2*start+1;
       right = (left+right)/2;
     }
     else {
       start=2*start+2;
       left=(left+right)/2+1;
     }
   }
   return left;

 }
 long query(int from, int to, int root, int left, int right) {
   if (from == left && to == right)
     return joinValueWithDelta(value[root], deltaEffectOnSegment(delta[root], right - left + 1));
   pushDelta(root, left, right);
   int mid = (left + right) >> 1;
   if (from <= mid && to > mid)
     return queryOperation(
         query(from, Math.min(to, mid), root * 2 + 1, left, mid),
         query(Math.max(from, mid + 1), to, root * 2 + 2, mid + 1, right));
   else if (from <= mid)
     return query(from, Math.min(to, mid), root * 2 + 1, left, mid);
   else if (to > mid)
     return query(Math.max(from, mid + 1), to, root * 2 + 2, mid + 1, right);
   else
     throw new RuntimeException("Incorrect query from " + from + " to " + to);
 }

 public void modify(int from, int to, long delta) {
   modify(from, to, delta, 0, 0, n - 1);
 }

 void modify(int from, int to, long delta, int root, int left, int right) {
   if (from == left && to == right) {
     this.delta[root] = joinDeltas(this.delta[root], delta);
     return;
   }
   pushDelta(root, left, right);
   int mid = (left + right) >> 1;
   if (from <= mid)
     modify(from, Math.min(to, mid), delta, 2 * root + 1, left, mid);
   if (to > mid)
     modify(Math.max(from, mid + 1), to, delta, 2 * root + 2, mid + 1, right);
   value[root] = queryOperation(
       joinValueWithDelta(value[2 * root + 1], deltaEffectOnSegment(this.delta[2 * root + 1], mid - left + 1)),
       joinValueWithDelta(value[2 * root + 2], deltaEffectOnSegment(this.delta[2 * root + 2], right - mid)));
 }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = new long[n]; for(int i=0; i<n; i++) a[i] = Long.parseLong(st.nextToken());
        // int n = Integer.parseInt(st.nextToken());
        D segtree = new D(n);
        int[] ans = new int[n];
        int cur = 1;
        for(int i=0; i<n; i++) {
          int index = segtree.indexOfMin();
        //  out.println(":"+index+ " " + segtree.query(index, index));
          ans[index] = cur;
        //  out.println(index);
          if(index+1 <= n-1) segtree.modify(index+1, n-1, -1*cur);
          segtree.modify(index, index, 1L*10000*10000*10000);
          cur++;
        }

        StringBuilder anss = new StringBuilder();
        for(int i=0; i<n; i++) anss.append(ans[i]+" ");
        out.println(anss.toString());
        out.close(); System.exit(0);
    }
}
