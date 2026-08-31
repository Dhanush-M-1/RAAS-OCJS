import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());
    List<Boolean[]> F = new ArrayList<>();
    List<int[]> P = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      F.add(Arrays.stream(sc.nextLine().split(" ")).map(e -> e.equals("1")).toArray(Boolean[]::new));
    }
    for (int i = 0; i < N; i++) {
      P.add(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
    }
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < Math.pow(2,10); i++) {
      int total = 0;
      for (int j = 0; j < N; j++) {
        int count = 0;
        for (int k = 0; k < 10; k++) {
          if ((1 & i >> k) == 1 && F.get(j)[k]) {
            count++;
          }
        }
        total += P.get(j)[count];
      }
      max = Math.max(max, total);
    }
    System.out.println(max);
  }
}