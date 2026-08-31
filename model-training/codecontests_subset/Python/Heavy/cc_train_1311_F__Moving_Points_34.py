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
x = list(map(int, input().split()))
v = list(map(int, input().split()))
a = [()] * (n+1)
for i in range(1, n+1):
    a[i] = (x[i-1], v[i-1])
a.sort()

f = [0] * (n+1)
f2 = [0] * (n+1)
for i in range(1, n+1):
    update(f, i, a[i][0])
    update(f2, i, 1)


b = []
for i in range(1, n+1):
    b.append((-a[i][1], -i))
heapify(b)

ans = 0
while b:
    v, i = heappop(b)
    v, i = -v, -i
    x = a[i][0]
    if i > 1:
        sum = query(f, i-1)
        cnt = query(f2, i-1)
        ans += x * cnt - sum
    update(f, i, -x)
    update(f2, i, -1)
print(ans)