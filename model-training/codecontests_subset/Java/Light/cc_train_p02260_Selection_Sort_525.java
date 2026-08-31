public class Main{
  public void run(java.io.InputStream in, java.io.PrintStream out){
    java.util.Scanner sc = new java.util.Scanner(in);
/*answer*/
    int n;
    int[] a;
    int i, j, count, tmp, min;

    n = sc.nextInt();
    a = new int[n];
    for(i = 0;i < n;i++){
      a[i] = sc.nextInt();
    }

    count = 0;

    for(i = 0;i < n - 1;i++){
      min = i;
      for(j = i + 1;j < n;j++){
        if(a[min] > a[j])min = j;
      }
      if(min != i){
        tmp = a[min];
        a[min] = a[i];
        a[i] = tmp;
        count++;
      }
    }

    for(i = 0;i < n - 1;i++){
      System.out.print(a[i] + " ");
    }
    System.out.println(a[n - 1]);
    System.out.println(count);

    sc.close();
  }
  public static void main(String[] args){
    (new Main()).run(System.in, System.out);
  }
}