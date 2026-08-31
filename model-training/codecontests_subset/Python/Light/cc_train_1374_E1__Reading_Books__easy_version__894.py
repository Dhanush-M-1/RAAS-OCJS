n, k = map(int, input().split())
a = []
b = []
ab = []
for i in ' ' * n:
    t, x, y = map(int, input().split())
    if x & y:
        ab += [t]
    elif x:
        a += [t]
    elif y:
        b += [t]
for i, j in zip(sorted(a), sorted(b)):
    ab += [i + j]
print(-1 if len(ab) < k else sum(sorted(ab)[:k]))