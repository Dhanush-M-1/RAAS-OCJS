import typing
import sys
import math
import collections
import bisect
import itertools
import heapq
import decimal
import copy
import operator

# sys.setrecursionlimit(10000001)
INF = 10 ** 20
MOD = 10 ** 9 + 7
# MOD = 998244353
# buffer.readline()


def ni(): return int(sys.stdin.readline())
def ns(): return map(int, sys.stdin.readline().split())
def na(): return list(map(int, sys.stdin.readline().split()))
def na1(): return list(map(lambda x: int(x)-1, sys.stdin.readline().split()))


# ===CODE===
def main():
    t = ni()
    alpha = [chr(i) for i in range(97, 97+26)]
    for ti in range(t):
        s = list(input())
        n = len(s)
        ans = 0
        for i in range(n):
            flg1 = False
            flg2 = False

            if i > 0:
                if s[i] == s[i-1]:
                    flg1 = True
            if i > 1:
                if s[i] == s[i-2]:
                    flg2 = True

            if flg1 or flg2:
                ans += 1
                bad = set()
                for j in range(max(0, i-2), min(n, i+3)):
                    if i == j:
                        continue
                    bad.add(s[j])

                for char in alpha:
                    if char not in bad:
                        s[i] = char
                        break
        print(ans)


if __name__ == '__main__':
    main()
