import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
          long n = sc.nextLong();
          int cnt = 0;
          if(n==1){
              System.out.println("0");
              continue;
          }
          while(true){
              if(n==6){
                  cnt++;
                  System.out.println(cnt);
                  break;
              }
              if(n>6 && n%6==0){
                  n/=6;
                  cnt++;
              }else{
                  if(n*2%6==0){
                      cnt++;
                      n*=2;
                  }else if(n*4%6==0){
                      cnt+=2;
                      n*=4;
                  }else{
                      System.out.println("-1");
                      break;
                  }
              }
          }
      }
    }
}