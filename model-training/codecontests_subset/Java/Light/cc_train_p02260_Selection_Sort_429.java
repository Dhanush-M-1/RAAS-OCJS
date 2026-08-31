import java.util.Scanner;

class Main {
  public static void main(String... args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = sc.nextInt();
    }

    int count = 0;
    for (int i = 0; i < size - 1; i++) {
      int min = i;
      for (int j = i; j < size; j++) {
        if (array[j] < array[min]) {
          min = j;
        }
      }
      if (min != i) {
        swap(array, min, i);
        count++;
      }
    }

    for (int i = 0; i < size - 1; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println(array[size - 1]);
    System.out.println(count);
  }

  public static void swap(int[] array, int min, int i) {
    int tmp = array[i];
    array[i] = array[min];
    array[min] = tmp;
  }
}

