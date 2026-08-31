from math import gcd

t = int(input())
queries = [tuple(int(x) for x in input().split()) for _ in range(t)]
for a, b, c, d in queries:
    if a < b:
        print("No")
        continue
    if b > d:
        print("No")
        continue
    if b - c <= 1:
        print("Yes")
        continue

    g = gcd(b, d)
    m = a + ((b - a) // g) * g
    if m >= b:
        m -= g
    if c < m:
        print("No")
    else:
        print("Yes")
