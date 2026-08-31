import fractions

T = int(input())
for i in range(T):
    A, B, C, D = map(int, input().split())
    if A < B:
        print('No')
        continue
    if B > D:
        print('No')
        continue
    if C >= B - 1:
        print('Yes')
        continue
    A = A % B
    D = D % B
    BD = fractions.gcd(B, D)
    A_max = A + BD * ((B - 1 - A) // BD)
    if A_max > C:
        print('No')
    else:
        print('Yes')
