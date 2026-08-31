n, m = map(int, input().split())
a = list(map(int, input().split()))
a.sort()
b = {}
c = {}
mm = 10e10
for i in range(n):
    k = a[i]
    t = 0
    while k > 0:
        if k not in b or b[k] < m:
            b[k] = b.get(k, 0) + 1
            c[k] = c.get(k, 0) + t
            if b[k] == m:
                mm = min(mm, c[k])
        t += 1
        k //= 2
    else:
        if 0 not in b or b[0] < m:
            b[0] = b.get(0, 0) + 1
            c[0] = c.get(0, 0) + t
        if b[0] == m:
            mm = min(mm, c[0])

print(mm)
