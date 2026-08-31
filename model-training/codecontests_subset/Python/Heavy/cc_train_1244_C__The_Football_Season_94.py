from math import *


def ri():
    return int(input())


def rli():
    return list(map(int, input().split()))


def gcd(a, b):
    if a == 0:
        return b, 0, 1
    d, x1, y1 = gcd(b % a, a)
    x = y1 - (b // a) * x1
    y = x1
    return d, x, y


def find_any_solution(a, b, c):
    g, x, y = gcd(abs(a), abs(b))
    if c % g != 0:
        return False, 0, 0, 1
    x *= c // g
    y *= c // g
    return True, x, y, g


def shift_solution(x, y, a, b, cnt):
    return x + cnt * b, y - cnt * a


def ceildiv(a, b):
    return (a + b - 1) // b


def solve():
    n, p, w, d = rli()
    if p == 0:
        print(0, 0, n)
        return

    found, x, y, g = find_any_solution(w, d, p)
    if found:
        w //= g
        d //= g
        if y < 0:
            x, y = shift_solution(x, y, w, d, -ceildiv(-y, w))
        x, y = shift_solution(x, y, w, d, y // w)
        if x < 0 or x + y > n:
            print(-1)
        else:
            print(x, y, n - x - y)
    else:
        print(-1)


if __name__ == "__main__":
    solve()
