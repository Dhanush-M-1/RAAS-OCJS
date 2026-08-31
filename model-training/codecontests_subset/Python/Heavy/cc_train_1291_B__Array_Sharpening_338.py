from sys import stdin
from collections import deque
mod = 10**9 + 7
import sys
sys.setrecursionlimit(10**5)
from queue import PriorityQueue
# def rl():
#     return [int(w) for w in stdin.readline().split()]
from bisect import bisect_right
from bisect import bisect_left
from collections import defaultdict
from math import sqrt,factorial,gcd,log2,inf,ceil
# map(int,input().split())
# # l = list(map(int,input().split()))
# from itertools import permutations
import heapq
# input = lambda: sys.stdin.readline().rstrip()
input = lambda : sys.stdin.readline().rstrip()
from sys import stdin, stdout
from heapq import heapify, heappush, heappop

t = int(input())

for _ in range(t):

    n = int(input())

    l = list(map(int,input().split()))

    flag = 0

    i = 0
    pre = -1
    yo = []
    for i in range(n):

        if l[i]>=i:
            yo.append(l[i])
            l[i] = i

            continue
        else:
            l[i-1] = yo[-1]
            flag = 1
            break



    if flag == 0:
        print('Yes')
        continue

    flag = 0

    for i in range(i,n):
        z = l[i-1] - 1
        if l[i]>=z and z>=0:
            l[i] = z
        elif l[i-1]>l[i]:
            continue
        else:
            flag = 1
            break
    # print(l)
    if flag:
        print('No')
    else:
        print('Yes')










