N,M=map(int,input().split())
b=[0]*(N+1)
dp=[0]*(N+2);dp[N]=1
for i in range(M):b[int(input())]=1
for i in range(N):
    if b[N-i-1]:continue
    dp[N-i-1]=(dp[N-i]+dp[N-i+1])%1000000007
print(dp[0])