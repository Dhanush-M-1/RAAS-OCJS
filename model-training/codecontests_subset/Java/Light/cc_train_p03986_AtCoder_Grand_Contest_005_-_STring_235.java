import java.util.*;

public class Main{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        sc.close();

        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'S'){
                dq.push('S');
            } else {
                if(dq.size() == 0){
                    dq.push('T');
                }
                else if(dq.peek() == 'S'){
                    dq.pop();
                } else {
                    dq.push('T');
                }
            }
        }
        System.out.println(dq.size());
   }
}