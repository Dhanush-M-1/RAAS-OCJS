import java.util.*;

public class Main{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    String S  = sc.nextLine();
    Deque<Character> deq = new ArrayDeque<>();
    for(int i = 0; i < S.length(); i++){
      if(S.charAt(i) == 'S'){
        deq.push(S.charAt(i));
      }else{
        if(deq.size() == 0 || deq.peek() != 'S'){
          deq.push(S.charAt(i));
        }else{
          deq.pop();
        }
      }
    }
    System.out.println(deq.size());
  }
}
