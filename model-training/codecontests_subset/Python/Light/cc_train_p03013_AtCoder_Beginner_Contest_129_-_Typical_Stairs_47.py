n, m = map(int, input().split())
dq = [1]*(n+1)
for _ in range(m):
  dq[int(input())]=0
mod = 10**9+7
x, y = 0, 1
for i in range(1, n+1):
  x,y = y, dq[i] * (x+y) % mod
print(y)