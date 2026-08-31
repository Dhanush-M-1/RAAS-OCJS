import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] a = new int[n];
    int[] b = new int[n];
    int[] c = new int[n - 1];
    for(int i = 0; i < n;i++){
      a[i] = sc.nextInt();
    }
    for(int i = 0; i < n;i++){
      b[i] = sc.nextInt();
    }
    for(int i = 0; i < n  - 1;i++){
      c[i] = sc.nextInt();
    }

    int before = -2;
    int score = 0;
    for(int i = 0; i < n;i++){
      score += b[a[i] - 1];
      if(before + 1 == a[i]){
        score += c[before - 1];
      }
      before = a[i];
    }

    System.out.println(score);
  }
}
