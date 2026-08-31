import java.util.Scanner;
class Main
{
 public static void main(String args[])
 {
  int h,w,i,j;
  Scanner sc = new Scanner(System.in);
  while(true)
  {
   h=sc.nextInt();
   w=sc.nextInt();
   if(h==0 && w==0)
    break;
   for(i=0;i<h;i++)
   {
    for(j=0;j<w;j++)
    {
     if((i+j)%2==0)
      System.out.print("#");
     else
      System.out.print(".");
    }
    System.out.println("");
   }
   System.out.println("");
  }
 }
}
