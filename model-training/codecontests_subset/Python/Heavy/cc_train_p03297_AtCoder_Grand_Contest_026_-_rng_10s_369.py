from fractions import gcd
import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    A, B, C, D = map(int, input().split())
    if D < B or A < B:
        ans = 'No'
    elif C >= B:
        ans = 'Yes'
    else:
        g = gcd(B, D)
        lb, ub = -10**18, 10**18
        while ub - lb > 1:
            m = (lb + ub) // 2
            if A - g * m > C:
                lb = m
            else:
                ub = m
        if A - g * lb < B:
            ans = 'No'
        else:
            ans = 'Yes'
    print(ans)
