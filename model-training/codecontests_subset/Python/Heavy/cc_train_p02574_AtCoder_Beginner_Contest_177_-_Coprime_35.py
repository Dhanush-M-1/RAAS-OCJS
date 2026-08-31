from collections import defaultdict
from math import gcd

def solve():
    N = int(input())
    A = list(map(int, input().split()))
    all = 0
    for a in A:
        all = gcd(all, a)
    if all != 1:
        return "not coprime"

    M = 10 ** 6
    B = defaultdict(int)
    for a in A:
        B[a] += 1

    for i in range(2, M + 1):
        cnt = 0
        for j in range(i, M, i):
            cnt += B[j]
        if cnt > 1:
            return "setwise coprime"

    return "pairwise coprime"

print(solve())
