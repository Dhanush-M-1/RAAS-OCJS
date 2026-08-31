import java.util.*;
 
public class Main{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());
    String[] S = sc.nextLine().split(" ");
    long ans = 0;
    for(int i = 0; i < N; i++){
      long n = Long.parseLong(S[i]);
      ans += (n-1);
    }
    System.out.println(ans);
  }
}