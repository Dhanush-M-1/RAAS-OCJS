import heapq
T=int(input())
for _ in range(T):
    N=int(input())
    lq=[[] for _ in range(N+1)]
    rq=[[] for _ in range(N+1)]
    ans=0
    for _ in range(N):
        K,L,R=map(int,input().split())
        ans+=min(L,R)
        if L>R:
            lq[K].append(L-R)
        else:
            rq[K].append(R-L)
    ls=[]
    for i in range(1,N+1):
        for v in lq[i]:
            heapq.heappush(ls,v)
        while len(ls)>i:
            heapq.heappop(ls)
    ans+=sum(ls)
    rs=[]
    for i in range(N,0,-1):
        for v in rq[i]:
            heapq.heappush(rs,v)
        while len(rs)>N-i:
            heapq.heappop(rs)
    ans+=sum(rs)
    print(ans)