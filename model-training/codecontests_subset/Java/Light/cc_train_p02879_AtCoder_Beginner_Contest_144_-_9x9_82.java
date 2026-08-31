import java.util.*;
class Main{
  public static void main(String[] args){
    Scanner scan=new Scanner(System.in);
    int A=scan.nextInt();
    int B=scan.nextInt();
    int ans=-1;
    if(A<=9&&B<=9){
      ans=A*B;
      }
    System.out.println(ans);
  }
}