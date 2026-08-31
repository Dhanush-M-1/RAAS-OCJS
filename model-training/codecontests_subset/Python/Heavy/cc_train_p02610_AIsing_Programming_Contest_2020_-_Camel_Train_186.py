from heapq import heappop, heappush

def calc(KD, N):
  now = 0
  hq = []
  for i in range(1, N+1):
    while now < N and KD[now][0] <= i:
      heappush(hq, KD[now][1])
      now += 1
    while len(hq) > i:
      heappop(hq)
  res = sum(hq)
  while now < N:
    res += KD[now][1]
    now += 1
  return res

def solve(KLR, N):
  res = 0
  KD_l = []; KD_r = []
  for k, l, r in KLR:
    if l < r:
      if k < N:
        KD_r.append((N-k, r-l))
      res += l
    elif l > r:
      if k < N:
        KD_l.append((k, l-r))
        res += r
      else:
        res += l
    else:
      res += l
  KD_l.sort(); KD_r.sort()
  Nl = len(KD_l); Nr = len(KD_r)
  res += calc(KD_l, Nl)
  res += calc(KD_r, Nr)
  return res


ans = []
T = int(input())
for i in range(T):
  N = int(input())
  KLR = [tuple(map(int, input().split())) for i in range(N)]
  ans.append(solve(KLR, N))

print(*ans, sep='\n')