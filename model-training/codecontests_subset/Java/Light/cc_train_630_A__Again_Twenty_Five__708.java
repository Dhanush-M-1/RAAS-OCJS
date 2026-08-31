import java.util.Scanner;
public class bullshit {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String s=sc.next();
    if (Double.parseDouble(s)==0)
      System.out.println(1);
    else if (Double.parseDouble(s)==1)
      System.out.println(5);
    else
      System.out.println(25);
  }
  // so hard much wow
}