import os
from io import BytesIO

input = BytesIO(os.read(0, os.fstat(0).st_size)).readline

ii = lambda: int(input())
mi = lambda: map(int, input().split())
li = lambda: list(mi())

n, m = mi()
p = li()
ok = [[] for _ in range(n+1)]
for _ in range(m):
    u, v = mi()
    ok[u].append(v)
ans = 0
req = 1
mark = [0] * (n+1)
mark[p[n-1]] = 1
for i in range(n-2, -1, -1):
    cnt = sum(mark[v] for v in ok[p[i]])
    if cnt == req:
        ans += 1
    else:
        req += 1
        mark[p[i]] = 1
print(ans)