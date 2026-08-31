n,m=map(int,input().split())
a=[int(input()) for i in range(m)]
b=set(a)
dp=[0]*(n+2)
dp[0]=0
dp[1]=1
for j in range(n):
  if j+1 not in b:
    dp[j+2]=(dp[j]+dp[j+1])%(10**9+7)
  else:
    dp[j+2]=0
print(dp[j+2]%(10**9+7))