import sys
import heapq
hpush = heapq.heappush
hpop = heapq.heappop
input = sys.stdin.readline
for _ in range(int(input())):
  N = int(input())
  a = []
  mnsm = 0
  table = [[] for _ in range(N + 1)]
  ls = 0
  for _ in range(N):
    K, L, R = map(int, input().split())
    mnsm += min(L, R)
    a.append((K, L, R))
    if L >= R: table[K - 1].append((L, R))
    else: table[K].append((L, R))
    ls += L >= R
  h = []
  hh = []
  res = 0
  for i in range(N):
    for L, R in table[i]:
      if L >= R:
        hpush(h, L - R)
        res += L - R
    while len(h) > i + 1: res -= max(0, hpop(h))
  for i in range(N, -1, -1):
    for L, R in table[i]:
      if R > L:
        hpush(hh, R - L)
        res += R - L
    while len(hh) > N - i:
      res -= max(0, hpop(hh))
  print(mnsm + res)