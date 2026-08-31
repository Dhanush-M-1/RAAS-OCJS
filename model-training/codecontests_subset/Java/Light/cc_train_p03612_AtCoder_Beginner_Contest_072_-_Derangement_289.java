import java.util.*;

public class Main{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());
    int[] nums = new int[N];
    for(int i = 0; i < N; i++){
      nums[i] = Integer.parseInt(sc.next());
    }
    
    int ans = 0;
    for(int i = 0; i < N; i++){
      if(i == N-1){
        if(nums[i] == i+1){
          ans++;
        }
        break;
      }
      if(nums[i] == i+1){
        ans++;
        nums[i+1] = nums[i];
      }
    }
    System.out.println(ans);
  }
}