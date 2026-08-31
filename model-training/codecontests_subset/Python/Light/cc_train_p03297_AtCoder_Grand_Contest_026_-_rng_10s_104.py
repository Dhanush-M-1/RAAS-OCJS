from fractions import gcd

t = int(input())
for _ in range(t):
    a, b, c, d = list(map(int, input().split()))
    if b > a:
        print("No")
    elif b > d:
        print("No")
    elif c >= b:
        print("Yes")
    else:
        g = gcd(b, d)
        if b - g + (a % g) > c:
            print("No")
        else:
            print("Yes")
