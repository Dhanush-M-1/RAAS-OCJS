import java.util.*;

public class Main {

    public static class Solution {

        public String kString() {
            Scanner scanner = new Scanner(System.in);
            int k = scanner.nextInt();
            scanner.nextLine();
            String s = scanner.nextLine();
            scanner.close();
            int[] cc = new int[26];
            int n = s.length();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                cc[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < cc.length; i++) {
                if (cc[i] % k != 0)
                    return "-1";
                if(cc[i] != 0){
                    for(int x = 0; x < cc[i]/k; x++){
                        sb.append((char) ('a' + i));
                    }
                    
                }
                
            }

            String ans = sb.toString();

            for (int i = 1; i < k; i++) {
                sb.append(ans);
            }

            return sb.toString();
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.kString());
    }
}
