import sys
inf = float("inf")
# sys.setrecursionlimit(1000000)


# abc='abcdefghijklmnopqrstuvwxyz'
# abd={'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4, 'f': 5, 'g': 6, 'h': 7, 'i': 8, 'j': 9, 'k': 10, 'l': 11, 'm': 12, 'n': 13, 'o': 14, 'p': 15, 'q': 16, 'r': 17, 's': 18, 't': 19, 'u': 20, 'v': 21, 'w': 22, 'x': 23, 'y': 24, 'z': 25}
mod,MOD=1000000007,998244353
# vow=['a','e','i','o','u']
# dx,dy=[-1,1,0,0],[0,0,1,-1]

from collections import deque, Counter, OrderedDict,defaultdict
from heapq import nsmallest, nlargest, heapify,heappop ,heappush, heapreplace
from math import ceil,floor,log,sqrt,factorial,pow,pi,gcd,log10,atan,tan
# from bisect import bisect_left,bisect_right


def get_array(): return list(map(int , sys.stdin.readline().strip().split()))
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def input(): return sys.stdin.readline().strip()

n = int(input())
Arr = []
for i in range(n):
    a,b = get_ints()
    Arr.append((a,b))

count = 0
for i in range(n):
    for j in range(n):
        if i==j:
            continue
        else:
            if Arr[i][0]==Arr[j][1]:
                count+=1
print(count)