import java.util.Scanner;
public class Main{
 public static void main(String[] args){
  Scanner sc = new Scanner(System.in);
  while(true)
  {
   int H = sc.nextInt();
   int W = sc.nextInt();
   if(H == 0 && W == 0)
    break;
   for(int i = 0 ; i < H ; i++)
   {
    int x = 1;
    if(i % 2 == 0)
     x--;
    for(int j = 0 ; j < W ; j++)
    { 
     if(j % 2 == x)
      System.out.print("#");
     else
      System.out.print(".");
    }
    System.out.println();
   }
   System.out.println();
  }
 }
}
