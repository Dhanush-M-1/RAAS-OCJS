// package ProblemSolving.codeforces714;

import java.io.*;
import java.util.StringTokenizer;

public class C_Upsolving {
    static final int MAX = 200020;
    static long [][] dp = new long[10][MAX];    //dp[숫자][연산 몇번 적용] = 연산 적용 후 길이
    static final int q= (int)1e9+7;

    public static void precalc(){
        //0번 적용
        for(int i=0;i<=9;i++) dp[i][0]=1;
        //1번 적용
        for(int i=0;i<=8;i++) dp[i][1]=1;
        dp[9][1]=2;

        //2번 이상 적용:: j>=2
        // i<=8 -> dp[i][j] = dp[i+1][j-1]
        // i==9 -> dp[i][j] =dp[0][j-1] + dp[1][j-1]

        for(int j=2;j<MAX;j++){
            for(int i=0;i<=8;i++){
                dp[i][j] =dp[i+1][j-1]; //톱니바퀴 처럼 맞물리는 완벽한 논리네...
            }
            dp[9][j] =dp[0][j-1]+dp[1][j-1]; //톱니바퀴 처럼 맞물리는 완벽한 논리네...
            dp[9][j]%=q;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        precalc();

        int tc= Integer.parseInt(br.readLine());
        for(int tt=0;tt<tc;tt++){
            st = new StringTokenizer(br.readLine());
            int n= Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String s= String.valueOf(n);
            long answer=0;

            for(int i=0;i<s.length();i++){
                char c= s.charAt(i);
                answer+=dp[c-'0'][m];
                answer%=q;
            }

            //System.out.println(answer);
            bw.write(String.valueOf(answer)+"\n");
        }
        bw.flush();
        bw.close();
    }

}
