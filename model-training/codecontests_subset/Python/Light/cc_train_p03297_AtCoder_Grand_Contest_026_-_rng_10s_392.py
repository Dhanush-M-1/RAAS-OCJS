def gcd(a, b):
    return a if b == 0 else gcd(b, a % b)

def solve(a, b, c, d):
    if a < b or d < b:
        return False
    if b < c:
        return True

    g = gcd(b, d)
    return (b + a % g - g) <= c

t = int(input())
for i in range(t):
    a, b, c, d = map(int, input().split())
    if solve(a, b, c, d):
        print("Yes")
    else:
        print("No")
