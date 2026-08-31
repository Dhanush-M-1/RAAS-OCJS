import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int stepNum = sc.nextInt();
		int brokenNum = sc.nextInt();
		int[] brokenSteps = new int[brokenNum];
		for(int i = 0; i < brokenNum; i++)brokenSteps[i] = sc.nextInt();
        
        Dp dp = new Dp(stepNum+1);
        for(int index : brokenSteps) Dp.dp[index] = 0;
        int ans = dp.part(stepNum);

		System.out.println(ans);
    }
}

class Dp {
    public static int[] dp;
    public Dp (int num) {
        dp = new int[num];
        for(int i = 0; i < num; i++)dp[i] = -1;
    }

    public int part(int index) {
        if(dp[index] != -1)return dp[index];
        if(index == 0) dp[index] = 1;
        else if(index == 1) dp[index] = 1;
        else dp[index] = part(index-1) + part(index-2);
        while(dp[index] >= Mod.mod) dp[index] -= Mod.mod;
        return dp[index];
    }
}

class Mod{
    static int mod = 1000000007;
}