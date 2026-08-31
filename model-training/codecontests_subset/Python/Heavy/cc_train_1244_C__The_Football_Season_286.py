def gcd (a, b):
    if a == 0:
        return [b, 0, 1]
    cnt = gcd(b % a, a)
    x = cnt[2] - (b // a) * cnt[1]
    y = cnt[1]
    return [cnt[0], x, y]


def solve_equation(a, b, c):
    cnt = gcd(abs(a), abs(b))
    if c % cnt[0] != 0:
        return -1
    cnt[1] *= c // cnt[0]
    cnt[2] *= c // cnt[0]
    return cnt


n, p, w, d = map(int, input().split())
res = solve_equation(w, d, p)
if res == -1:
    print(-1)
    exit(0)

g = res[0]
x0 = res[1]
y0 = res[2]
k2 = (n * g - x0 * g - y0 * g) // (d - w)
if (n * g - x0 * g - y0 * g) % (d - w) != 0:
    k2 += 1
k1 = (-x0 * g) // d
if (x0 * g) % d != 0:
    k1 += 1

k = max(k1, k2)
x = (x0 + k * d // g)
y = (y0 - k * w // g)
if x < 0 or y < 0 or n - x - y < 0 or x * w + y * d != p:
    print(-1)
    exit(0)

print(x, y, n - x - y)
