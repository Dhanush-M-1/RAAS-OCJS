def exgcd(a, b, x, y):
    if b == 0:
        x[0] = 1
        y[0] = 0
    else:
        exgcd(b, a % b, y, x)
        y[0] -= (a // b) * x[0]


def gcd(a, b):
    while b != 0:
        temp = b
        b = a % b
        a = temp
    return a


n, p, w, d = map(int, input().split())
if p == 0:
    print('0 0', end=" ")
    print(n)
    exit()
minn = min(d, w)
maxn = max(d, w)
if p > maxn * n or p < minn:
    print(-1)
else:
    g = gcd(maxn, minn)
    if p % g != 0:
        print(-1)
        exit()
    x = [0]
    y = [0]
    a = w
    b = d
    a //= g
    b //= g
    c = p // g
    exgcd(b, a, y, x)
    y[0] = y[0] * c % a
    if y[0] < 0:
        y[0] += a
    x[0] = (p - y[0] * d) // w
    if y[0] + x[0] > n:
        print(-1)
    else:
        print('%d %d %d' %(x[0], y[0], n - x[0] - y[0]))


