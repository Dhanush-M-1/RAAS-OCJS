import java.util.Scanner;

class Main{
  static void trace(int[] a){
    int i;
    for(i = 0; i < a.length - 1; i++)
      System.out.print(a[i] + " ");
    System.out.println(a[i]);
  }

  public static void main(String[] args){
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int a[] = new int[n];
    for(int i = 0; i < n; i++)
      a[i] = stdIn.nextInt();

    int count = 0;
    for(int i = 0; i < a.length; i++){
      int m = i;
      for(int j = i; j < a.length; j++){
        if(a[j] < a[m])
          m = j;
        }
      if(m != i){
        int tmp = a[i];
        a[i] = a[m];
        a[m] = tmp;
        count++;
      }
    }

    trace(a);
    System.out.println(count);

  }
}