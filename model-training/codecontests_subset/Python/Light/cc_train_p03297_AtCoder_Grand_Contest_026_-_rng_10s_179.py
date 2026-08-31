import sys

def gcd(x, y):
    x, y = sorted([x, y])
    while y % x:
        y, x = x, y % x
    return x

t = int(sys.stdin.readline())
for _ in range(t):
    a, b, c, d = map(int, sys.stdin.readline().split())
    if a < b:
        print("No")
    elif d < b:
        print("No")
    elif c >= b:
        print("Yes")
    else:
        g = gcd(b, d)
        if b - g + (a % g) > c:
            print("No")
        else:
            print("Yes")