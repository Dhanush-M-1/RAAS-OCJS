import heapq
T=int(input())

for _ in range(T):
  N=int(input())
  
  llist=[]
  rlist=[]
  base=0
  for _ in range(N):
    K,L,R=map(int,input().split())
    base+=min(L,R)
    if L>R:
      llist.append((K,L-R))
    elif L<R:
      rlist.append((N-K,R-L))
      
  llist.sort()
  rlist.sort()      
  #print(base)
  #print(llist)
  #print(rlist)
  
  hq_left=[]
  for i,l in llist:
    heapq.heappush(hq_left,l)
    if len(hq_left)>i:
      heapq.heappop(hq_left)
  hq_right=[]
  for i,r in rlist:
    heapq.heappush(hq_right,r)
    if len(hq_right)>i:
      heapq.heappop(hq_right)
      
  answer=base
  while hq_left:
    answer+=heapq.heappop(hq_left)
  while hq_right:
    answer+=heapq.heappop(hq_right)
    
  print(answer)