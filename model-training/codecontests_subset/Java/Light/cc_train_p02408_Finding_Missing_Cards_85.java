import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    boolean[][] trump = new boolean[13][4];

    for(int i = 0; i < n; i++){
      String s = sc.next();
      int num = sc.nextInt();

      if(s.equals("S")){
        trump[num - 1][0] = true;
      } else if(s.equals("H")){
        trump[num - 1][1] = true;
      } else if(s.equals("C")){
        trump[num - 1][2] = true;
      } else {
        trump[num - 1][3] = true;
      }
    }

    for(int j = 0; j < 4; j++){
      for(int i = 0; i < 13; i++){
        if(trump[i][j] == false){
          if(j == 0){
            System.out.println("S " + (i + 1));
          } else if(j == 1){
            System.out.println("H " + (i + 1));
          } else if(j == 2){
            System.out.println("C " + (i + 1));
          } else {
            System.out.println("D " + (i + 1));
          }
        }
      }
    }
  }
}

