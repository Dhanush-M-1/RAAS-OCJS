public class Main{
  static int mod = 100000007;
  static int T = 2001;
  public void run(java.io.InputStream in, java.io.PrintStream out){
    java.util.Scanner sc = new java.util.Scanner(in);
    int r, c, a1, a2, b1, b2;
    int nr, nc, i, times;
    long[] p, pinv;

    p = new long[T]; pinv = new long[T];
    p[0] = 1; pinv[0] = 1;
    for(i = 1;i < T;i++){
      p[i] = p[i - 1] * i;
      if(p[i] > mod)p[i] %= mod;
      pinv[i] = getinverse((int)p[i]);
    }

    r = sc.nextInt(); c = sc.nextInt();
    a1 = sc.nextInt(); a2 = sc.nextInt();
    b1 = sc.nextInt(); b2 = sc.nextInt();

    nr = b1 - a1; nc = b2 - a2;
    if(nr < 0)nr *= -1;
    if(nc < 0)nc *= -1;
    times = 1;
    if(nr > (r - nr))nr = r - nr;
    else if(nr == (r - nr))times *= 2;
    if(nc > (c - nc))nc = c - nc;
    else if(nc == (c - nc))times *= 2;

    out.println(times * (p[nr + nc] * pinv[nr] % mod) * pinv[nc] % mod);

    sc.close();
  }
  public static void main(String[] args){
    (new Main()).run(System.in, System.out);
  }
  private static int getinverse(int a){
    int[] x, y;
    x = new int[1]; y = new int[1];
    extgcd(a, mod, x, y);
    if(x[0] < 0)x[0] += mod;
    return x[0];
  }
  private static void extgcd(int a, int b, int[] x, int[] y){
    int tmp;
    x[0] = 1; y[0] = 0;
    if(b != 0){
      extgcd(b, a % b, y, x);
      y[0] -= (a / b) * x[0];
    }
    return;
  }
}