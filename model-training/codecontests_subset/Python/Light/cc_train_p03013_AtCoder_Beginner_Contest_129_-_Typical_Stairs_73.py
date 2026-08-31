N,M = map(int,input().split())
A = []
MOD = 1000000007
for _ in range(M):
  a = int(input())
  A.append(a)
DP = [1]*(N+1)
for i in A:
  DP[i] = 0
for i in range(2,N+1):
  DP[i] = (DP[i-1]+DP[i-2])%MOD*DP[i]
print(DP[-1])