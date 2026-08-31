import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    int[] c = new int[n-1];
    int ans = 0;

    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    for(int i = 0; i < n; i++){
      ans += sc.nextInt();
    }

    for(int i = 0; i < n - 1; i++){
      c[i] = sc.nextInt();
    }

    for(int i = 0; i < n - 1; i++){
      if(a[i] + 1 == a[i + 1]){
        ans += c[a[i] - 1];
      }
    }

    System.out.println(ans);
  }
}
