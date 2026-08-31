import sys
input = sys.stdin.readline
from collections import defaultdict
from heapq import *

n, k = map(int, input().split())
a = list(map(int, input().split()))
pqs = defaultdict(list)

for i in range(n):
    ai = a[i]
    cnt = 0
    
    while True:
        if len(pqs[ai])<k:
            heappush(pqs[ai], -cnt)
        else:
            if -pqs[ai][0]>cnt:
                heappop(pqs[ai])
                heappush(pqs[ai], -cnt)
        
        if ai==0:
            break
        
        ai //= 2
        cnt += 1

ans = 10**18

for pq in pqs.values():
    if len(pq)<k:
        continue
    
    ans = min(ans, -sum(pq))

print(ans)