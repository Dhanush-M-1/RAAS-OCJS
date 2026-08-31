import sys
input = sys.stdin.readline
from collections import defaultdict

n, m = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
cnta = defaultdict(int)
cntb = defaultdict(int)
for x in a:
    cnta[x] += 1
for x in b:
    cntb[x] += 1
aa = list(set(a))
bb = list(set(b))
assert len(aa) == len(bb)
nn = len(aa)

ans = 10**20
for k in range(nn):
    add = (bb[k] - aa[0] + m) % m
    ok = True
    for i in range(nn):
        x = aa[i]
        y = (x + add) % m
        if cnta[x] != cntb[y]:
            ok = False
            break
    if ok:
        ans = min(ans, add)
print(ans)

