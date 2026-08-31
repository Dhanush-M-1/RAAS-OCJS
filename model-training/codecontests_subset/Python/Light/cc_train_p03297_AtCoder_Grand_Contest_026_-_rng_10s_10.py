# 解説AC
from fractions import gcd
def judge(A,B,C,D):
    if A < B: return False
    if D < B: return False
    if C >= B: return True
    
    g = gcd(B, D)

    return False if ((B - g + (A % g)) > C) else True

T = int(input())
for _ in range(T):
    A,B,C,D = map(int, input().split())
    if judge(A,B,C,D): print('Yes')
    else: print('No')