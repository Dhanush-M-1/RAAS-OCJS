import sys,heapq

input=sys.stdin.readline

for _ in range(int(input())):
    N=int(input())
    camelL=[]
    camelR=[]
    ans=0
    for i in range(N):
        k,l,r=map(int,input().split())
        if l<r:
            camelR.append((N-k,r-l))
            ans+=l
        elif l>r:
            camelL.append((k,l-r))
            ans+=r
        else:
            ans+=l
    camelL.sort()
    que=[]
    for i in range(len(camelL),0,-1):
        while camelL and camelL[-1][0]>=i:
            id,val=camelL.pop()
            heapq.heappush(que,(-val,id))
        if que:
            val,id=heapq.heappop(que)
            ans-=val
    camelR.sort()
    que=[]
    for i in range(len(camelR),0,-1):
        while camelR and camelR[-1][0]>=i:
            id,val=camelR.pop()
            heapq.heappush(que,(-val,id))
        if que:
            val,id=heapq.heappop(que)
            ans-=val
    print(ans)