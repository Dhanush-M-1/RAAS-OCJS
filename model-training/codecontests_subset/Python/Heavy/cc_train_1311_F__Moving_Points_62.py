import sys
input = sys.stdin.readline
from heapq import heappush, heappop, heapify


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

f = [0] * (n+1)
f2 = [0] * (n+1)

b = []
for i, k in enumerate(r):
    b.append((V[k], i))
heapify(b)

ans = 0
while b:
    v, i = heappop(b)
    x = X[r[i]]
    sum = query(f, i)
    cnt = query(f2, i)
    ans += x * cnt - sum
    update(f, i+1, x)
    update(f2, i+1, 1)
print(ans)