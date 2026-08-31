import java.util.*;
class Main{
  private static Scanner sc = new Scanner(System.in);
  private static int[] clear = {5, 7, 5, 7, 7};

  public static void main(String[] args){
    while(resolve());
  }

  public static boolean resolve(){
    int n = sc.nextInt();
    if(n == 0) return false;
    int[] to_nums = new int[n];
    for(int i = 0; i < n; i++) to_nums[i] = sc.next().length();

    for(int i = 0; i < to_nums.length; i++){
      int cnt = 0, j = 0;
      for(int k = i; k < to_nums.length; k++){
        int x = to_nums[k];

        cnt += x;
        if(cnt == clear[j]){
          j += 1;
          cnt = 0;
          if(j >= clear.length){
            System.out.println(i + 1);
            return true;
          }
        }else if(cnt > clear[j]) break;
      }
    }

    return true;
  }
}