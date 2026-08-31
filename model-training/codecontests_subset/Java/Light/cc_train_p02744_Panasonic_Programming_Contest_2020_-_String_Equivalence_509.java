import java.util.Scanner;
import java.lang.Math;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    scan.close();

    StringBuffer init = new StringBuffer("a");
    str(N, init);
  }

  public static void str(int N, StringBuffer strBuff) {
    if(strBuff.length() == N) {
      System.out.println(strBuff);
      return;
    }

    int charMin = 0;
    for(int i=0; i<strBuff.length(); i++) {
      if(charMin < strBuff.charAt(i)) {
        str(N, new StringBuffer(strBuff).append(strBuff.charAt(i)));
        charMin = strBuff.charAt(i);
      }
    }
    str(N, new StringBuffer(strBuff).append((char)(charMin+1)));
  }
}