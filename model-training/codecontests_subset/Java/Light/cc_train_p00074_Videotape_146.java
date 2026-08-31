public class Main{
  public void run(java.io.InputStream in, java.io.PrintStream out){
    java.util.Scanner sc = new java.util.Scanner(in);
    int h, m, s, t;

    for(;;){
      h = sc.nextInt(); m = sc.nextInt(); s = sc.nextInt();
      if(h == -1 && m == -1 && s == -1)break;
      t = 7200 - (s + m * 60 + h * 3600);
      out.printf("%02d:%02d:%02d%n", t / 3600, (t / 60) % 60, t % 60);
      t *= 3;
      out.printf("%02d:%02d:%02d%n", t / 3600, (t / 60) % 60, t % 60);
    }

    sc.close();
  }
  public static void main(String[] args){
    (new Main()).run(System.in, System.out);
  }
}