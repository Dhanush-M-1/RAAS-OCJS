 import java.util.*;
class Main{
  public static void main(String args[]){
    int count = 0;
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n];

    for(int i = 0; i<n; i++){
      a[i] = sc.nextInt();
      if(Judge_Prime(a[i])==1)count++;
    }
    System.out.println(count);
  }
  static int Judge_Prime (int n){
    int i;
    if (n < 2){
      return 0;
    }else if (n == 2){
      return 1;
    }

    if (n % 2 == 0){
      return 0;
    }

    for (i = 3; i <= n / i; i += 2){
      if (n % i == 0){
        return 0;
      }
    }
      return 1;
  }
}
