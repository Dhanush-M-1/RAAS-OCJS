import sys
import collections
from math import floor, ceil, log2
#sys.stdin = open('input.txt', 'r')
inp = lambda: sys.stdin.readline().strip()

n, m = map(int, inp().split())
a = list(map(int, inp().split()))
a = [0] + list(reversed(a))
g = [[0] for i in range(n + 1)]
for i in range(m):
    u, v = map(int, inp().split())
    g[u].append(v)
p = [0] * (n + 1)
p[a[1]] = 1
cnt = 1
ans = 0
for i in range(2, n + 1):
    cnt2 = 0
    for to in g[a[i]]:
        if p[to] == 1:
            cnt2 += 1
    if cnt == cnt2:
        ans += 1
    else:
        p[a[i]] = 1
        cnt += 1
print(ans)