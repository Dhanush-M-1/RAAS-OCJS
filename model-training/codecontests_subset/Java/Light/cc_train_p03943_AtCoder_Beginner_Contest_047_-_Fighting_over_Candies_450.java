import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int c[] = new int[3];
    c[0]=sc.nextInt();
    c[1]=sc.nextInt();
    c[2]=sc.nextInt();
    Arrays.sort(c);
    if(c[2]==c[1]+c[0]){
      System.out.println("Yes");
    }else{
      System.out.println("No");
    }

  }
  

  
}
