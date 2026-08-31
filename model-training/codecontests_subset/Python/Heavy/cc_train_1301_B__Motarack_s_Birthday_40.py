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
    n = I()
    a = LI()
    maxv = 0
    minv = 10**19
    missing_count = 0

    if n == 2:
        if a[0] == -1 and a[1] != -1:
            print(0, a[1])
        elif a[0] != -1 and a[1] == -1:
            print(0, a[0])
        else:
            print(0, 0)
        return

    for i in range(1, n-1):
        if a[i-1] == -1 and a[i] != -1:
            maxv = max(maxv, a[i])
            minv = min(minv, a[i])
        if a[i-1] != -1 and a[i] == -1:
            maxv = max(maxv, a[i-1])
            minv = min(minv, a[i-1])
        if a[i] != -1 and a[i+1] == -1:
            maxv = max(maxv, a[i])
            minv = min(minv, a[i])
        if a[i] == -1 and a[i+1] != -1:
            maxv = max(maxv, a[i+1])
            minv = min(minv, a[i+1])

        if a[i] == -1:
            missing_count += 1

    if a[0] == -1:
        missing_count += 1

    if a[-1] == -1:
        missing_count += 1

    if missing_count == n:
        print(0, 0)
        return

    # print(minv, maxv)
    k = (minv + maxv) // 2
    a = [i if i != -1 else k for i in a]
    diff = 0

    for i in range(n-1):
        diff = max(diff, abs(a[i] - a[i+1]))

    if missing_count == 0:
        print(diff, 0)
    else:
        print(diff, k)


def main():
    T = I()

    for i in range(T):
        solve(T)


if __name__ == '__main__':
    main()
