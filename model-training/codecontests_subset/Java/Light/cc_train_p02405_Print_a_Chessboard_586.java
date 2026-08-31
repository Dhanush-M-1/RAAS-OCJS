import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
   
   Scanner sc = new Scanner(System.in);  
   
   while (true) {
   int H = sc.nextInt();
   int W = sc.nextInt();

    if (H == 0 && W == 0) {
      break;
    }
       
       for(int y=0; y<H; y++){
          for(int x=0; x<W; x++){
             System.out.print((x+y)% 2 == 0 ? '#' : '.');
          }
          System.out.println();
       }
       System.out.println();
   }
   sc.close();
  }
}
