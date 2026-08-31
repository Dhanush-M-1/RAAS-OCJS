from fractions import gcd
t = int(input())
for _ in range(t):
    a, b, c, d = map(int, input().split())
    if a < b or d < b:
        print("No")
        continue
    if c >= b-1:
        print("Yes")
        continue
    g = gcd(b, d)
    print("Yes" if b + a%g - g <= c else "No")