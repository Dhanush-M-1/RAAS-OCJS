import sys
input = sys.stdin.readline
import bisect

def query(f, i):
    ret = 0
    while i:
        ret += f[i]
        i -= (i & -i)
    return ret

def update(f, i, d):
    n = len(f)
    while i < n:
        f[i] += d
        i += (i & -i)

n = int(input())
X = list(map(int, input().split()))
V = list(map(int, input().split()))
r = list(range(n))
r.sort(key=lambda i: X[i])

vlist = sorted(set(V))

f = [0] * (len(vlist) + 1)
f2 = [0] * (len(vlist) + 1)

ans = 0
for i in r:
    x, v = X[i], V[i]
    ii = bisect.bisect_left(vlist, v)
    sm = query(f, ii + 1)
    cnt = query(f2, ii + 1)
    ans += x * cnt - sm
    update(f, ii+1, x)
    update(f2, ii+1, 1)
print(ans)