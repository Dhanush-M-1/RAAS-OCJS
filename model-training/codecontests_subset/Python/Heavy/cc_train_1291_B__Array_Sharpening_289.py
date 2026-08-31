import sys
from math import log2,floor,ceil,sqrt
# import bisect
# from collections import deque

Ri = lambda : [int(x) for x in sys.stdin.readline().split()]
ri = lambda : sys.stdin.readline().strip()
 
def input(): return sys.stdin.readline().strip()
def list2d(a, b, c): return [[c] * b for i in range(a)]
def list3d(a, b, c, d): return [[[d] * c for j in range(b)] for i in range(a)]
def list4d(a, b, c, d, e): return [[[[e] * d for j in range(c)] for j in range(b)] for i in range(a)]
def ceil(x, y=1): return int(-(-x // y))
def INT(): return int(input())
def MAP(): return map(int, input().split())
def LIST(N=None): return list(MAP()) if N is None else [INT() for i in range(N)]
def Yes(): print('Yes')
def No(): print('No')
def YES(): print('YES')
def NO(): print('NO')
INF = 10 ** 18
MOD = 10**9+7

for _ in range(int(ri())):
    n = int(ri())
    arr = Ri()
    flag = True
    # inflag = True
    # i = 0
    # for i in range(1,len(arr)):
    #     if arr[i] == arr[i-1]:
    #         inflag = False
    #         break
    # if inflag:
    #     for i in range(1,len(arr)):
    #         if arr[i] < arr[i-1]:
    #             break
    #     for i in range(i+1,len(arr)):
    #         if arr[i] > arr[i-1]:
    #             inflag = False
    #             break
    # if inflag:
    #     Yes()
    # else:
    flag = False
    flag1=   [ False]*n
    flag2 = [False]*n
    for i in range(n-1,-1,-1):
        if n-i-1 > arr[i]:
            break
        else:
            flag1[i]   = True
    for i in range(len(arr)):
        if arr[i]  < i:
            break
        else:
            flag2[i]   = True
    for i in range(n):
        if flag1[i] and flag2[i]:
            flag = True
            break
    if flag:
        Yes()
    else:
        No()

        


