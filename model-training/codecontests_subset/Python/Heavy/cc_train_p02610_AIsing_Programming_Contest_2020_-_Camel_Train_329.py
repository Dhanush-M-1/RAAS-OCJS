import sys
from heapq import heappop, heappush

ans_l = []
T = int(input())
for t in range(T):
    ans = 0
    N = int(input())
    left = []
    right = []
    neutral = []
    for i in range(N):
        K, L, R = map(int, sys.stdin.readline().split())
        if L > R:
            heappush(left, (K, L - R, L, R))
        elif L < R:
            heappush(right, (-K, R - L, L, R))
        else:
            ans += L
    # left
    pool = []
    pos = 1
    while left:
        while left and left[0][0] == pos:
            k, d, l, r = heappop(left)
            heappush(pool, (d, l, r))
        while len(pool) > pos:
            d, l, r = heappop(pool)
            ans += r
        pos += 1
    while pool:
        d, l, r = heappop(pool)
        ans += l
            
    # right
    pool = []
    pos = N
    while right:
        while right and right[0][0] == -pos:
            k, d, l, r = heappop(right)
            heappush(pool, (d, l, r))
        while len(pool) > N - pos:
            d, l, r = heappop(pool)
            ans += l
        pos -= 1
    while pool:
        d, l, r = heappop(pool)
        ans += r

    ans_l.append(ans)


print(*ans_l, sep='\n')
