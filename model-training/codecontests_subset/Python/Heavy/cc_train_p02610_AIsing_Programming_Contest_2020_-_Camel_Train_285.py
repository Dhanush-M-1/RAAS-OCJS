from heapq import heapify
from heapq import heappush as push
from heapq import heappop as pop
def solve():
  n=int(input())
  ans=0
  pos=[[] for _ in range(n)]
  neg=[[] for _ in range(n)]
  for _ in range(n):
    k,l,r=map(int,input().split())
    ans+=min(l,r)
    if l>r:
      pos[k-1].append(l-r)
    elif l<r and k<n:
      neg[k].append(r-l)
  q=[]
  heapify(q)
  for i in range(n):
    for j in pos[i]:
      push(q,j)
    while i+1<len(q):
      pop(q)
  while q:
    ans+=pop(q)
  for i in range(n-1,-1,-1):
    for j in neg[i]:
      push(q,j)
    while n-i<len(q):
      pop(q)
  while q:
    ans+=pop(q)
  print(ans)

def main():
  t=int(input())
  for _ in range(t):
    solve()

if __name__=='__main__':
  main()