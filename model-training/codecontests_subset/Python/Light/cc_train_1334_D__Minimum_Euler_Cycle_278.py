def f(n, k):
    return n * k - k + n * k - k * k
def af(n, p):
    if p == n * (n - 1):
        return 1
    l = 0
    r = n + 1
    while r - l > 1:
        m = (l + r) // 2
        if f(n, m) <= p:
            l = m
        else:
            r = m
    if (p - f(n, l)) % 2 == 0:
        return r
    return (p - f(n, l) + 1) // 2 + r
t = int(input())
for i in range(t):
    n, l, r = map(int, input().split())
    z = []
    for j in range(l - 1, r):
        z.append(af(n, j))
    print(*z)
