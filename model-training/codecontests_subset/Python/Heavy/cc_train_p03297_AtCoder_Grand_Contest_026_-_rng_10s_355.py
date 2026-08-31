import bisect
import copy
import heapq
import math
import sys
from collections import *
from functools import lru_cache
from itertools import accumulate, combinations, permutations, product
def input():
    return sys.stdin.readline()[:-1]
def ruiseki(lst):
    return [0]+list(accumulate(lst))
sys.setrecursionlimit(500000)
mod=pow(10,9)+7
al=[chr(ord('a') + i) for i in range(26)]
direction=[[1,0],[0,1],[-1,0],[0,-1]]

t=int(input())
abcd=[list(map(int,input().split())) for i in range(t)]

for i in range(t):
    a,b,c,d=abcd[i]
    if a<b:
        print("No")
    elif d<b:
        print("No")
    elif c>=b:
        print("Yes")
    elif b-math.gcd(b,d)+(a%math.gcd(b,d))>c:
        print("No")
    else:
        print("Yes")