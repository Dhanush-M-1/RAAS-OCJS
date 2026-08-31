import sys
from collections import defaultdict

sys.setrecursionlimit(1000000)

N, M = map(int, sys.stdin.readline().split())
E = defaultdict(list)

for _ in range(M):
    l, r, d = map(int, sys.stdin.readline().split())
    l -= 1
    r -= 1
    E[l].append((r, d))
    E[r].append((l, -d))

xs = [None] * N

def dfs(i, x):
    xs[i] = x
    mi, ma = x, x
    for j, d in E[i]:
        if xs[j] is None:
            res = dfs(j, x + d)
            if res is None:
                return None
            else:
                mi2, ma2 = res
                mi = min(mi2, mi)
                ma = max(ma2, ma)
        else:
            if xs[j] - x != d:
                return None
    return mi, ma

for i in range(N):
    if xs[i] is None:
        res = dfs(i, 0)
        if res is None:
            break
        else:
            mi, ma = res
            if ma - mi > 1e9:
                break
else:
    print('Yes')
    sys.exit()
print('No')
