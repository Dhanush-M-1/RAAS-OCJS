import java.util.*;
public class cf252b {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] v = new int[n];
    for(int i=0; i<n; i++)
      v[i] = in.nextInt();
    int a = 0;
    int b = a;
    while(b < n-1 && v[a] == v[b]) b++;
    int c = b;
    while(c < n && (v[a]==v[c] || v[b]==v[c])) c++;
    if(c == n) c=a+1;
    if(c == b) c++;
    if(c == n) c--;
    if(ok(v,a,b)) {
      System.out.println((a+1) + " " + (b+1));
      return;
    }
    if(ok(v,b,c)) {
      System.out.println((b+1) + " " + (c+1));
      return;
    }
    if(ok(v,a,c)) {
      System.out.println((a+1) + " " + (c+1));
      return;
    }
    System.out.println(-1);
  }
  static boolean ok(int[] v, int a, int b) {
    if(v[a] == v[b]) return false;
    int tmp = v[a];
    v[a] = v[b];
    v[b] = tmp;
    boolean ret = isSorted(v);
    tmp = v[a];
    v[a] = v[b];
    v[b] = tmp;
    return !ret;
  }
  static boolean isSorted(int[] v) {
    return isInc(v) || isDec(v);
  }
  static boolean isInc(int[] v) {
    for(int i=1; i<v.length; i++)
      if(v[i] < v[i-1])
        return false;
    return true;
  }
  static boolean isDec(int[] v) {
    for(int i=1; i<v.length; i++)
      if(v[i] > v[i-1])
        return false;
    return true;
  }
}
