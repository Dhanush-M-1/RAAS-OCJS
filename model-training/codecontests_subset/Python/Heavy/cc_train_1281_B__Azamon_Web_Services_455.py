#from statistics import median
#import collections
#aa = collections.Counter(a) # list to list || .most_common(2)で最大の2個とりだせるお a[0][0]
# from math import gcd
# from itertools import combinations,permutations,accumulate, product # (string,3) 3回
# #from collections import deque
# from collections import deque,defaultdict,Counter
# import decimal
# import re
# import math
# import bisect
# import heapq
#
#
#
# pythonで無理なときは、pypyでやると正解するかも！！
#
#
# my_round_int = lambda x:np.round((x*2 + 1)//2)
# 四捨五入g
#
# インデックス系
# int min_y = max(0, i - 2), max_y = min(h - 1, i + 2);
# int min_x = max(0, j - 2), max_x = min(w - 1, j + 2);
#
#
# import sys
# sys.setrecursionlimit(10000000)
mod = 10**9 + 7
#mod = 9982443453
#mod = 998244353
INF = float('inf')
# from sys import stdin
# readline = stdin.readline
def readInts():
  return list(map(int,input().split()))
def readTuples():
    return tuple(map(int,input().split()))
def I():
    return int(input())
q = I()
for _ in range(q):
    S,T = input().split()
    D = sorted(S)
    S = list(S)
    ln = len(S)
    #print('!',*S)
    #print('?',*D)
    for i in range(ln):
        if S[i] > D[i]:
            pos = ln - 1
            while i < pos:
                #print('Searching...',S[pos],D[i])
                if S[pos] == D[i]:
                    break
                pos -= 1
            S[i],S[pos] = S[pos],S[i]
            break
    S = ''.join(S)
    if S < T:
        print(S)
    else:
        print('---')
