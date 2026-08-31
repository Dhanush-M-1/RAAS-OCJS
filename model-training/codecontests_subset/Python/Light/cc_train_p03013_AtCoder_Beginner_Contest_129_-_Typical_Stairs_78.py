M=10**9+7
n,m,*l=map(int,open(0).read().split())
dp=[1]+[0]*n
for i in l: dp[i]=-1
dp[1]+=1
for i in range(n-1):
  if dp[i+2]<0: dp[i+2]=0
  else: dp[i+2]=(dp[i]+dp[i+1])%M
print(dp[n])