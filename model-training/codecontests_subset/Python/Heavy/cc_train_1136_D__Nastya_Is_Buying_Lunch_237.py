# Testing
# https://codeforces.com/contest/1136/submission/51182491
# with quick input
import os
from io import BytesIO
input = BytesIO(os.read(0, os.fstat(0).st_size)).readline

ii = lambda: int(input())
mi = lambda: map(int, input().split())
li = lambda: list(mi())

n, m = mi()
a = li()
pairs = [li() for _ in range(m)]
last = a.pop()
friend = [[] for i in range(n + 1)]
for u, v in pairs:
    friend[u].append(v)
mark = [0] * (n + 1)
mark[last] = 1
req = 1
ans = 0
for i in range(n - 2, -1, -1):
    u = a[i]
    cnt = sum(mark[v] for v in friend[u])
    if cnt == req:
        ans += 1
    else:
        mark[u] = 1
        req += 1
print(ans)