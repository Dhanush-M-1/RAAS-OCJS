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
from math import factorial as f

def ncr(x, y):
    return f(x) // (f(y) * f(x - y))

t = int(input())

for _ in range(t):

    m,n = map(int,input().split())

    s = list(input())
    l = list(map(int,input().split()))
    pref = []
    for i in range(26):
        pref.append([0]*(m+1))

    for i in range(m):
        z = ord(s[i])-97
        i+=1

        pref[z][i] = 1

    for i in range(26):
        for j in range(1,m+1):
            pref[i][j] += pref[i][j-1]

    ans = [0]*(26)
    l.append(m)
    for i in l:
        for j in range(26):
            ans[j]+=pref[j][i]

    print(*ans)


