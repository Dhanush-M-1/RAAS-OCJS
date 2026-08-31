def resolve():
    #n=int(input())
    #a,b=map(int,input().split())
    #x=list(map(int,input().split()))
    #a=[list(map(lambda x:int(x)%2,input().split())) for _ in range(h)]
    import heapq 

    t=int(input())
    for i in range(t):
        n=int(input())
        L=[[] for _ in range(n)]
        R=[[] for _ in range(n)]
        lm,rm=-1,-1
        ans=0
        for j in range(n):
            k,l,r=map(int,input().split())
            ans+=min(l,r)
            if l-r>=0:
                L[k-1].append(r-l)
                lm=max(lm,k-1)
            else:
                if n-k-1>=0:
                    R[n-k-1].append(l-r)
                    rm=max(rm,n-k-1)
        q=[]
        heapq.heapify(q)
        if lm>-1:
            for j in range(lm,-1,-1):
                for k in L[j]:
                    heapq.heappush(q,k)
                if q:
                    ans-=heapq.heappop(q)
        q=[]
        heapq.heapify(q)
        if rm<n:
            for j in range(rm,-1,-1):
                for k in R[j]:
                    heapq.heappush(q,k)
                if q:
                    ans-=heapq.heappop(q)
        print(ans)

if __name__ == '__main__':
    resolve()