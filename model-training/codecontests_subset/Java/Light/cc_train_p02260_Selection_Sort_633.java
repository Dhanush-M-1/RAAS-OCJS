import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Integer> arr = new ArrayList<>();
    int count = 0;
    for(int i = 0; i < n; i++) {
      arr.add(sc.nextInt());
    }
    for(int i = 0; i < n - 1; i++) {
      int min = i;
      for(int j = i + 1; j < n; j++) {
        if(arr.get(min) > arr.get(j)) {
          min = j;
        }
      }
      if(min != i) {
        count++;
        int v = arr.get(i);
        arr.set(i, arr.get(min));
        arr.set(min, v);
      }
      System.out.print(arr.get(i) + " ");
    }
    System.out.println(arr.get(n - 1));
    System.out.println(count);
  }
}

