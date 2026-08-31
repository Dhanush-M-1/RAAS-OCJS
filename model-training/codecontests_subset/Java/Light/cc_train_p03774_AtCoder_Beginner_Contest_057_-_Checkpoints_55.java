import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] a = new int[N];
    int[] b = new int[N];
    int[] c = new int[M];
    int[] d = new int[M];

    for (int i=0; i<N; i++) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }
    for (int i=0; i<M; i++) {
      c[i] = sc.nextInt();
      d[i] = sc.nextInt();      
    }
    for (int i=0; i<N; i++) {
      int min = 400000000;
      for (int j=0; j<M; j++) {
        min = Math.min(min,manha(a[i],c[j],b[i],d[j]));
      }
      for (int j=0; j<M; j++) {
        if (min == manha(a[i],c[j],b[i],d[j])) {
          System.out.println(j+1);
          break;
        }
      }
    }
  }
  
  public static int manha(int a,int c,int b,int d) {
    return Math.abs(a - c) + Math.abs(b - d);
  }
}
