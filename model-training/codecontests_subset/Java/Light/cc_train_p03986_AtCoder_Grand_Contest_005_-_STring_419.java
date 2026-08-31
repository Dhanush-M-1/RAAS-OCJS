import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        Deque<Character> deq = new ArrayDeque<Character>();
        int count = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'S'){
                deq.push('e');
            }else{
                Character temp = deq.poll();
                if(temp == null){
                    count++;
                }
            }
        }

        System.out.println(count + deq.size());
    }
}