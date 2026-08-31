import os
import sys
from fractions import gcd

if os.getenv("LOCAL"):
    sys.stdin = open("_in.txt", "r")

sys.setrecursionlimit(2147483647)
INF = float("inf")
IINF = 10 ** 18
MOD = 10 ** 9 + 7

T = int(sys.stdin.readline())
ABCD = [list(map(int, sys.stdin.readline().split())) for _ in range(T)]


def solve(A, B, C, D):
    if B > D:
        return False
    if A < B:
        return False
    if C >= B:
        return True
    # C < B <= D
    # A から D を無限に足してったとき、mod B が C より大きくなったらだめ
    p = gcd(D, B)  # p ごとの値しか取らない
    if p < B - C:
        return False
    if (B - A - 1) % p < B - C - 1:
        return False
    return True


ans = []
for a, b, c, d in ABCD:
    ans.append('Yes' if solve(a, b, c, d) else 'No')
print(*ans, sep='\n')
