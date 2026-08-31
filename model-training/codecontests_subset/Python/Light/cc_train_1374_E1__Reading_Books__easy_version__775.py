#!/usr/bin/pypy3
n, k = map(int, input().split())

x, y, z = [], [], []
for _ in range(n):
    t, a, b = map(int, input().split())
    if a & b:
        z.append(t)
    elif a:
        x.append(t)
    elif b:
        y.append(t)
x.sort()
y.sort()
for i in range(min(len(x), len(y))):
    z.append(x[i] + y[i])

z.sort()
if len(z) >= k:
    print(sum(z[:k]))
else:
    print(-1)
