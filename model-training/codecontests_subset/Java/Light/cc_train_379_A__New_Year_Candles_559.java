import java.util.Scanner;
public class a {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int a=sc.nextInt(),b=sc.nextInt(),h=a;
    while(a>=b) {
      a=a-b+1;
      h++;
    }
    System.out.println(h);
  }
  //so hard much wow
}