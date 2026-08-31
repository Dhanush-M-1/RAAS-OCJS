n,m=map(int,input().split())
a=set()
for i in range(m):
  a.add(int(input()))
dp=[0]*(n+2)
dp[0]=0
dp[1]=1
for j in range(n):
  if j+1 not in a:
    dp[j+2]=(dp[j]+dp[j+1])%(10**9+7)
  else:
    dp[j+2]=0
print(dp[j+2]%(10**9+7))