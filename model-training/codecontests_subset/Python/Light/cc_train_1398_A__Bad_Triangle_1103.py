from bisect import *
T = int(input())
for i in range(T):
  N = int(input())
  A = list(map(int, input().split()))
  for i in range(N-2):
    if A[i]+A[i+1]>A[-1]:
      continue
    print(i+1,i+2,N)
    break
  else:
    print(-1)