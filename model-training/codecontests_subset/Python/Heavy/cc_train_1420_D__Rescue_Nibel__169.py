import sys
import math
import collections
import bisect
import itertools
import decimal
import copy
import heapq

# import numpy as np

# sys.setrecursionlimit(10 ** 6)
INF = 10 ** 20
# MOD = 10 ** 9 + 7
MOD = 998244353

ni = lambda: int(sys.stdin.buffer.readline())
ns = lambda: map(int, sys.stdin.buffer.readline().split())
na = lambda: list(map(int, sys.stdin.buffer.readline().split()))
na1 = lambda: list(map(lambda x: int(x) - 1, sys.stdin.buffer.readline().split()))
flush = lambda: sys.stdout.flush()


# ===CODE===
def main():
    # nCrの左項にはn以外も来るバージョン、1!～(n-1)!を保持
    def prepare(n, MOD):
        # 1! - n! の計算
        f = 1
        factorials = [1]  # 0!の分
        for m in range(1, n + 1):
            f *= m
            f %= MOD
            factorials.append(f)
        # n!^-1 の計算
        inv = pow(f, MOD - 2, MOD)
        # n!^-1 - 1!^-1 の計算
        invs = [1] * (n + 1)
        invs[n] = inv
        for m in range(n, 1, -1):
            inv *= m
            inv %= MOD
            invs[m - 1] = inv

        return factorials, invs

    n, k = ns()

    # 使い方
    facts, invs = prepare(n, MOD)

    items = [na() for _ in range(n)]
    items.sort()

    ans = 0
    hq = []
    for l, r in items:
        heapq.heappush(hq, r)

        while hq and hq[0] < l:
            heapq.heappop(hq)

        total = len(hq)
        if total >= k:
            ans += facts[total - 1] * invs[k - 1] * invs[(total - 1) - (k - 1)] % MOD
            ans %= MOD
    print(ans)


if __name__ == '__main__':
    main()
