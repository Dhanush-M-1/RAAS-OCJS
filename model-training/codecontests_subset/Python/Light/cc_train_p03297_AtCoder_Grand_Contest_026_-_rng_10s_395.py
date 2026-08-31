t = int(input())

def gcd(x, y):
    if x > y:
        x, y = y, x
    while x > 0:
        x, y = y%x, x
    return y

for _ in range(t):
    a,b,c,d = map(int, input().split())

    if b > a or b > d:
        print("No")
        continue
    if c >= b:
        print("Yes")
        continue

    a %= b
    g = gcd(b, d)
    if b-g+(a % g) > c:
        print("No")
    else:
        print("Yes")
