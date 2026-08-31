from sys import stdin
from collections import deque
mod = 10**9 + 7
import sys
# sys.setrecursionlimit(10**5)
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

n = int(input())
mini = inf
a = -1
b = -1
for i in range(1,int(sqrt(n))+1):
    if n%i == 0:
        g = (i*(n//i))//(gcd(n//i,i))
        if g == n:
            mini = min(mini,max(i,n//i))
            if mini == max(i,n//i):
                a = i
                b = n//i

print(a,b)
