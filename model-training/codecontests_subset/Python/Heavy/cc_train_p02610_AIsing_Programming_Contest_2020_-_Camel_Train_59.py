from heapq import heappop,heappush
def solve(n,klr):
  kk=[(-1,-1)]
  for k,l,r in klr:kk.append((k-1,r-l))
  kk.sort()
  h=[]
  ans=0
  for i in range(n-1,-1,-1):
    while kk[-1][0]>=i:heappush(h,kk.pop()[1])
    if len(h):ans-=heappop(h)
  return ans

for _ in range(int(input())):
  n=int(input())
  klr=[list(map(int,input().split()))for _ in range(n)]
  pk=[]
  mk=[]
  ans=0
  for i in range(n):
    k,l,r=klr[i]
    ans+=min(l,r)
    if l>=r:pk.append(i)
    else:mk.append(i)
  l=len(pk)
  for i in mk:
    klr[i][0]=n-klr[i][0]
    klr[i][1],klr[i][2]=klr[i][2],klr[i][1]
  ans+=solve(len(pk),[klr[i]for i in pk])+solve(len(mk),[klr[i]for i in mk])
  print(ans)