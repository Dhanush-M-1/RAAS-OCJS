import java.util.*;
public class Main {
    static PriorityQueue<String> queue;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        queue = new PriorityQueue<>();
        pushStandard(1,0,"a");
        while(queue.size()>0) p(queue.poll());
    }
    
    private static void pushStandard(int depth, int max, String str) {
        if(depth == n) {
            queue.add(str);
            return;
        }
        for(int i = 0; i<=max+1; i++) {
            char nc = (char)('a' + i);
            //p(str+nc);
            pushStandard(depth+1, (i==max+1)?max+1:max, str+nc);
        }
    }

    public static <T> void p(T message) {
        System.out.println(message);
    }

}