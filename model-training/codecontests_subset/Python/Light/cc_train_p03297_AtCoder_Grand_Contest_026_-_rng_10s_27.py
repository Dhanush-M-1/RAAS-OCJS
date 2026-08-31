from math import gcd

t = int(input())
for _ in range(t):
    a, b, c, d = map(int, input().split())
    if b > d or b > a:
        print("No")
    else:
        tmp = gcd(b, d)
        rem = a % tmp
        min_c = (c - rem) // tmp
        if min_c + 1 >= b // tmp:
            print("Yes")
        else:
            print("No")