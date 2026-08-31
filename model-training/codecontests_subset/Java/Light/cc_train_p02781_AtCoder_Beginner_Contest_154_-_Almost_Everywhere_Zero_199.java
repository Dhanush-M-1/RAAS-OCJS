
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

 class Main {

    static final int M = 100;

    static int dp[][][]= new int[M][M][2];

    static int K;
    static Vector<Integer> num;
    
    static int countInRangeUtil(int pos, int cnt, int tight )
    {
        // Last position
        if (pos == num.size()) {

            if (cnt == K)
                return 1;
            return 0;
        }

        if (dp[pos][cnt][tight] != -1)
            return dp[pos][cnt][tight];

        int ans = 0;
        
        int limit = (tight!=0 ? 9 : num.get(pos));

        for (int dig = 0; dig <= limit; dig++) {
            int currCnt = cnt;

            // If the current digit is nonzero
            // increment currCnt
            if (dig != 0)
                currCnt++;

            int currTight = tight;

            // At this position, number becomes
            // smaller
            if (dig < num.get(pos))
                currTight = 1;

            // Next recursive call
            ans += countInRangeUtil(pos + 1, currCnt, currTight);
        }
        return dp[pos][cnt][tight] = ans;
    }
    
    static int countInRange(Vector<Integer> num)
    {

        for(int i=0;i<M;i++)
            for(int j=0;j<M;j++)
                for(int k=0;k<2;k++)
                    dp[i][j][k]=-1;
        return countInRangeUtil(0, 0, 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.next();
        K=in.nextInt();
        num=new Vector<>();
        for(int i=0;i<s.length();i++){
            num.add(s.charAt(i)-'0');
        }
        int x=countInRange(num);
        System.out.println(x);
    }
}
