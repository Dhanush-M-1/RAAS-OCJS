from collections import Counter
import math
import sys
from bisect import bisect,bisect_left,bisect_right
from itertools import permutations
def input(): return sys.stdin.readline().strip()
def INT(): return int(input())
def MAP(): return map(int, input().split())
def LIST(N=None): return list(MAP()) if N is None else [INT() for i in range(N)]
def mod(): return 10**9+7

for i in range(INT()): 
    n = INT()
    #s = input()
    #a,b = MAP()
    #a = LIST()
    arr = []
    xx=0
    yy=0
    xx=xx+yy
    for i in range(n):
        s = input()
        a = [str(i) for i in s]
        arr.append(a)
    x = arr[0][1]
    x1 = arr[1][0]
    y = arr[-1][-2]
    y1 = arr[-2][-1]

    if x1 == x and y1 == y and x1 != y1:
        print(0)
    elif x1 == x == y1 == y:
        print(2)
        print(2,1)
        print(1,2)
        
    elif x1 == x and y1 != y:
        print(1)
        if x != y:
            print(n-1,n)
        else:
            print(n,n-1)
    elif x1!=x and y == y1:
        print(1)
        if x != y:
            print(2,1)
        else:
            print(1,2)
    elif x1!=x and y!=y1:
        print(2)
        if x != y:      
            print(1,2)
            print(n,n-1)
        else:
            print(1,2)
            print(n-1,n)