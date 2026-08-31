n, k = [int(i) for i in input().split()]
a, b, result = list(), list(), list()
for i in ' ' * n:
    t, x, y = [int(x) for x in input().split()]
    if x & y:
        result += [t]
    elif x:
        a += [t]
    elif y:
        b += [t]
for i, j in zip(sorted(a), sorted(b)):
    result += [i + j]
print(-1 if len(result) < k else sum(sorted(result)[:k]))
