def gcd(x, y):
        if y == 0:
                return x
        return gcd(y, x % y)

n = int(input())
a = [int(x) for x in input().split()]
c = [int(x) for x in input().split()]
f = {}
for i in range(n):
        h = {}
        for x in f:
                h[x] = f[x]
        for x in f:
                tmp = h[x] + c[i]
                g = gcd(x, a[i])
                h[g] = min(h[g], tmp) if g in h else tmp
        f = h
        f[a[i]] = min(f[a[i]], c[i]) if a[i] in f else c[i]
if 1 in f:
        print(f[1])
else:
        print("-1")
