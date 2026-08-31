import sys
from heapq import heappop, heappush


T = int(input())
for t in range(T):
    N = int(input())
    left, right = [], []
    ans = 0
    for i in range(N):
        K, L, R = map(int, sys.stdin.readline().split())
        if L > R:
            ans += L
            left.append((K, L - R))
        elif L < R:
            ans += R
            right.append((K, R - L))
        else:
            ans += L
    # left
    pool = []
    pos = 1
    left.sort()
    cur = 0
    while cur < len(left):
        while cur < len(left) and left[cur][0] == pos:
            k, d = left[cur]
            heappush(pool, d)
            cur += 1
        while len(pool) > pos:
            d = heappop(pool)
            ans -= d
        pos += 1
            
    # right
    pool = []
    pos = N
    right.sort(reverse=True)
    cur = 0
    while cur < len(right):
        while cur < len(right) and right[cur][0] == pos:
            k, d = right[cur]
            heappush(pool, d)
            cur += 1
        while len(pool) > N - pos:
            d = heappop(pool)
            ans -= d
        pos -= 1

    print(ans)
