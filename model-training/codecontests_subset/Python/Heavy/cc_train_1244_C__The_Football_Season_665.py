INF = int(1e20)
def extended_gcd(a, b):
    s, old_s = 0, 1
    r, old_r = b, a
    while r:
        q = old_r // r
        old_r, r = r, old_r - q * r
        old_s, s = s, old_s - q * s
    return old_r, old_s, (old_r - old_s * a) // b if b else 0

def f(y, w):
    lo, hi = -INF, INF
    while lo + 1 < hi:
        mid = (lo + hi) // 2
        if (y - mid * w >= 0): lo = mid
        else: hi = mid
    return lo

n, p, w, d = map(int, input().split())
g, x, y = extended_gcd(w, d)
if p % g != 0:
    print(-1)
    exit(0)

p //= g
w //= g
d //= g

x *= p
y *= p

k = f(y, w)
x += k * d
y -= k * w

z = n - (x + y)
if x >= 0 and y >= 0 and z >= 0 and (x * w + y * d == p):
    print(x, y, z)
else:
    print(-1)