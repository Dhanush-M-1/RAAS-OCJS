import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
 
public class codeforce {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();
        int need = (int)Math.ceil(n * y / 100.);
        System.out.println(Math.max(0, need - x));
  }
}