import java.math.BigInteger;
import java.util.Scanner;
public class Remainder {
public static void main(String[] args){
  Scanner sc = new Scanner(System.in);
  int c = 0;
  int n = sc.nextInt();
  int x = sc.nextInt();
  int y = sc.nextInt();
  String m1 = sc.next();
  int val = x-y;
  if(val<=0){
    for(int i = 0; i<x;i++){
      if(m1.charAt(n-i-1)=='1'){
        ++c;
      }
    }
    System.out.println(c);
    return;
  }
  if(m1.charAt(n-y-1)!='1'){
        ++c;
      }
  for(int i = 0; i<x;i++){
      if(m1.charAt(n-i-1)=='1'&&i!=y){
        ++c;
      }
     } 
  System.out.println(c);
}
} 
