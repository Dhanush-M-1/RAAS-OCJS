n, k = map(int, input().split())
a = []
b = []
ab = []
c = 0
p = 0
e = 0
for q in range(n):
    x, y, z = map(int, input().split())
    if y == 1 and z == 0:
        a.append(x)
    if y == 0 and z == 1:
        b.append(x)
    if y == 1 and z == 1:
        ab.append(x)
a.sort()
b.sort()
ab.sort()
if len(ab) + min(len(a), len(b)) < k:
    print("-1")
else:
    for h in range(k):
        if p == min(len(a), len(b)):
            for t in range(k - h):
                c = c + ab[e]
                e = e + 1
            break
        elif e == len(ab):
            for r in range(k - h):
                c = c + a[p] + b[p]
                p = p + 1
            break
        c = c + min(a[p] + b[p], ab[e])
        if a[p] + b[p] < ab[e]:
            p = p + 1
        else:
            e = e + 1
    print(c)
