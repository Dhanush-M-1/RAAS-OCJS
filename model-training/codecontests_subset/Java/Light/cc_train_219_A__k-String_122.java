import java.util.*;

public class KString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int c[] = new int[26];
        // Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            c[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(c[i] % n != 0){
                System.out.println(-1);
                sc.close();
                return;

            }
        }
        String ans = "";
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < c[i]/n; j++){
                // System.out.println(j + " j");
                ans += (char)(i+'a');
                // System.out.println(ans);
            }
        }
        String ans1 = ans;
        for (int i = 1; i < n; i++) {
            ans += ans1;
        }

        System.out.println(ans);
        sc.close();
    }
}
