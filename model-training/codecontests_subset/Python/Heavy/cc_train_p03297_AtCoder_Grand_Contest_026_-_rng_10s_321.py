import sys
input = sys.stdin.readline

from fractions import gcd

T = int(input())
ABCD = [[int(x) for x in input().split()] for _ in range(T)]

def F(A,B,C,D):
    if D<B:
        return False
    if A<B:
        return False
    g = gcd(D,B)
    # 個数 mod gは不変量。平行移動して、g=1に帰着する。
    diff = A%g
    A -= diff
    C -= diff
    C -= C%g
    A //= g; B //= g; C //= g; D //= g
    # 以下、(B,D) = 1. mod Dで任意の状態になる
    # C+1,...,C+Bの全部をとる。
    # C+1 >= Bが必要十分
    return C+1>=B

print('\n'.join('Yes' if F(a,b,c,d) else 'No' for a,b,c,d in ABCD))