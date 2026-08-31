import java.util.*;
public class solution
{ 
public static void main(String[] n)
{
n=new Scanner(System.in).next().split("\\+");
Arrays.sort(n);
System.out.print(String.join("+",n));
}
}
 