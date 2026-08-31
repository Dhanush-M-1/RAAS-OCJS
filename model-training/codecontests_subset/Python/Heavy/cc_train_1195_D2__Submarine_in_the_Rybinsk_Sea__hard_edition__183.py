n = int(input())
a = input().split()
b = {}
c = {}
for x in a:
    y = len(x)
    z = int(x)
    b[y] = b.get(y, 0) + 1
    c[z] = c.get(z, 0) + 1
M = 998244353
p = [1] * 30
for i in range(1, len(p)):
    p[i] = p[i - 1] * 10 % M
ans = 0
for key, val in c.items():
    w = 0
    while key > 0:
        d = key % 10
        key //= 10
        z = 0
        for x, y in b.items():
            z += y * (p[min(w, x)] + p[min(w + 1, x)])
        ans += val * d * p[w] * z % M
        w += 1
print(ans % M)
