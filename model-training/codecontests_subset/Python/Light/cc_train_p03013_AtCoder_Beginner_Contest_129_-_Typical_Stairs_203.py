N, M = map(int, input().split())
A = [int(input()) for _ in range(M)]
L = [0]*(N+1)
for a in A:
  L[a]=-1
L[0] = 1
L[1] += 1
for i in range(2, N+1):
  if L[i]==-1:
    L[i]=0
  else:
    L[i] = L[i-1]+ L[i-2]
print(L[-1]%(10**9+7))