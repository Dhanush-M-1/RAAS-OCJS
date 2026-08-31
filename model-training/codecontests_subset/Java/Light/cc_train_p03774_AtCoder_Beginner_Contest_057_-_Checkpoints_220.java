import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i=0;i<n;i++){
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }
    int[] c = new int[m];
    int[] d = new int[m];
    for (int i=0;i<m;i++){
      c[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }
    sc.close();
    int ans;
    int length;
    int dlength;
    for (int i=0;i<n;i++){
      ans = 0;
      length = 1000000000;
      for (int j=0;j<m;j++){
        dlength = Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]);
        if (length > dlength){
          ans = j+1;
          length = dlength;
        }
      }
      System.out.println(ans);
    }
  }
}