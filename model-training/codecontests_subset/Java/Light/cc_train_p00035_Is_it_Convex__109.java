public class Main{
  public void run(java.io.InputStream in, java.io.PrintStream out){
    java.util.Scanner sc = new java.util.Scanner(in);
    int i, j, l, r;
    double[] a, x, y;
    String s;
    char[] ch;

    a = new double[8]; x = new double[4]; y = new double[4];
    for(;sc.hasNext();){
      s = sc.next();
      ch = new char[s.length()];
      for(i = 0;i < s.length();i++)ch[i] = s.charAt(i);
      j = 0; l = 0;r = 0;
      for(i = 0;i < 8;i++){
        for(;j < s.length() + 1;j++){
          if(j == s.length() || ch[j] == ','){
            r = j; a[i] = readdouble(ch, l, r); l = ++j; break;
          }
        }
      }

      for(i = 0;i < 8;i++){
        x[i / 2] = a[i++]; y[i / 2] = a[i];
      }
      if(isconvex(x, y, 4))out.println("YES");
      else out.println("NO");
    }

    sc.close();
  }
  public static void main(String[] args){
    (new Main()).run(System.in, System.out);
  }
  private static double readdouble(char[] ch, int l, int r){
    int i;
    double res, d, s;

    s = 1;
    if(ch[l] == '-'){
      s = -1; l++;
    }
    d = 1.0; res = 0.0;
    for(i = l;i < r;i++){
      if(ch[i] == '.')break;
      d *= 10;
    }
    d /= 10;

    for(i = l;i < r;i++){
      if(ch[i] != '.'){
        res += d * (double)(ch[i] - '0');
        d /= 10;
      }
    }
    return res * s;
  }
  private static boolean isconvex(double[] x, double[] y, int n){
    int i, count1, count2;
    double ax, ay, bx, by;

    count1 = 0; count2 = 0;
    for(i = 0;i < n;i++){
      ax = x[(i + 1) % n] - x[i]; ay = y[(i + 1) % n] - y[i];
      bx = x[(i + 2) % n] - x[i]; by = y[(i + 2) % n] - y[i];
      if(ax * by - ay * bx < 0)count1++;
      if(ax * by - ay * bx > 0)count2++;
    }
    if((count1 == 0 || count2 == 0) && count1 + count2 == 4)return true;
    else return false;
  }
}