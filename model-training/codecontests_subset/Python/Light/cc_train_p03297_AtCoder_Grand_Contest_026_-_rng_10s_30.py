import sys
import math
from collections import defaultdict
from bisect import bisect_left, bisect_right

sys.setrecursionlimit(10**7)
def input():
    return sys.stdin.readline()[:-1]

mod = 10**9 + 7

def I(): return int(input())
def LI(): return list(map(int, input().split()))
def LIR(row,col):
    if row <= 0:
        return [[] for _ in range(col)]
    elif col == 1:
        return [I() for _ in range(row)]
    else:
        read_all = [LI() for _ in range(row)]
        return map(list, zip(*read_all))

#################

import fractions

T = I()
A,B,C,D = LIR(T,4)

for i in range(T):
    if A[i] < B[i]:
        print('No')
        continue

    g = fractions.gcd(B[i],D[i])

    # 0~B-1に突入する際の最小値と最大値を求める
    x = (A[i]%B[i])//g
    min_ = (A[i]%B[i]) - x*g

    x = (B[i]-1-(A[i]%B[i])) // g
    max_ = (A[i]%B[i]) + x*g

    if max_ > C[i] or min_ < B[i]-D[i]:
        print('No')
    else:
        print('Yes')