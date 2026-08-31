import sys

sys.setrecursionlimit(100000)

def gcd(a, b):
    r = a % b
    if r == 0:
        return b
    else:
        return gcd(b, r)

T = int(input())
for i in range(T):
    a, b, c, d = list(map(int, input().split()))

    if a < b:
        print("No")
        continue

    if b > d:
        print("No")
        continue

    if c >= b: # d >= b
        print("Yes")
        continue

    diff = d % b
    if diff == 0:
        if a % b <= c:
            print("Yes")
            continue
        else:
            print("No")
            continue

    g = gcd(b, diff)

    init_mod = c % b

    base_mod = init_mod % g
    if b + base_mod - g > c:
        print("No")
    else:
        print("Yes")
