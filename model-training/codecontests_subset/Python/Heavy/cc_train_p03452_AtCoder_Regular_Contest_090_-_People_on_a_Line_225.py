import sys
from collections import deque
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline
N, M = [int(x) for x in input().strip().split()]
L = [deque([]) for _ in range(N)]

for m in range(M):
    l, r, d = [int(x) for x in input().strip().split()]
    L[l-1].append((r, d))
    L[r-1].append((l, -d))

D = [0] * N
F = [False] * N

def dfs(n, d):
    # print('n = {}, d = {}'.format(n, d))
    if F[n-1]:
        if D[n-1] == d:
            # print('  already passed')
            return True
        else:
            # print('  already passed, but wrong')
            return False
    F[n-1] = True
    D[n-1] = d
    for nn, d_ in L[n-1]:
        # print('  dfs({}, {})'.format(nn, d+d_))
        if not dfs(nn, d+d_):
            return False
    else:
        return True

for n in range(1, N+1):
    if not dfs(n, D[n-1]):
        print('No')
        exit()
else:
    print('Yes')