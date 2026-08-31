import fractions as math


def read_ints():
    return [int(c) for c in input().split()]


def solve(a, b, c, d):
    if a < b:
        return False
    if d < b:
        return False
    if c >= b:
        return True
    e = a % b
    delta = d % b
    if delta == 0:
        return e <= c
    g = math.gcd(b, delta)
    maxv = b - g
    return maxv <= c


def main():
    n = int(input())
    for _ in range(n):
        print("Yes" if solve(*read_ints()) else "No")


if __name__ == '__main__':
    main()