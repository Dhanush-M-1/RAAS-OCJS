import heapq
def solve():
  N = int(input())
  ans = 0
  left,right = [ [] for i in range(N) ],[ [] for i in range(N) ]
  for _ in range(N):
    k,l,r = map(int,input().split())
    ans += min(l,r)
    if l>r:
      left[k-1].append(l-r)
    else:
      if k >= N: continue
      right[k].append(r-l)

  # left
  pq = []
  for i in range(N-1,-1,-1):
    for l in left[i]:
      heapq.heappush(pq,-l)
    if pq:
      ans += -heapq.heappop(pq)

  # right
  pq = []
  for i in range(N):
    for r in right[i]:
      heapq.heappush(pq,-r)
    if pq:
      ans += -heapq.heappop(pq)

  print(ans)

for i in range(int(input())):
  solve()