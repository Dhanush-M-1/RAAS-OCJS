import sys
input=lambda: sys.stdin.readline().rstrip()
t=int(input())
import heapq
for _ in range(t):
  n=int(input())
  ans=0
  C=[]
  D=[]
  for i in range(n):
    k,l,r=map(int,input().split())
    if l>r:
      C.append((k,l-r))
      ans+=r
    else:
      D.append((n-k,r-l))
      ans+=l
  C.sort(key=lambda x:(x[0],x[1]), reverse=True)
  D.sort(key=lambda x:(x[0],x[1]), reverse=True)
  c,d=len(C),len(D)
  H=[]
  cur=0
  for i in range(1,c+1)[::-1]:
    while cur<c:
      k,l=C[cur]
      if k<i:
        break
      else:
        heapq.heappush(H,(-l,k))
        cur+=1
    if H:
      ll,kk=heapq.heappop(H)
      ll=-ll
      ans+=ll
  H=[]
  cur=0
  for i in range(1,d+1)[::-1]:
    while cur<d:
      k,l=D[cur]
      if k<i:
        break
      else:
        heapq.heappush(H,(-l,k))
        cur+=1
    if H:
      ll,kk=heapq.heappop(H)
      ll=-ll
      ans+=ll
  print(ans)