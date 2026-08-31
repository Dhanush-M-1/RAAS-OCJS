n, k = map(int, input().split())
x, y, z = [], [], []
for _ in range(n):
    t, a, b = map(int, input().split())
    if a == b == 1:
        x.append(t)
    elif a == 1:
        y.append(t)
    elif b == 1:
        z.append(t)
lx, ly, lz = len(x), len(y), len(z)
x.sort()
y.sort()
z.sort()
u, v = len(x), min(len(y), len(z))
ans = 0
if u + v >= k:
    i, j = 0, 0
    for _ in range(k):
        if i < u and j < v:
            if x[i] <= y[j] + z[j]:
                ans += x[i]
                i += 1
            else:
                ans += (y[j] + z[j])
                j += 1
        elif i < u:
            ans += x[i]
            i += 1
        elif j < v:
            ans += (y[j] + z[j])
            j += 1
else:
    ans = -1
print(ans)