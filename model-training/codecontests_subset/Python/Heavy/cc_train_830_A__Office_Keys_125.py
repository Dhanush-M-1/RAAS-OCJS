pp = list(map(int, input().split()))
inf = int(1e18)
n = pp[0]
k = pp[1]
p = pp[2]
a = list(map(int, input().split()))
b = list(map(int, input().split()))
a.sort()
b.sort()
dp = [[inf for j in range(0, 2011)] for i in range(0, 1011)]
for i in range(0, k):
    dp[0][i] = abs(a[0] - b[i]) + abs(b[i] - p)
for i in range(1, n):
    for j in range(0, k):
        dp[i][j] = min(int(dp[i][j]), max(abs(a[i] - b[j]) + abs(b[j] - p), int(dp[i - 1][j - 1])))
ans = int(1e18)
for i in range(0, k):
    ans = min(ans, int(dp[n - 1][i]))
print(ans)
			 	    		   	 	 	  	  	  	 		