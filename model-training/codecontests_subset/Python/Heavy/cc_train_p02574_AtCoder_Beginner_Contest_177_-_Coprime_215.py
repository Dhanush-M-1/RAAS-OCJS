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
    B = dict()
    for a in A:
        if a in B:
            B[a] += 1
        else:
            B[a] = 1

    for i in range(2, M + 1):
        cnt = 0
        for j in range(i, M, i):
            if j in B:
                cnt += B[j]
        if cnt > 1:
            return "setwise coprime"

    return "pairwise coprime"

print(solve())
