import java.util.*;

public class Main{
  
  public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    
    int ans = 0;
    for(int i = 0; i < N; i++){
      int next = sc.nextInt();
      int a = next - 1;
      ans += a;
    }
    
    System.out.println(ans);
    
  }
  
}