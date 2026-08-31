import io
import sys
import math

def inverse(a, m):
    u = 0
    v = 1
    while a != 0:
        t = m // a
        m -= t * a
        a, m = m, a
        u -= t * v
        u, v = v, u
    assert m == 1
    return u

def main():
    with sys.stdin as f:
        n, p, w, d = map(int, f.readline().split())
        g = math.gcd(w, d)
        if p % g:
            print(-1)
            return
        W = w // g
        D = d // g
        x = inverse(W, D)
        y = (1 - W * x) // D
        assert W * x + D * y == 1
        m = p // g
        x *= m
        y *= m
        ub = min(x // D, (n - x - y) // (W - D))
        lb = (-y + W - 1) // W
        if lb > ub:
            print(-1)
            return
        X = x - lb * D
        Y = y + lb * W
        assert X >= 0 and Y >= 0 and X * w + Y * d == p and X + Y <= n
        print(X, Y, n - X - Y)
main()

