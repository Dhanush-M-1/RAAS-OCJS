from sys import stdin
from collections import deque
mod = 10**9 + 7
import sys
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

n,m = map(int,input().split())

l1 = list(map(int,input().split()))
l2 = list(map(int,input().split()))
hash2 = defaultdict(int)
for i in l2:
    hash2[i]+=1
z = l1[0]
ho = []
for i in range(n):
    z1 = l2[i]
    k = z1-z%m
    x = -1
    if k>0:
        x = k
    else:
        x = m+k
    hash1 = defaultdict(int)

    for j in range(n):
        hash1[(l1[j] + x)%m]+=1
    flag = 0
    for i in hash1:
        if hash1[i] == hash2[i]:
            continue
        else:
            flag = 1
            break
    if not flag:
        ho.append(x)
ho.sort()
if ho[0] == m:
    ho[0] = 0

print(ho[0])