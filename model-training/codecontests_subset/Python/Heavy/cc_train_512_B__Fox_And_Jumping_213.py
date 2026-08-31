def gcd(x, y):
        if y == 0:
                return x
        return gcd(y, x % y)

n = int(input())
a = [int(x) for x in input().split()]
c = [int(x) for x in input().split()]
d = sorted(c)
for i in range(n):
        for j in range(i,n):
                if d[i] == c[j]:
                        c[i], c[j] = c[j], c[i]
                        a[i], a[j] = a[j], a[i]
f = {}
for i in range(n):
        ai = a[i]
        ci = c[i]
        h = {}
        for x in f:
                h[x] = f[x]
        for x in f:
                tmp = h[x] + ci
                g = gcd(x, ai)
                if g in h:
                        h[g] = min(h[g], tmp)
                else:
                        h[g] = tmp
        f = h
        if ai in f:
                f[ai] = min(f[ai], ci)
        else:
                f[ai] = ci
if 1 in f:
        print(f[1])
        exit()

print("-1")