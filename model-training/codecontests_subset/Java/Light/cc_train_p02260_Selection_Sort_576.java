import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i = 0; i<n; i++){
      a[i] = sc.nextInt();
    }
    int count = selectionSort(a,n);
    for(int i = 0; i<n; i++){
      if(i == n-1){
        System.out.println(a[i]);
      }else{
        System.out.print(a[i] + " ");
      }
    }
    System.out.println(count);
  }

  public static int selectionSort(int[] a, int n){
    int count = 0;
    for(int i = 0; i<n; i++){
      int minj = i;
      for(int j = i; j<n; j++){
        if(a[j]<a[minj]){
          minj = j;
        }
      }
      int free = a[i];
      a[i] = a[minj];
      a[minj] = free;
      if(a[i] != a[minj]){
        count++;
      }
    }
    return count;
  }
}