N, M = map(int, input().split())
List = [int(input()) for _ in range(M)]

P = 10**9+7
dp = [1]*(N+1)

for i in List:
    dp[i]=0

for j in range(1, N):
    if dp[j+1]!=0:
        dp[j+1] = dp[j]+dp[j-1]
        
print(dp[N]%P)