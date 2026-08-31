MOD=10**9+7
N,M = [int(s) for s in input().split()]
ans=[1 for s in range(N+2)]
ans[N+1]=0
for i in range(M):
  ans[int(input())]=0
for i in range(1,N+1):
  if(ans[i]!=0):
    ans[i]=(ans[i-1]+ans[i-2])%MOD
print(ans[N])