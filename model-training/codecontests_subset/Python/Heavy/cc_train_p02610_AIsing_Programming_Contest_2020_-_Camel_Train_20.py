import heapq

T = int(input())

for _ in range(T):
  N = int(input())
  rlt = 0
  dicl = {}
  dicr = {}
  Ls = []
  Rs = []
  mkl = 0
  mkr = 0
  for i in range(1,N+1):
    k, l, r = map(int, input().split())
    rlt += min(l, r)
    if l > r:
      if k not in dicl:
        dicl[k] = [l-r]
      else:
        dicl[k].append(l-r)
      mkl = max(mkl, k)
    else:
      if N-k not in dicr:
        dicr[N-k] = [r-l]
      else:
        dicr[N-k].append(r-l)
      mkr = max(mkr, N-k)

  for i in range(1,mkl+1):
    if i in dicl:
      for j in dicl[i]:
        heapq.heappush(Ls, j)
        rlt += j
    while len(Ls) > i:
      t = heapq.heappop(Ls)
      rlt -= t
  for i in range(1,mkr+1):
    if i in dicr:
      for j in dicr[i]:
        heapq.heappush(Rs, j)
        rlt += j
    while len(Rs) > i:
      t = heapq.heappop(Rs)
      rlt -= t
      
  print(rlt)