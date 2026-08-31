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
    elif y == 0 and z == 1:
        b.append(x)
    elif y == 1 and z == 1:
        ab.append(x)
a.sort()
b.sort()
ab.sort()
if len(ab) + min(len(a), len(b)) < k:
    print("-1")
else:
    for h in range(k):
        if p == min(len(a), len(b)):
            c = c + sum(ab[e:e + k - h])
            break
        elif e == len(ab):
            c = c + sum(a[p:p + k - h]) + sum(b[p:p + k - h])
            break
        c = c + min(a[p] + b[p], ab[e])
        if a[p] + b[p] < ab[e]:
            p = p + 1
        else:
            e = e + 1
    print(c)
