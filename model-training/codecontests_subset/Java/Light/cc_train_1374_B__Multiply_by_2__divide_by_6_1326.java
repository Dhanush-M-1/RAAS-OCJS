//Bismillahi-r-Rahmani-r-RaHIM
import java.util.*;
import java.io.*;
public class Main{
  public static void main(String[] args)throws IOException{
    Scanner sc = new Scanner(System.in);
    long a,b,c,d,e,f,g;
    a = sc.nextLong();
    for(b = 0;b < a;b++){
      c = sc.nextLong();
      if(c == 1){
        System.out.println("0");
      }else if(c % 3 != 0){
        System.out.println("-1");
      }else{
        d = 0;
        while(c >= 3){
          if(c % 6 == 0){
            c = c/6;
            d++;
          }else{
            c = c*2;
            d++;
          }
        }
        if(c == 1){
          System.out.println(d);
        }else{
          System.out.println("-1");
        }
      }
    }
  }
}