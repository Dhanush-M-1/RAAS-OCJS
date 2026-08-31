import heapq
T=int(input())
for _ in range(T):
  ans=0
  N=int(input())
  Ls=[[] for _ in range(N)]
  #RsはK=Nのとき、達成不可。
  Rs=[[] for _ in range(N)]
  for _ in range(N):
    K,L,R=map(int,input().split())
    ans+=max(L,R)
    if L>R:
      Ls[K-1].append(L-R)
    if L<R:
      if K==N:
        ans-=R-L
        continue
      Rs[N-K].append(R-L)
  #先に左から
  dat=[]
  heapq.heapify(dat)
  for i in range(N):
    if not Ls[i]:
      continue
    for l in Ls[i]:
      heapq.heappush(dat,l)
    while len(dat)>i+1:
      ans-=heapq.heappop(dat)
  #次に右を
  dat=[]
  heapq.heapify(dat)
  for i in range(1,N):
    if not Rs[i]:
      continue
    for l in Rs[i]:
      heapq.heappush(dat,l)
    while len(dat)>i:
      ans-=heapq.heappop(dat)
  print(ans)
      
    
    