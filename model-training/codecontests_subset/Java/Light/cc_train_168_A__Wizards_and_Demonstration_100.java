import java.util.Scanner;
public class  Wizards
{
public static void main(String []args)
{
Scanner  s = new Scanner(System.in);    
int n = s.nextInt();
int x = s.nextInt();
int y = s.nextInt();
int puppet = (int)Math.ceil(n * (double)y / 100) - x;
 if(puppet > 0)
System.out.println(puppet);
else
  System.out.println(0);
    }
}