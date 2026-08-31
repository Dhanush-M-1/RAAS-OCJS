from fractions import gcd

def solve(a, b, c, d):
    if a < b or d < b:
        return False

    if c >= b - 1:
        return True

    g = gcd(b, d)
    return (b + a % g - g) <= c

T, *L = map(int, open(0).read().split())

for t in zip(*[iter(L)] * 4):
    if solve(*t):
        print("Yes")
    else:
        print("No")
