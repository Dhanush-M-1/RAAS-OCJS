import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main  {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n, answer=  0;
        String s, ans = "";
        n = in.nextInt();
        s = in.next();

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i< n- 1;i++) {
            String pat = String.valueOf(s.charAt(i));
            pat+=s.charAt(i+1);
            if(!map.containsKey(pat)) {
                map.put(pat, 1);
            }
            else {
                map.put(pat, map.get(pat) + 1);
            }
        }

        for (String s1 : map.keySet()) {
            if(map.get(s1)> answer) {
                answer = map.get(s1);
                ans = s1;
            }
        }

        System.out.println(ans);
    }

}
