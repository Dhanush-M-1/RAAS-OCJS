import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int h=0,w=0;
    while((h = sc.nextInt()) != 0 | (w = sc.nextInt()) != 0){
      for(int i = 1;i <= h;i++){
        for(int j = 1;j <= w;j++){
          if((j % 2) == (i % 2)){
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

