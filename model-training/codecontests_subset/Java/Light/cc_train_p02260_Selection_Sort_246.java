import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n;
    n = sc.nextInt();

    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    func(a);

    sc.close();
  }

  private static void func(int a[]) {// 選択ソート
    int minj, copy, times = 0;

    // 選択ソート
    for (int i = 0; i < a.length; i++) {
      minj = i;
      for (int j = i; j < a.length; j++) {// minj の探索
        if (a[j] < a[minj]) minj = j;
      }
      if (a[i] > a[minj]) {// 交換が行われた場合
        copy = a[minj];
        a[minj] = a[i];
        a[i] = copy;
        times++;
      }
    }

    // 回答
    for (int i = 0; i < a.length - 1; i++) {
      System.out.printf("%d ", a[i]);
    }
    System.out.printf("%d\n%d\n", a[a.length - 1], times);
  }
}

