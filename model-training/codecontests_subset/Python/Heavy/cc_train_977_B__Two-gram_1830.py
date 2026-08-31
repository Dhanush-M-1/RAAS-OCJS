from bisect import bisect
from collections import defaultdict
# l = list(map(int,input().split()))
# map(int,input().split()))
from math import gcd,sqrt,ceil,inf
from collections import Counter
import sys
sys.setrecursionlimit(10**9)

# def bfs(a):
#
#     bool[a] = True
#
#     queue = [a]
#     level = [0]*(n+1)
#     level[a] = 0
#     leveli[0].append(a)
#     while queue:
#         z = queue.pop(0)
#
#         for i in hash[z]:
#
#             if not bool[i]:
#                 bool[i] = True
#                 queue.append(i)
#                 level[i] = level[z]+1
#                 leveli[level[i]].append(i)
#
#
#
#
#
#
# n = int(input())
#
# l1 = list(map(int,input().split()))
# l2 = list(map(int,input().split()))
# l3 = list(map(int,input().split()))
# hash = defaultdict(list)
# bool = defaultdict(bool)
# leveli = defaultdict(list)
#
# for i in range(n-1):
#     a,b = map(int,input().split())
#     hash[a].append(b)
#     hash[b].append(a)
# perm = [[0,1,2],[1,0,2],[1,2,0],[2,1,0],[2,0,1],[0,2,1]]
# count = 0
# bfs(1)
# level = 0
# for a,b,c in perm:
#
#   yo = 0
#   z = a
#   while yo<=max(leveli):
#     z = yo%3
#     for i in leveli[level]:
#
#
#     yo+=1
#





hash = defaultdict(int)

n = int(input())
s = input()
ans = 0
# for i in range(1,n):
#     s1 = s[i]+s[i-1]
#     hash[(s1)]+=1
#     ans = max(ans,hash[(s1)])
for i in range(n-1):
    s1 = s[i]+s[i+1]
    hash[(s1)]+=1
    ans = max(ans,hash[(s1)])
for i in hash:
    if hash[i] == ans:
        print(i)
        exit()




