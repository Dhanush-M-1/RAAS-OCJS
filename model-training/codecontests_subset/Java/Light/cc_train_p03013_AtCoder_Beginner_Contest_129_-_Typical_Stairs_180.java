import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number_n, number_m, i, j = 0;
    number_n = Integer.parseInt(sc.next());
    number_m = Integer.parseInt(sc.next());
    int[] stage = new int[number_n+1];
    int[] broken_stage = new int[number_m+1];
    broken_stage[0] = 0;
    for(i = 0; i < number_m; i++) {
      broken_stage[i] = Integer.parseInt(sc.next());
    }
    stage[0] = 1;
    stage[1] = (broken_stage[0] == 1)? 0 : 1;
    for(i = 2; i <= number_n; i++) {
      stage[i] = (stage[i-1] + stage[i-2]);
      for(; j < number_m; j++) {
        if(broken_stage[j] < i) {
          continue;
        } else if(broken_stage[j] > i) {
          break;
        } else {
          stage[i] = 0;
          break;
        }
      }
      if(stage[i] > 1000000007) stage[i] -= 1000000007;
    }
    System.out.println(stage[number_n]);
  }
}
