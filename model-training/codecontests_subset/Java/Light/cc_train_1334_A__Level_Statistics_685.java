import java.io.*;
import java.util.*;
import java.lang.*;

public class EdSol{

    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        StringBuilder ans = new StringBuilder("");
        for(int k=0; k<t; k++){
            int n = sc.nextInt();
            int[] plays = new int[n];
            int[] clears = new int[n];
            for(int i=0; i<n; i++){
                plays[i] = sc.nextInt();
                clears[i] = sc.nextInt();
            }
            boolean isBreak = false;
            int p = plays[0];
            int q = clears[0];
            if(p<q){
                ans.append("NO\n");
                continue;
            }
            for(int i=1; i<n; i++){
                int r = plays[i];
                int s = clears[i];
                if(r<p || s<q || (r-p)<(s-q)){
                    ans.append("NO\n");
                    isBreak = true;
                    break;
                }
                p = r;
                q = s;
            }
            if(isBreak) continue;
            ans.append("YES"+"\n");
        }
        System.out.println(ans);
    }
}