import heapq
T=int(input())
for case in range(T):
    N=int(input())
    KLR=[[],[]]
    ans=0
    for i in range(N):
        k,l,r=map(int,input().split())
        ans+=min(l,r)
        if l>=r:
            KLR[0].append((k,l,r))
        else:
            KLR[1].append((N-k,r,l))
    Len=[len(KLR[0]),len(KLR[1])]
    for i in range(2):
        KLR[i].sort()
        for j in range(Len[i]):
            k,l,r=KLR[i][j]
            KLR[i][j]=(min(k,Len[i]),l,r)
        q=[]
        index=0
        for j in range(Len[i]+1):
            while(index<Len[i]):
                k,l,r=KLR[i][index]
                if k==j:
                    heapq.heappush(q,(l-r,k,l,r))
                    index+=1
                else:
                    break
            while(len(q)>j):
                heapq.heappop(q)
        while(len(q)>0):
            ans+=heapq.heappop(q)[0]
    print(ans)
