public class Main{
  public void run(java.io.InputStream in, java.io.PrintStream out){
    java.util.Scanner sc = new java.util.Scanner(in);
    int n, nl, nr, i, j, max, q, count, d;
    int[] c;
    String s;

    for(q = sc.nextInt();q-- > 0;out.println(count)){
      n = sc.nextInt(); max = 0;
      for(count = -1;max != -1;count++){
        d = caldig(n);
        j = 10; max = -1;
        for(i = 1;i < d;i++){
          nr = n % j; nl = n / j;
          if(max < nr * nl)max = nr * nl;
          j *= 10;
        }
        n = max;
      }
    }

    sc.close();
  }
  private static int caldig(int n){
    int i;
    for(i = 1;i < 10;i++){
      if(n / 10 == 0)return i;
      n = n / 10;
    }
    return 0;
  }
  public static void main(String[] args){
    (new Main()).run(System.in, System.out);
  }
}