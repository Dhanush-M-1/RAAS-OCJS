def gcd_all(A):
    from math import gcd
    g = 0
    for a in A: g = gcd(g, a)
    return g

def is_pairwise():
    C = [0] * (10**6 + 1)
    max_a = 0
    for a in A:
        C[a] += 1
        max_a = max(max_a, a)
    if sum(C[2::2]) > 1: return False
    for i in range(3, max_a + 1, 2):
        if sum(C[i::i]) > 1: return False
    return True

def solve():
    if is_pairwise(): return 0
    if gcd_all(A) == 1: return 1
    return 2

n = int(input())
A = [*map(int, input().split())]
print(['pairwise','setwise','not'][solve()], 'coprime')
