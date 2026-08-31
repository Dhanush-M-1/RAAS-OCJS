def gcd(a, b):
    return a if b == 0 else gcd(b, a % b)

def solve(a, b, c, d):
    if a < b or d < b:
        return False
    if b < c:
        return True

    g = gcd(b, d)
    return (b + a % g - g) <= c

T, *L = map(int, open(0).read().split())

print("\n".join("Yes" if solve(*t) else "No" for t in  zip(*[iter(L)] * 4)))
