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

    g = gcd(-b, d)
    if g == 1 or b - c > g:
        print("No")
    else:
        m = a - ((a - c) // g) * g
        if c < m < b:
            print("No")
        else:
            print("Yes")
