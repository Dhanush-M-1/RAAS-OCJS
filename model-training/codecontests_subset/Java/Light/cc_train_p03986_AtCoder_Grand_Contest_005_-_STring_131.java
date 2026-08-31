import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Deque<Character> que = new ArrayDeque<>();

        for(char ch: str.toCharArray()) {
            if(ch == 'T' && que.size() > 0 && que.peek().equals('S')) {
                que.pop();
            }else {
                que.push(ch);
            }
        }
        System.out.println(que.size());
    }
}