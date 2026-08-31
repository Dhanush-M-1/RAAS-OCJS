import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        HashMap<String,Integer> map = new HashMap<>();
        
        int max = 0;
        String ans = "";
        for(int i = 0; i < s.length()-1; i++) {
            String ss = s.substring(i,i+2);
            if(map.containsKey(ss)) {
                int v = map.get(ss);
                if(v + 1 > max) {
                    ans = ss;
                    max = v + 1;
                }
                map.put(ss, v + 1);
            } else {
                if(1 > max) {
                    ans = ss;
                    max = 1;
                }
                map.put(ss, 1);
            }
        }

        System.out.println(ans);

    }
}

