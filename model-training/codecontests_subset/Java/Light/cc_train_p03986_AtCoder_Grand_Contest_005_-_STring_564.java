import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c: input){
            if(!stack.empty()){
                if(stack.peek() == 'S' && c == 'T')
                    stack.pop();
                else
                    stack.push(c);
            }else{
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder("");
        while(!stack.empty()){
            result.append(stack.pop());
        }
        System.out.println(result.length());
    }
}