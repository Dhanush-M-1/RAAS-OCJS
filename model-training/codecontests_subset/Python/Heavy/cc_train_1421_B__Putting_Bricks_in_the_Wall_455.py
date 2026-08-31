
#import sys
# import math
# import bisect
# import collections
# import itertools
# #from sys import stdin,stdout
# from math import gcd,floor,sqrt,log
from collections import Counter as ctr
# from bisect import bisect_left as bl, bisect_right as br
# from itertools import permutations as pr, combinations as cb

#sys.setrecursionlimit(100000000)

#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$

inp    = lambda: int(input())
# strng  = lambda: input().strip()
# jn     = lambda  x,l: x.join(map(str,l))
strl   = lambda: list(input().strip())
# mul    = lambda: map(int,input().strip().split())
# mulf   = lambda: map(float,input().strip().split())
seq    = lambda: list(map(int,input().strip().split()))
#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$#$
# p_inf = float('inf')
# n_inf = float('-inf')
#To find mex 
# def mex(arr):
#     nList = set(arr)
#     mex = 0
#     while mex in nList:
#         mex += 1
#     return(mex)

def results(arr, n):
    a, b, c, d = arr[0][1], arr[1][0], arr[n-1][-2], arr[n-2][-1]
    cd = ctr([a, b, c, d])
    if(len(cd) == 1): # 4 0 0 4
        return([2, [[1, 2], [2, 1]]])
    else:
        if(cd['1'] == cd['0']): # 2 2
            if(a == b):
                return([0])
            elif(a == c):
                return([2, [[1, 2], [n - 1, n]]])
            else:
                return([2, [[1, 2], [n, n - 1]]])
        if(cd['0'] > cd['1']): # 3 1
            if(a != '0'):
                return([1, [[2, 1]]])
            elif(b != '0'):
                return([1, [[1, 2]]])
            elif(c != '0'):
                return([1, [[n - 1, n]]])
            else:
                return([1, [[n, n - 1]]])
        else: # 1 3
            if(a != '1'):
                return([1, [[2, 1]]])
            if(b != '1'):
                return([1, [[1, 2]]])
            if(c != '1'):
                return([1, [[n - 1, n]]])
            else:
                return([1, [[n, n - 1]]])

def main():
    t = inp()
    for _ in range(t):
        n = inp()
        a = []
        for _ in range(n):
            a.append(strl())
        result = results(a, n)
        if(len(result) == 1):
            print(result[0])
        else:
            print(result[0])
            for i in range(len(result[1])):
                print(*result[1][i])

if __name__ == '__main__':
    main()