import java.util.LinkedList;
import java.util.Scanner;

public class CF_A425 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] arr = new int[n + 1];
    int[] presum = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = in.nextInt();
      presum[i] = presum[i - 1] + arr[i];
    }
    int answer = Integer.MIN_VALUE;
    for (int l = 1; l <= n; l++) {
      for (int r = l; r <= n; r++) {
        int sum = presum[r] - presum[l - 1];
        if (sum > 0) {
          LinkedList<Integer> toAdd = new LinkedList<>();
          LinkedList<Integer> toRemove = new LinkedList<>();
          for (int i = 1; i <= n; i++) {
            if ((i > r || i < l) && arr[i] > 0) {
              toAdd.add(arr[i]);
            } else if (l <= i && i <= r && arr[i] < 0) {
              toRemove.add(arr[i]);
            }
          }
          toRemove.sort(null);
          toAdd.sort(null);
          int _k = k;
          while (!toRemove.isEmpty() && _k > 0) {
            _k--;
            if (toAdd.isEmpty()) {
              sum -= toRemove.removeFirst();
            } else {
              sum += toAdd.removeLast() - toRemove.removeFirst();
            }
          }
        }
        answer = Math.max(answer, sum);
      }
    }
    System.out.println(answer);
    in.close();
  }
}
