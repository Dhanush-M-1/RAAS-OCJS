n,m=map(int,input().split())
a=[int(input()) for i in range(m)]

dp=[1]+['']*n

for i in a:
  dp[i]=0

if dp[1]=='':
  dp[1]=1
  

for i in range(2,n+1):
  if dp[i]=='':
    dp[i]=(dp[i-1]+dp[i-2])%(10**9+7)

print(dp[-1])
