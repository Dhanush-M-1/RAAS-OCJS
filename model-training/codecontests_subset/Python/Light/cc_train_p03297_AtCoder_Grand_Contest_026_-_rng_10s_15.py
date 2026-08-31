from fractions import gcd
t = int(input())
for _ in range(t):
    a, b, c, d = map(int, input().split())
    if b > d:
        print("No")
    elif a < b:
        print("No")
    elif c >= b:
        print("Yes")
    else:
        if c < b-gcd(b, d)+ a%gcd(b, d):
            print("No")
        else:
            print("Yes")
