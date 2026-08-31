from sys import stdin
from collections import deque
mod = 10**9 + 7
import sys
import random
# sys.setrecursionlimit(10**6)
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
from itertools import permutations
from math import factorial as f

# def ncr(x, y):
#     return f(x) // (f(y) * f(x - y))
def ncr(n, r, p):
    num = den = 1
    for i in range(r):
        num = (num * (n - i)) % p
        den = (den * (i + 1)) % p
    return (num * pow(den,
                      p - 2, p)) % p

import sys
# input = sys.stdin.readline
# LCA
# def bfs(na):
#
#     queue = [na]
#     boo[na] = True
#     level[na] = 0
#
#     while queue!=[]:
#
#         z = queue.pop(0)
#
#         for i in hash[z]:
#
#             if not boo[i]:
#
#                 queue.append(i)
#                 level[i] = level[z] + 1
#                 boo[i] = True
#                 dp[i][0] = z
#
#
#
# def prec(n):
#
#     for i in range(1,20):
#
#         for j in range(1,n+1):
#             if dp[j][i-1]!=-1:
#                 dp[j][i] = dp[dp[j][i-1]][i-1]
#
#
# def lca(u,v):
#     if level[v] < level[u]:
#         u,v = v,u
#
#     diff = level[v] - level[u]
#
#
#     for i in range(20):
#         if ((diff>>i)&1):
#             v = dp[v][i]
#
#
#     if u == v:
#         return u
#
#
#     for i in range(19,-1,-1):
#         # print(i)
#         if dp[u][i] != dp[v][i]:
#
#             u = dp[u][i]
#             v = dp[v][i]
#
#
#     return dp[u][0]
#
# dp = []
#
#
# n = int(input())
#
# for i in range(n + 10):
#
#     ka = [-1]*(20)
#     dp.append(ka)


t = int(input())

for _ in range(t):

    n = int(input())

    l = list(map(int,input().split()))

    seti = set()

    for i in range(n):

        seti.add((l[i]+i)%n)

    if len(seti) == n:
        print('YES')
    else:
        print('NO')



