import java.util.Scanner;
public class Minimum_Integer {
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int q=in.nextInt();

    while (q!=0){
      long l=in.nextLong();
      long r=in.nextLong();
      long d=in.nextLong();
      System.out.println(d<l?d:(long)((r/d+1)*d));
      q--;
    }
  }
}
