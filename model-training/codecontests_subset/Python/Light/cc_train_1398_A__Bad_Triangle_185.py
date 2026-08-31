from bisect import *
T = int(input())
for i in range(T):
  N = int(input())
  A = list(map(int, input().split()))
  for i in range(N-2):
    if A[i]+A[i+1]>A[-1]:
      continue
    ind = bisect_left(A,A[i]+A[i+1])+1
    print(i+1,i+2,ind)
    break
  else:
    print(-1)

    
