n, p, w, d = map(int, input().split())

def gcd(a, b):
    if a == 0:
        return (b, 0, 1)
    g, x1, y1 = gcd(b % a, a)
    x = y1 - (b // a) * x1
    y = x1
    return [g, x, y]

def solve(a, b, c):
    g, x, y = gcd(a, b)
    if c % g != 0:
        return [-1, -1]
    x *= c // g
    y *= c // g

    l = -max(x, y)
    r = max(x, y)

    while l <= r:
        mid = (l + r) // 2

        x1 = x + mid * (b // g)
        y1 = y - mid * (a // g)

        if x1 >= 0 and y1 >= 0 and x1 + y1 <= n:
            return [x1, y1]

        if (x1 < 0 if a < b else y1 < 0):
            r = mid-1
        else:
            l = mid+1

    return [-1, -1]

x, y = solve(w, d, p);

if x >= 0:
    print(x, y, n - (x+y))
else:
    print(-1)