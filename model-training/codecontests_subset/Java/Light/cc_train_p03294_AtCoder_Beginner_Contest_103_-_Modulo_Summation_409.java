import java.util.*;

class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int counter = sc.nextInt();
    int answer = 0;
    for(int i=0;i<counter;i++){
      answer += sc.nextInt() -1;
    }
    System.out.println(answer);
  }
}