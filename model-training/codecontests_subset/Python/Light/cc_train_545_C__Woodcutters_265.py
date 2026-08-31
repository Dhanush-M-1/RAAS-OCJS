n=int(input())

dp=[[0,0,0] for _ in range(n+1)]

# stay, left, right
dp[1] = [0,1,1]

prev = [-999, 0]

for j in range(1,n+1):

	pos, height = map(int, input().split(' '))

	dp[j][0] = max(dp[j-1][0], max(dp[j-1][1], dp[j-1][2] if(prev[0] + prev[1] < pos) else 0 ))

	dp[j][1] = 1+max(dp[j-1][0] if(pos - height > prev[0]) else 0, max(dp[j-1][1] if(pos - height > prev[0]) else 0, dp[j-1][2] if(prev[0] + prev[1] < pos -height) else 0 ))

	dp[j][2] = 1+max(dp[j-1][0], max(dp[j-1][1], dp[j-1][2] if(prev[0] + prev[1] < pos) else 0))

	prev = [pos, height]



print(max(dp[n]))