from sys import stdin
from collections import deque
mod = 10**9 + 7
import sys
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

n = int(input())

la = []

for i in range(n):

    a,b = map(int,input().split())
    la.append([a,b])

x,y = la[0]
a,b = x-y,x
cnt = 2
# print(a,b)
for i in range(1,n-1):

      x,y = la[i]
      if x-y>b and x-y>la[i-1][0]:
          a,b = x-y,x
          cnt+=1
          # print(i)
      elif x>b and x+y<la[i+1][0]:
          a,b = x,x+y
          cnt+=1
          # print(i)
      # print(a,b)

if n == 1:
    print(1)
    exit()
    
print(cnt)