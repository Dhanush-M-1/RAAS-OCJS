import sys
input = sys.stdin.readline
from collections import *
from heapq import *

for _ in range(int(input())):
    N = int(input())
    ans = 0
    dl = defaultdict(list)
    dr = defaultdict(list)
    
    for _ in range(N):
        K, L, R = map(int, input().split())
        m = min(L, R)
        ans += m
        
        if L==m:
            dr[K+1].append(R-m)
        else:
            dl[K].append(L-m)
        
    pq = []
    
    for i in range(N, 0, -1):
        for v in dl[i]:
            heappush(pq, -v)
        
        if len(pq)>0:
            ans += -heappop(pq)
    
    pq = []
    
    for i in range(1, N+1):
        for v in dr[i]:
            heappush(pq, -v)
        
        if len(pq)>0:
            ans += -heappop(pq)
    
    print(ans)