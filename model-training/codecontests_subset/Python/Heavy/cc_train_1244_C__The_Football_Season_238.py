import math


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


def exgcd(a, b, X, Y):
    if a == 0 and b == 0:
        return -1
    if b == 0:
        X[0] = 1
        Y[0] = 0
        return a
    d = exgcd(b, a % b, Y, X)
    Y[0] = Y[0] - a // b * X[0]
    return d

def fceil(x, y):
    return (x + y - 1) // y

def main():
    n, p, w, d = map(int, input().split());
    x = [0]
    y = [0]
    G = gcd(w, d)
    if p % G != 0:
        print(-1)
        return
    if p % w == 0:
        x[0] = p // w
        if x[0] <= n:
            print(x[0], 0, n - x[0])
            return
    if p % d == 0:
        y[0] = p // d
        if y[0] <= n:
            print(0, y[0], n - y[0])
            return
    exgcd(w, d, x, y)
    x[0] = x[0] * p // G
    y[0] = y[0] * p // G
    if x[0] < 0:
        t = fceil(abs(x[0]), d)
        x[0] = x[0] + d * t
        y[0] = y[0] - w * t
    if y[0] < 0:
        t = fceil(abs(y[0]), w)
        x[0] = x[0] - d * t
        y[0] = y[0] + w * t
    if x[0] < 0 or y[0] < 0:
        print(-1)
        return
    t = y[0] // w
    x[0] = x[0] + d * t
    y[0] = y[0] - w * t
    if x[0] + y[0] > n:
        print(-1)
        return
    z = n - x[0] - y[0]
    print(x[0], y[0], z)


main()