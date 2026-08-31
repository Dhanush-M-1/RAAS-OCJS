import heapq
for _ in range(int(input())):
    N=int(input())
    ListL=[[] for _ in range(N)]
    ListR=[[] for _ in range(N)]
    ans=0
    for _ in range(N):
        k,l,r=map(int,input().split())
        ans+=min(l,r)
        if l>=r:
            ListL[k-1].append(abs(l-r))
        else:
            ListR[k-1].append(abs(l-r))
    S=[]
    for n,L in enumerate(ListL,1):
        for l in L:
            if len(S)<n:
                heapq.heappush(S,l)
            else:
                heapq.heappushpop(S,l) 
    ans+=sum(S)
    S=[]
    for n,L in enumerate(ListR[::-1][1:],1):
        for l in L:
            if len(S)<n:
                heapq.heappush(S,l)
            else:
                heapq.heappushpop(S,l) 
    ans+=sum(S)

    print(ans)