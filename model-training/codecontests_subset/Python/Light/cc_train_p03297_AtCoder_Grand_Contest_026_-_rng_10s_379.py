import fractions


def solve(a, b, c, d):
    if a < b or d < b:
        return False
    if b <= c + 1:
        return True
    gcd_bd = fractions.gcd(b, d)
    cc = c - a % gcd_bd
    b //= gcd_bd
    cc //= gcd_bd
    if b <= cc + 1:
        return True
    return False


t = int(input())
buf = []
for _ in range(t):
    a, b, c, d = map(int, input().split())
    buf.append('Yes' if solve(a, b, c, d) else 'No')
print('\n'.join(map(str, buf)))
