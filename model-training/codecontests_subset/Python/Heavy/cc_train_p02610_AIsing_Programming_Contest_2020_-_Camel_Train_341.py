import sys
input = sys.stdin.readline
import heapq
T = int(input())
for _ in range(T):
    N = int(input())
    KLR = [tuple(map(int,input().split())) for i in range(N)]
    ans = 0
    LK = [[] for _ in range(N+1)]
    RK = [[] for _ in range(N+1)]
    for k,l,r in KLR:
        ans += min(l,r)
        if l >= r:
            LK[k].append(l-r)
        else:
            RK[k].append(r-l)
    lq = []
    for i in range(1,N+1):
        for v in LK[i]:
            heapq.heappush(lq, v)
        while len(lq) > i:
            heapq.heappop(lq)
    ans += sum(lq)
    rq = []
    for i in range(N,0,-1):
        for v in RK[i]:
            heapq.heappush(rq, v)
        while len(rq) >= N+1-i:
            heapq.heappop(rq)
    ans += sum(rq)
    print(ans)