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


def if_poss(x):

    mini = inf
    maxi = 0
    for i in range(n):
       if l[i] == -1:
           if i-1>=0:
              if l[i-1]!=-1:
               mini = min(l[i-1],mini)
               maxi = max(l[i-1],maxi)
           if i+1<n:
              if l[i+1]!=-1:
               mini = min(l[i+1],mini)
               maxi = max(l[i+1],maxi)


       if l[i]!=-1:
               if i-1>=0 and l[i-1]!=-1:
                   if abs(l[i]-l[i-1])>x:

                       return False






    if abs(maxi-(mini+x))<=x:

        hash[x] = mini + x
        return True
    elif abs(maxi-x - mini)<=x:

        hash[x] = maxi - x
        return True

    return False



















t = int(input())


for _ in range(t):

   hash = defaultdict(int)
   n = int(input())

   l = list(map(int,input().split()))


   if -1 not in l:
       maxi = 0
       for i in range(n-1):
           maxi = max(abs(l[i]-l[i+1]),maxi)

       print(maxi)
       continue
   elif l.count(-1) == n:
       print(0,0)
       continue

   mini = 0
   maxi = max(l)
   ans = 0
   while mini!=maxi:

       mid = (mini+maxi)//2


       if if_poss(mid):

           maxi = mid-1
           if mid == 0:
               break
       else:
           mini = mid+1

       if mini >= maxi:

           if if_poss(mini-1):

               ans = mini-1
               break
           if if_poss(mini):

               ans = mini
               break

           if if_poss(mini+1):
               ans = mini+1
               break





   print(ans,hash[ans])









