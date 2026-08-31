import heapq

T = int(input())

for _ in range(T):
  N = int(input())
  res = 0
  Ls,Rs = [[] for _ in range(N)], [[] for _ in range(N)]
  for _ in range(N):
    K,L,R = map(int,input().split())
    m = min(L,R)
    res += m
    L -= m
    R -= m
    if L>0:
      Ls[K-1].append(L)
    else:
      if K != N:
        Rs[K].append(R)


  pq1 = []
  for i in reversed(range(N)):
    for l in Ls[i]:
      heapq.heappush(pq1, -l)
    if pq1:
      p = -heapq.heappop(pq1)
      res += p

  pq2 = []
  for i in range(N):
    for r in Rs[i]:
      heapq.heappush(pq2, -r)
    if pq2:
      p = -heapq.heappop(pq2)
      res += p

  print(res)