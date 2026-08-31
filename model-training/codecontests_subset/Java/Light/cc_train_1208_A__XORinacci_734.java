

import java.io.PrintWriter;
import java.util.Scanner;


public class Testttt {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = sc.nextInt();
    while(t--!=0) {
      long a = sc.nextInt();
      long b = sc.nextInt();
      long n = sc.nextInt();
      long x = a^b;
      long rem = n%3;
      if(rem==0) out.println(a);
      else if(rem==1) out.println(b);
      else out.println(x);
    }
    out.close();
  }

}
