import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    int[] c = new int[n];
    for(int i=0; i<n; ++i) a[i] = sc.nextInt()-1;
    for(int i=0; i<n; ++i) b[i] = sc.nextInt();
    for(int i=0; i<n-1; ++i) c[i] = sc.nextInt();

    int happy = 0;
    for(int i=0; i<n; ++i) {
      happy += b[a[i]];
      if( i < n-1 && a[i+1] - a[i] == 1)
        happy += c[a[i]];
    }
    System.out.println(happy);
  }
}