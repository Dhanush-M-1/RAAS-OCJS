import sys
import math
import collections
import bisect
import itertools
import decimal
import heapq


# sys.setrecursionlimit(10000001)
INF = 10 ** 20
MOD = 10 ** 9 + 7
# MOD = 998244353


def ni(): return int(sys.stdin.buffer.readline())
def ns(): return map(int, sys.stdin.buffer.readline().split())
def na(): return list(map(int, sys.stdin.buffer.readline().split()))
def na1(): return list(map(lambda x: int(x)-1, sys.stdin.buffer.readline().split()))
def flush(): return sys.stdout.flush()


def nicf(): return int(sys.stdin.readline())
def nscf(): return map(int, sys.stdin.readline().split())
def nacf(): return list(map(int, sys.stdin.readline().split()))
def na1cf(): return list(map(lambda x: int(x)-1, sys.stdin.readline().split()))


# ===CODE==
def solve():
    n, m = ns()
    ta = na()
    x = na()

    a = []
    mx = -1
    total = 0
    for i, ai in enumerate(ta):
        total += ai
        mx = max(mx, total)
        a.append([total, i])

    a.sort()
    aval = [a0 for a0, a1 in a]
    aidx = [a1 for a0, a1 in a]

    mnidx = [-1]*n
    for i in range(n-1, -1, -1):
        if i == n-1:
            mnidx[i] = aidx[i]
        else:
            mnidx[i] = min(mnidx[i+1], aidx[i])

    res = []
    for xi in x:
        if xi <= mx:
            idx = bisect.bisect_left(aval, xi)
            res.append(mnidx[idx])
            continue

        if total <= 0:
            res.append(-1)
            continue

        cycle = (xi-mx-1)//total+1
        txi = xi-cycle*total

        idx = bisect.bisect_left(aval, txi)
        res.append(cycle*n+mnidx[idx])
    print(*res)


def main():
    t = ni()
    for ti in range(t):
        solve()


if __name__ == '__main__':
    main()
