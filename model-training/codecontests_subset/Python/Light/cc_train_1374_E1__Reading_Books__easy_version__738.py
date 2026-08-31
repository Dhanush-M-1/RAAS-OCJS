n, k = map(int, input().split())
ab, a, b = [], [], []
for _ in range(n):
    t, aa, bb = map(int, input().split())
    if aa and bb:ab.append(t)
    elif aa:a.append(t)
    elif bb:b.append(t)
a.sort()
b.sort()
zz = min(len(a), len(b))
for i in range(zz):ab.append(a[i]+b[i])
print(-1 if len(ab)<k else sum(sorted(ab)[:k]))