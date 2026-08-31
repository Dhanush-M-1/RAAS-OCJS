import java.util.Scanner;

public class A478{

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int i;
    int sum = 0;
    for(i = 0;i < 5;i++){
      sum += in.nextInt();
    }
    
    System.out.println((sum % 5 == 0) && (sum != 0) ? sum/5 : -1);
    return;
  }
}