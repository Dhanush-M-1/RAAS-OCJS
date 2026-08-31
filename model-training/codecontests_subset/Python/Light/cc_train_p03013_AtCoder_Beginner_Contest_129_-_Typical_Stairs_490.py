MOD=10**9+7
N,M=[int(s) for s in input().split()]
ls=[1 for _ in range(N+1)]
for i in range(M):
  ls[int(input())]=0
for n in range(2,N+1):
  if ls[n]!=0:
    ls[n]=(ls[n-1]+ls[n-2])%MOD
print(ls[N])