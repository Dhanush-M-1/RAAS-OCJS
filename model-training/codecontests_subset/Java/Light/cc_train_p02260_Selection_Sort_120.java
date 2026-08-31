import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    int count = 0;
    for(int i = 0; i < n - 1; i++) {
      boolean sort = false;
      int min = a[i];
      int key = i;
      for(int j = i; j < n; j++) {
        if(min > a[j]) {
          min = a[j];
          key = j;
          sort = true;
        }
      }
      if(sort) {
        a[key] = a[i];
        a[i] = min;
        count++;
      }
    }
    for(int i = 0; i < n; i++) {
      if(i == n- 1) {
        System.out.println(a[i]);
      } else {
        System.out.print(a[i] + " ");
      }
    }
    System.out.println(count);
  }
}

