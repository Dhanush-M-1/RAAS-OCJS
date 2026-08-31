n, p, w, d = map(int, input().split())

if w * n < p:
    print(-1)
elif n == p and ((w != 1 and d != 1) and (w != n and d != n)):
    print(-1)
elif p == 0:
    print(0, 0, n)
elif p % w == 0 and p // w == n:
    print(n, 0, 0)
elif p % d == 0 and p // d == n:
    print(0, n, 0)
else:
    x = p // w
    while 1:
        y = (p - w*x) // d
        if x * w + y * d == p and x + y <= n:
            break
        if x + y < n and x >= 0 and (p - w*x) // d >= 0:
            x -= 1
        else:
            x = -2
            break
    if x != -2:
        z = 0
        if x + y < n:
            z = n - x - y
        print(x, y, z)
    else:
        print(-1)
