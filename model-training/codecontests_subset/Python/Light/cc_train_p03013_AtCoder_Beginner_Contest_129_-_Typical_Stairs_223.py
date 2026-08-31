N, M = map(int, input().split())
A = set([int(input()) for _ in range(M)])
 
dp = [0, 1]
for i in range(N):
    if i+1 in A: dp.append(0)
    else: dp.append(dp[i]+dp[i+1])
print(dp[N+1]%1000000007)