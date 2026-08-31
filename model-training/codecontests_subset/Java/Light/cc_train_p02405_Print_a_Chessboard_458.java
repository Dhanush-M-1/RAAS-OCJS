import java.util.Scanner;
   
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    while(true){
      int H = sc.nextInt();
      int W = sc.nextInt();
      if(H == 0 && W == 0){
        break;
      }
      for(int x = 0; x < H; x++){
        for(int y = 0; y < W; y++){
          if(x%2 == 0 && y%2 == 0 || x%2 == 1 && y%2 == 1){
            System.out.print("#");
          }else{
            System.out.print(".");
          }
        }
        System.out.println("");
      }
      System.out.println("");
    }
  }
}
