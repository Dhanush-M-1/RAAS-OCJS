public class Main{
  public void run(java.io.InputStream in, java.io.PrintStream out){
    java.util.Scanner sc = new java.util.Scanner(in);
/*answer*/
    int n;
    double[] x, y;
    int i, j, s;
    double ax, ay, bx, by;

    n = sc.nextInt();
    x = new double[n];
    y = new double[n];

    for(i = 0;i < n;i++){
      x[i] = sc.nextDouble();
      y[i] = sc.nextDouble();
    }
    sc.close();

    s = 1;
    for(i = 0;i < n - 2;i++){
      ax = x[i + 1] - x[i];
      ay = y[i + 1] - y[i];
      bx = x[i + 2] - x[i];
      by = y[i + 2] - y[i];
      if(ax * by - ay * bx < 0){
        s = 0;
        break;
      }
    }
    ax = x[i + 1] - x[i];
    ay = y[i + 1] - y[i];
    bx = x[0] - x[i];
    by = y[0] - y[i];
    if(ax * by - ay * bx < 0)s = 0;


    if(s == 0){
      System.out.println("0");
    }else{
      System.out.println("1");
    }

  }
  public static void main(String[] args){
    (new Main()).run(System.in, System.out);
  }
}