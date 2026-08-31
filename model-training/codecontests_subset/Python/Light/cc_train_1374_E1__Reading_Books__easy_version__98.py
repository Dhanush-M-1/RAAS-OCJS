n, k = map(int, input().split())
a = []
b = []
s = []
for i in ' ' * n:
    t, x, y = map(int, input().split())
    if x & y:
        s += [t]
    elif x:
        a += [t]
    elif y:
        b += [t]
s += [i + j for i, j in zip(sorted(a), sorted(b))]
print(-1 if len(s) < k else sum(sorted(s)[:k]))