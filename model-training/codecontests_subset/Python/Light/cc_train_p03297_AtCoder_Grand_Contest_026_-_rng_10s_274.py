import fractions

T = int(input())

def solve(A, B, C, D):
    left = A
    if A < B:
        print('No')
        return
    if D < B:
        print('No')
        return
    if C >= B:
        print('Yes')
        return
    g = fractions.gcd(B, D)
    max_mod_b = B - g + (A % g)
    if max_mod_b > C:
        print('No')
    else:
        print('Yes')

for _ in range(T):
    A, B, C, D = map(int, input().split())
    solve(A, B, C, D)
