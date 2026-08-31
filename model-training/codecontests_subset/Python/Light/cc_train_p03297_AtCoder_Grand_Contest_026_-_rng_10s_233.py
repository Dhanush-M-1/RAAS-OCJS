#!/usr/bin/env python3
import fractions
def solve(a, b, c, d):
    if a < b:
        return False
    if d < b:
        return False
    if b <= c:
        return True
    assert c < b <= min(a, d)
    g = fractions.gcd(b, d)
    return b - g + a % g <= c

t = int(input())
for _ in range(t):
    a, b, c, d = map(int, input().split())
    ans = solve(a, b, c, d)
    print(['No', 'Yes'][ans])
