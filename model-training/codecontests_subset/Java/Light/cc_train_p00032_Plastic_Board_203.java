public class Main{
  public void run(java.io.InputStream in, java.io.PrintStream out){
    java.util.Scanner sc = new java.util.Scanner(in);
/*answer*/
    int i, j, k, x, y, z, a, b;
    String str;
    char[] ch;

    a = 0; b = 0;
    for(;sc.hasNext();){
      str = sc.next();
      ch = new char[str.length()];
      for(j = 0;j < str.length();j++)ch[j] = str.charAt(j);
      x = 0; y = 0; z = 0; k = 0;

      for(j = 0;j < str.length();j++){
        if(ch[j] == ','){
          x = readint(ch, 0, j);
          k = ++j; break;
        }
      }
      for(;j < str.length();j++){
        if(ch[j] == ','){
          y = readint(ch, k, j);
          j++; break;
        }
      }
      z = readint(ch, j, str.length());

      if(x * x + y * y == z * z)a++;
      if(x == y)b++;
    }
    out.println(a);
    out.println(b);

    sc.close();
  }
  public static void main(String[] args){
    (new Main()).run(System.in, System.out);
  }
  private static int readint(char[] ch, int l, int r){
    int i, d, res;
    d = 1; res = 0;
    for(i = r - 1;i >= l;i--){
      res += d * (int)(ch[i] - '0');
      d *= 10;
    }
    return res;
  }
}