from bisect import bisect_left as bl
from bisect import bisect_right as br
import heapq
import math
from collections import *
from functools import reduce,cmp_to_key
import sys
input = sys.stdin.readline
 
# M = mod = 998244353
# def factors(n):return sorted(set(reduce(list.__add__, ([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0))))
# def inv_mod(n):return pow(n, mod - 2, mod)
 
def li():return [int(i) for i in input().rstrip('\n').split()]
def st():return input().rstrip('\n')
def val():return int(input().rstrip('\n'))
def li2():return [i for i in input().rstrip('\n').split(' ')]
def li3():return [int(i) for i in input().rstrip('\n')]



def ispos(l):
    i = 0
    n = len(l)
    while i<n:
        if l[i]>=i:
            l[i] = i
        else:break
        i+=1
        
    while i<n:
        if l[i]>=l[i-1]:
            l[i] = l[i-1]-1
        if l[i]<0:return 0
        i+=1
    return 1 if i==n else 0

for _ in range(val()):
    n = val()
    l = li()
    print('Yes' if ispos(l[:]) or ispos(l[::-1]) else 'No')