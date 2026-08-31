N, M = map(int, input().split())
rs = [-1] * (N+1)
rs[0] = 1
rs[1] = 1
for m in range(M):
  am = int(input())
  rs[am] = 0
for n in range(1, N):
  rs[n+1] = 0 if rs[n+1] == 0 else rs[n]+rs[n-1]
#print(rs)
print(rs[N]%1000000007)
