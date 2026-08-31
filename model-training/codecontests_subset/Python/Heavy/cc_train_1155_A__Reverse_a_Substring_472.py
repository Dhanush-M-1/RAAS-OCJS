import sys
# gcd
# from fractions import gcd
# from math import ceil, floor
# from copy import deepcopy
# from itertools import accumulate
# from collections import Counter
input = sys.stdin.readline
def ii(): return int(input())
def mi(): return map(int, input().rstrip().split())
def lmi(): return list(map(int, input().rstrip().split()))
def li(): return list(input().rstrip())
# template


N = ii()
S = li()
sortS = sorted(S)
if S == sortS:
    print('NO')
else:
    print('YES')
    for i in range(N):
        if S[i] != sortS[i]:
            for j in range(i + 1, N):
                if S[j] < S[i]:
                    print(i + 1, j + 1)
                    exit()
