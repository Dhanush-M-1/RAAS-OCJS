def mp():
    return map(int, input().split())

def f(a, b):
    res = 0
    while b > a:
        b //= 2
        res += 1
    if b != a:
        res = -1
    return res

n, k = mp()
a = sorted(list(mp()))
m = max(a) + 1
b = [0] * m
c = [0] * m
for i in a:
    x = i
    cnt = 0
    while x > 0:
        if c[x] < k:
            b[x] += cnt
            c[x] += 1
        x //= 2
        cnt += 1
    if c[0] < k:
        b[0] += cnt
        c[0] += 1
ans = b[0]
for i in range(1, m):
    if c[i] == k:
        ans = min(ans, b[i])

print(ans)