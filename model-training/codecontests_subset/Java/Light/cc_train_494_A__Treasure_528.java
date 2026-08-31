import java.util.*;

public class Treasure {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        ArrayList<Integer> L = new ArrayList<Integer>();
        Stack<Integer> St = new Stack<Integer>();
        int cnt = 0 , l1 = 0,l2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                cnt++;
                l2 = i;
                St.push(i);
            }
            if(s.charAt(i) == ')'){
                cnt--;
                if(St.size() == 0){
                    System.out.println("-1");
                    return;
                }
                St.pop();
                
            }
            if (s.charAt(i) == '#') {
                L.add(1);
                l1 = i;
                if (cnt <= 0) {
                    System.out.println("-1");
                    return;
                }
                cnt--;
            }
        }
        
        if(cnt < 0 || (St.size() > 0 && l1 < St.peek()) ){
            System.out.println(-1);
            return ;
        }
        for (int i = 0; i < L.size()-1; i++) {
            System.out.println(L.get(i));
        }
        System.out.println(cnt+1);
    }
}
