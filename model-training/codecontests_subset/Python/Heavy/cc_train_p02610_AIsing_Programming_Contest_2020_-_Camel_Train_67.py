from heapq import heappush,heappop,heapify

def f(p):
  res = 0
  s = len(p)
  for i in range(s):
    if p[i][0] > s:
      p[i][0] = s
  p.sort(reverse = True)
  hq = []
  idx = 0
  for i in range(s,0,-1):
    #print('p:',p,'i:',i)
    while(idx < s and p[idx][0] == i):
      heappush(hq,-p[idx][1])
      idx += 1
    #print('hq:',hq)
    if len(hq) > 0:
      res -= heappop(hq)
      #print('res:',res)
  return res

def solve():
  n = int(input())
  pl = []
  pr = []
  ans = 0
  for i in range(n):
    k,l,r = map(int,input().split())
    m = min(l,r)
    l -= m
    r -= m
    ans += m
    if l > 0:
      pl.append([k,l])
    else:
      pr.append([n-k,r])
  #print('pl:',pl,'pr:',pr,'ans:',ans)
  ans += f(pl)
  ans += f(pr)
  print(ans)

t = int(input())
for i in range(t):
  solve()