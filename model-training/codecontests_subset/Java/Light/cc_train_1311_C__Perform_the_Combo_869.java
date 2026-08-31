import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            int n = sc.nextInt(); int m = sc.nextInt();
            String s = sc.next();
            int[] limits = new int[m];
            for(int i=0;i<m;i++) limits[i] = sc.nextInt();
            int[] ans = new int[26];

            Arrays.sort(limits);

            int strIdx = 0; int idx = 0;

            while (strIdx <=limits[m-1]){
                if(strIdx == limits[idx]){
                    for(int i=idx;i<m&&limits[i]<=strIdx;i++){
                        idx++;
                    }
                }
                ans[s.charAt(strIdx)-'a'] += m-idx+1;
                strIdx++;
            }

            for(int j=strIdx;j<n;j++){
                ans[s.charAt(j)-'a']++;
            }

            for(int i=0;i<26;i++){
                System.out.print(ans[i]+ " ");
            }
            System.out.println();
            t--;
        }
    }
}