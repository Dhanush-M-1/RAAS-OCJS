import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int x = Integer.parseInt(sc.next());
    int[] a = new int[x];
    for(int i = 0; i < x; i++){
      a[i] = Integer.parseInt(sc.next());
    }
    int count = 0;
    int tmp = 0;
    for(int i = 0; i < x; i++){
      int min_j = i;
      for(int j = i; j < x; j++){
        if(a[j] < a[min_j]){
          tmp = j;
          j = min_j;
          min_j = tmp;
        }
      }
      if(min_j != i){
        count++;
        tmp = a[min_j];
        a[min_j] = a[i];
        a[i] = tmp;
      }
    }
    for(int i = 0; i < (x - 1); i++){
      System.out.printf("%d ", a[i]);
    }
    System.out.printf("%d\n%d\n", a[x - 1], count);
  }
}
