import os
import sys
from collections import defaultdict

if os.getenv("LOCAL"):
    sys.stdin = open("_in.txt", "r")

sys.setrecursionlimit(10 ** 9)
INF = float("inf")
IINF = 10 ** 18
MOD = 10 ** 9 + 7
# MOD = 998244353


# 解説
S = sys.stdin.buffer.readline().decode().rstrip()
N = len(S)

cs = [0] * N
h = 0
for i, c in enumerate(S):
    h ^= 1 << (ord(c) - ord('a'))
    cs[i] = h


def dump(h):
    import numpy as np
    print(np.binary_repr(h, 26))


def dumpdp(dp):
    for k in dp.keys():
        if dp[k] < INF:
            dump(k)
            print(dp[k])
    print()


# dp[h]: それまでのハッシュが h である位置以前の分割方法の最小値
dp = defaultdict(lambda: INF)
dp[0] = 0
dp[cs[0]] = 1
for i in range(1, N):
    # print(S[i - 1])
    # dumpdp(dp)

    h = cs[i]
    if h == 0:
        continue
    d = 1
    while d < (1 << 26):
        # i から h^d の位置までまとめて 1 つ切り出せる
        dp[h] = min(dp[h], dp[h ^ d] + 1)
        d <<= 1

if cs[-1] == 0:
    print(1)
else:
    print(dp[cs[-1]])
