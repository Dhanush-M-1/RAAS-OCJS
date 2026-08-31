import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    int count = 0;
    for(int i=0;i<n;i++){
      a[i] = sc.nextInt();
    }
    for(int i = 0; i<n; i++){
      int min = i;
      int min1 = 100;
      for(int j=i;j<n;j++){
        if(a[j]<min1){
          min = j;
          min1 = a[j];
        }
      }
      if(min1 != a[i]){
        int temp = a[i];
        a[i] = min1;
        a[min] = temp;
        count++;
      }
    }
    for(int i = 0;i<n;i++){
      System.out.print(a[i]);
      if(i==n-1){
        System.out.println();
      }else{
        System.out.print(" ");
      }
    }
    System.out.println(count);
  }
}
