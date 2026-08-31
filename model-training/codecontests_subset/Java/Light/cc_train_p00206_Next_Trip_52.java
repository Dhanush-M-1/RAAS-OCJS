public class Main{
  public void run(java.io.InputStream in, java.io.PrintStream out){
    java.util.Scanner sc = new java.util.Scanner(in);
    int i, l, s;
    int[] m, n;
    m = new int[12]; n = new int[12];
    for(;;){
      l = sc.nextInt(); if(l == 0)break;
      for(i = 0;i < 12;i++){
        m[i] = sc.nextInt(); n[i] = sc.nextInt();
      }
      s = 0;
      for(i = 0;i < 12;i++){
        s += (m[i] - n[i]);
        if(s >= l){
          out.println(i + 1); break;
        }
      }
      if(i == 12)out.println("NA");
    }

    sc.close();
  }
  public static void main(String[] args){
    (new Main()).run(System.in, System.out);
  }
}