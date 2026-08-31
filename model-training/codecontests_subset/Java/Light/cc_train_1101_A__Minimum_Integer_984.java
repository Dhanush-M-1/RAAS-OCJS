import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    while(n-->0)
    {
      int l = s.nextInt();
      int r = s.nextInt();
      int d = s.nextInt();
      if(d<l){
          System.out.println(d);
      }
      else{
          System.out.println(d*((r/d)+1));
      }
    }
  }
}