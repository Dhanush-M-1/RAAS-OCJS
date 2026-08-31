def gcd_(a, b):
    if a == 0:
        return b, 0, 1
    if b == 0:
        return a, 1, 0
    if a > b:
        vals = gcd_(a % b, b)
        k = a // b
        return vals[0], vals[1], vals[2] - k * vals[1]
    vals = gcd_(a, b % a)
    k = b // a
    return vals[0], vals[1] - k * vals[2], vals[2]


def sol_diof(a, b, c):
    gcd1, x, y = gcd_(a, b)
    k = c // gcd1
    if k * gcd1 != c:
        return -1, -1
    x *= k
    y *= k
    b0 = b // gcd1
    x = x + (-x + b0 - 1) // b0 * b0
    y = (c - a * x) // b
    return x, y


n, p, w, d = map(int, input().split())
a1, a2 = sol_diof(w, d, p)
a3, a4 = sol_diof(d, w, p)
if a1 == -1 or a2 < 0 or a4 < 0 or min(a1 + a2, a3 + a4) > n:
    print(-1)
else:
    if a3 + a4 < a1 + a2:
        a1, a2 = a4, a3
    print(a1, a2, n - a1 - a2)
