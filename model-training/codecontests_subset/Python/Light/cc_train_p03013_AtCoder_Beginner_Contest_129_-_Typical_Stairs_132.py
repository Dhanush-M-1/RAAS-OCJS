N, M = map(int, input().split())
a = [int(input()) for _ in range(M)] 
mod = 10**9 + 7
X = [1 for _ in range(N+1)]
for i in a:
  X[i] = 0
for j in range(2,N+1):
  if X[j]:
    X[j] = X[j-1] + X[j-2]
ans = X[N] % mod
print(ans)