import sys
from heapq import *
readline = sys.stdin.readline

def solve2(left):
    if len(left) == 0:
        return 0
    ans = 0
    k2values = {}
    for v, k in left:
        if k not in k2values:
            k2values[k] = []
        k2values[k].append(v)
    
    pq = []
    maxk = max(k for v,k in left)
    for k in range(maxk, 0, -1):
        if k in k2values:
            for v in k2values[k]:
                heappush(pq, -v)
        if len(pq) > 0:
            v = heappop(pq)
            ans += -v
    return ans


def solve():
    N = int(readline())
    
    left = []
    right = []
    
    ans = 0
    
    for i in range(N):
        k, l, r = map(int, readline().split())
        if l > r:
            left.append((l - r, k))
            ans += r
        else:
            right.append((r - l, N - k))
            ans += l
    
    ans += solve2(left)
    ans += solve2(right)
    
    print(ans)

T = int(readline())
for i in range(T):
    solve()