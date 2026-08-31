import java.util.Scanner;
public class Main{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    while(true){
      int H = sc.nextInt();
      int W = sc.nextInt();
      if(H == 0 && W == 0)
      break;
      for(int i = 0;i < H;i++){
        for(int j = 0;j < W;j++){
          if((i+j)%2==1){
          System.out.print(".");
        }else {
          System.out.print("#");
        }
        }
        System.out.print("\n");
      }
      System.out.println("");
    }
}
}
