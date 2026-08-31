from heapq import heappush, heappop, heapify
from collections import deque, defaultdict, Counter
import itertools
from itertools import permutations, combinations, accumulate
import sys
import bisect
import string
import math
import time


def I(): return int(input())


def MI(): return map(int, input().split())


def S(): return input()


def MS(): return map(str, input().split())


def LI(): return [int(i) for i in input().split()]


def LI_(): return [int(i)-1 for i in input().split()]


def StoI(): return [ord(i)-97 for i in input()]


def ItoS(nn): return chr(nn+97)


def input(): return sys.stdin.readline().rstrip()


def show(*inp, end='\n'):
    if show_flg:
        print(*inp, end=end)


YN = {False: 'No', True: 'Yes'}
MOD = 10**9+7
inf = float('inf')
IINF = 10**10
l_alp = string.ascii_lowercase
u_alp = string.ascii_uppercase
nums = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10']

show_flg = False
# show_flg = True


def solve(T):
    n, m = MI()
    s = S()
    p = LI()
    ans = [0 for i in range(26)]

    dic = {}
    for k in p:
        if k not in dic:
            dic[k] = 0
        dic[k] += 1

    dp = [0] * (n + 1)
    keys = list(sorted(dic.keys(), reverse=True))
    cur = 0
    v = keys[cur]
    dp[n] = 1
    # print(dic)
    # print(v)
    last = False
    for i in range(n, 0, -1):
        if i > v:
            dp[i-1] = dp[i]
        elif cur + 1 < len(keys):
            # print('pop', v, i)
            dp[i-1] = dp[i] + dic[v]
            cur += 1
            v = keys[cur]
        elif last is False:
            last = True
            dp[i-1] = dp[i] + dic[v]
        else:
            dp[i-1] = dp[i]

    # print(*dp)

    for i in range(n):
        ch = ord(s[i]) - ord('a')
        ans[ch] += dp[i]

    print(*ans)

    # c = len(p) + 1
    # ch = ord(s[0]) - ord('a')
    # ans[ch] = c
    # for i in range(1, n):
    #     if dp[i-1] != dp[i]:
    #         c -= dp[i-1] - dp[i]
    #     ch = ord(s[i]) - ord('a')
    #     ans[ch] += c
    #     print(i, c, ans)
    #     # print(i, dp[n-i-1], ans)

    # print(*[ch for ch in s])
    # print(*dp)
    # print(*ans)


def main():
    T = I()

    for i in range(T):
        solve(T)


if __name__ == '__main__':
    main()
