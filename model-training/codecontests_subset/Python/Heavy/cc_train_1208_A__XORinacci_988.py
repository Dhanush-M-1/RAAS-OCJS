import sys
sys.setrecursionlimit(1000000)
from math import factorial, ceil, floor
from bisect import bisect_right as bsr
from operator import itemgetter as ig
from collections import defaultdict as dd
from collections import deque, Counter as cnt

# お約束
args = None
INF = float("inf")
MOD = int(1e9 + 7)
def input(*ps):
    if type(ps[0]) is list:
        return [input(*ps[0][:-1]) for _ in range(ps[0][-1])]
    elif len(ps) == 1:
        return ps[0](next(args))
    else:
        return [p(next(args)) for p in ps]
def nlist(n, v):
    if not n: return v.copy()
    return [nlist(n[1:], v) for _ in range(n[0])]

# エントリーポイント
def main():
    N = input(int)
    for _ in range(N):
        A, B, C = input([int, 3])
        if C == 0:
            print(A)
            continue
        if C == 1:
            print(B)
            continue
        ans = 0
        mask = 1 << 32
        while mask:
            a, b = A & mask, B & mask
            ans += ([a, b, a ^ b][C % 3])
            mask >>= 1
        print(ans)

if __name__ == '__main__':
    args = iter(sys.stdin.read().split())
    main()
