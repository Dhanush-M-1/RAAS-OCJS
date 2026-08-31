import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] a = new int[N];
    for(int i = 0; i < N; i++){
      a[i] = sc.nextInt();
    }
    long f = 0;
    for(int i = 0; i < N; i++){
      f += a[i] - 1; //(m - 1) mod a[i] = a[i] - 1だからf(m - 1)が一番大きくなる
    }
    System.out.println(f);
  }
}
