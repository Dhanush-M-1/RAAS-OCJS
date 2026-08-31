import java.util.*;
public class Main {

  public static void main(String[] args) { 
      Scanner sc = new Scanner(System.in);
      String x = sc.next();
      Stack<Character> stack = new Stack<>();
      int cntT = 0;
      for(char c : x.toCharArray()) {
        if(c == 'S') 
          stack.push(c);
        else {
          if(stack.isEmpty()) cntT++;
          else stack.pop();
        }
      }
      System.out.println(cntT + stack.size());
  }
}