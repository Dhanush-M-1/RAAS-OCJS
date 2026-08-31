from heapq import heappop, heappush
import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    n = int(input())
    ans = 0
    camels0 = [[] for _ in range(n)]
    camels1 = [[] for _ in range(n)]
    for _ in range(n):
        k, l, r = map(int, input().split())
        if l>r:
            camels0[k-1].append(l-r)
        elif l<r and k<n:
            camels1[n-k-1].append(r-l)
        ans += min(l, r)
    h = []
    for i in range(n):
        for j in camels0[i]:
            heappush(h, j)
        while len(h)>i+1:
            heappop(h)
    ans += sum(h)
    h = []
    for i in range(n):
        for j in camels1[i]:
            heappush(h, j)
        while len(h)>i+1:
            heappop(h)
    ans += sum(h)
    print(ans)