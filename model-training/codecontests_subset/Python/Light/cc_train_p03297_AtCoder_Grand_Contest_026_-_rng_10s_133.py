def gcd(a, b):
    while b: a, b = b, a % b
    return a

T = int(input())
for _ in range(T):
    A, B, C, D = map(int, input().split())
    if D < B or A < B:
        print("No")
        continue
    x = A - (A-C+B-1) // B * B
    g = gcd(B, D)
    l = (C - x) % g
    if C - B + g - l >= 0:
        print("Yes")
    else:
        print("No")
