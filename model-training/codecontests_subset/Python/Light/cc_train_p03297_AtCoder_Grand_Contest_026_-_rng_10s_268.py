T = int(input())

def gcd(a, b):
    if a < b:
        a, b = b, a
    while b:
        a, b = b, a % b
    return a

def solve(A, B, C, D):
    if A < B:
        return False
    if D < B:
        return False
    if C >= B:
        return True
    s = A % B
    d = D % B
    n = B - C
    if d == 0:
        return s <= C
    else:
        g = gcd(d, B)
        n = (B - 1 - s) // g
        m = s + n * g
        return m <= C

ABCD = [[int(_) for _ in input().split()] for i in range(T)]

for A, B, C, D in ABCD:
    if solve(A, B, C, D):
        print("Yes")
    else:
        print("No")
