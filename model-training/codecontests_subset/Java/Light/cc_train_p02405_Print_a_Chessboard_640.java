import java.util.Scanner;

class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);

      while(true){

        int h = sc.nextInt();
        int w = sc.nextInt();

        if(h==0&&w==0){
          break;
        }

        for(int j = 0; j<h;j++){
          for(int i = 0; i<w;i++){
              if((i%2+j)%2==0){
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
