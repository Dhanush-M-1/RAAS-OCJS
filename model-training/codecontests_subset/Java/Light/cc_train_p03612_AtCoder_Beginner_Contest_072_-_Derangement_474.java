import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] p = new int[n];
    for (int i=0;i<n;i++){
      p[i] = sc.nextInt()-1;
    }
    sc.close();
    int ans = 0;
    for (int i=0;i<n;i++){
      if (p[i] ==i){
        ans++;
        i++;
      }
    }
    System.out.println(ans);
  }
}