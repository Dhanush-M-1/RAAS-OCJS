import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b= sc.nextInt();
    int answer = 0;
    if(a>9||b>9){
      answer = -1;
    }else{
      answer = a*b;
    }
    System.out.println(answer);
  }
  

  
}