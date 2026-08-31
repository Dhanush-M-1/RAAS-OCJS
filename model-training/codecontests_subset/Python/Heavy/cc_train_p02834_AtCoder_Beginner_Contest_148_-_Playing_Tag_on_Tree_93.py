N,U,V=map(int,input().split())
AB=[list(map(int,input().split())) for i in range(N-1)]
inf=10**20
c=[[] for i in range(N)]
for u,v in AB:
    c[u-1].append(v-1)
    c[v-1].append(u-1)
from heapq import heappop,heappush
def dij(c,N,s):
    d=[inf]*N
    d[s]=0
    prev=[-1]*N
    q=[]
    heappush(q,(0,s))
    while q:
        u=heappop(q)[1]
        for v in c[u]:
            temp=d[u]+1
            if d[v]>temp:
                d[v]=temp
                prev[v]=u
                heappush(q,(d[v],v))
    return d
d1=dij(c,N,U-1)
d2=dij(c,N,V-1)
r=0
for i in range(N):
    if d1[i]<d2[i]:
        r=max(r,d2[i]-1)
print(0 if len(c[U-1])==1 and c[U-1][0]==V-1 else r)