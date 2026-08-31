from heapq import heapify,heappush,heappop

T = int(input())
for _ in range(T):
  N = int(input())
  base = 0
  A = []
  C = []
  B = [0 for _ in range(N)]
  Q = []
  S = []
  for i in range(N):
    K, L, R = map(int,input().split()) 
    tmp = min(L, R)
    K -= 1
    if L > R:
      A.append((K,L-R))
    if R >= L:
      if K < N - 1:
        C.append((N-2-K,R-L))
    base += tmp
  A.sort(reverse = True)
  C.sort(reverse = True)
  #print(base)
  #print(A,C)
  
  for i in range(N):
    if len(A) == 0:
      break
    while A[-1][0] == i:
      a = A[-1][1] 
      A.pop()
      heappush(Q, a)
      if len(A) == 0:
        break
    while i+1 < len(Q):
      heappop(Q)
      if len(Q) == 0:
        break
  
  for i in range(N):
    if len(C) == 0:
      break
    while C[-1][0] == i:
      a = C[-1][1] 
      C.pop()
      heappush(S, a)
      if len(C) == 0:
        break
    while i+1 < len(S):
      heappop(S)
      if len(S) == 0:
        break
      
  print(base + sum(Q) + sum(S))
     
  """
  l = 0
  r = N-1
  for a in A:
    if a[2] == 0:
      if l < a[0]:
        l += 1
        base += a[1] 
    else:
      if r >= N-a[0]:
        r -= 1
        base += a[1]
  print(base)
  """
#print(A)