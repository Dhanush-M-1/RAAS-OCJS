public class Main{
  public void run(java.io.InputStream in, java.io.PrintStream out){
    java.util.Scanner sc = new java.util.Scanner(in);
    int l, r, count, n, ud;
    String f;

    for(;;){
      n = sc.nextInt(); if(n == 0)break;
      count = 0; l = 0; r = 0; ud = 0;
      for(;n-- > 0;){
        f = sc.next();
        if("lu".equals(f)){
          if(ud == 0 && l == 0 && r == 1){
            count++; ud = 1;
          }
          l = 1;
        }else if("ru".equals(f)){
          if(ud == 0 && l == 1 && r == 0){
            count++; ud = 1;
          }
          r = 1;
        }else if("ld".equals(f)){
          if(ud == 1 && l == 1 && r == 0){
            count++; ud = 0;
          }
          l = 0;
        }else{
          if(ud == 1 && l == 0 && r == 1){
            count++; ud = 0;
          }
          r = 0;
        }
      }
      out.println(count);
    }

    sc.close();
  }
  public static void main(String[] args){
    (new Main()).run(System.in, System.out);
  }
}