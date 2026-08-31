import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(true){
     int H = scan.nextInt();
        int W = scan.nextInt();
if(H == 0 && W == 0)break;

for(int i = 0; i < H; i++){
    for(int x = 0; x < W;  x++){
      if( i % 2 == 0 && x % 2 == 0 || i % 2 ==1 && x % 2 ==1){
          System.out.print("#");
      }else {
          System.out.print(".");
      }
       
    }
  System.out.println();
}
System.out.println();
}
        
    }
}
