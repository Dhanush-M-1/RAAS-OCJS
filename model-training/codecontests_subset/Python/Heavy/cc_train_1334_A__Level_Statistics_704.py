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

def solve(n):
    return (n*(n+1))//2

#
# t = int(input())
#
# for _ in range(t):
#
#     n = int(input())
#     l = []
#     for i in range(n):
#         a,b = map(int,input().split())
#         l.append([a,b])
#
#     flag = 0
#     for i in range(1,n):
#         a,b = l[i-1]
#         c,d = l[i]
#         if d>b:
#             if c<=a:
#                 flag = 1
#                 break
#             elif c-a < d-a:
#                 flag = 1
#                 break
#
#         if d == b:
#             if c<a:
#                 flag = 1
#                 break
#
#         if d<b:
#             flag = 1
#             break
#
#         if a>c:
#             flag = 1
#             break
#
#     if not flag:
#         print('YES')
#     else:
#         print('NO')
#
#
#



# t = int(input())
# 
# for i in range(t):
# 
#     n  = int(input())
#     l = []
# 
#     for i in range(n):
#         a,b = map(int,input().split())
#         l.append([a,b])
# 
# 
#     la = []
# 
#     for i in range(n):
#         la.append(max(l[i][0]-l[i-1][1],0))
# 
#     sumi = sum(la)
#     maxi = inf
#     for i in range(n):
#         z = sumi-max(l[i][0]-l[i-1][1],0) + l[i][0]
#         maxi = min(z,maxi)
# 
#     print(maxi)




for i in range(10**5):
    pass


t=int(input())
for _ in range(t):
    n=int(input())
    p=[]
    c=[]
    for i in range(n):
        x,y=map(int,input().split())
        p.append(x)
        c.append(y)
    cnt=0
    if c[0]>p[0]:
        cnt=1
    for i in range(1,n):
        if c[i]>p[i]:
            cnt=1
        if p[i]<p[i-1]:
            cnt=1
        if c[i]<c[i-1]:
            cnt=1
        if c[i]-c[i-1]>p[i]-p[i-1]:
            cnt=1
    if cnt==1:
        print("NO")
    else:
        print("YES")

