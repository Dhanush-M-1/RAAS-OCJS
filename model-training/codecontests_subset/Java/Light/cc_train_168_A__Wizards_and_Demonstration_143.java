import java.util.Scanner;
public class Main168A
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int x=sc.nextInt();
    int y=sc.nextInt();
    int enough;
    if(y*n%100==0)
      enough=(y*n)/100;
    else
      enough=(y*n)/100+1;
    if(x>enough) System.out.println(0);
    else System.out.println(enough-x);
  }
}