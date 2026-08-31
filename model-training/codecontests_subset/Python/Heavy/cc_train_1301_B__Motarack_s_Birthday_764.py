from bisect import bisect_left as bl
from bisect import bisect_right as br
import heapq
import math
from collections import *
from functools import reduce,cmp_to_key
import sys
input = sys.stdin.readline
 
M = mod = 10**9 + 7
def factors(n):return sorted(set(reduce(list.__add__, ([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0))))
def inv_mod(n):return pow(n, mod - 2, mod)
 
def li():return [int(i) for i in input().rstrip('\n').split()]
def st():return input().rstrip('\n')
def val():return int(input().rstrip('\n'))
def li2():return [i for i in input().rstrip('\n').split(' ')]
def li3():return [int(i) for i in input().rstrip('\n')]

for _ in range(val()):
    n = val()
    l = li()
    mi = float('inf')
    ma = -float('inf')
    for i in range(n):
        if i > 0 and l[i] == -1 and l[i-1] != -1:
            mi = min(mi,l[i-1])
            ma = max(ma,l[i-1])
        if i < n-1 and l[i] == -1 and l[i+1] != -1: 
            mi = min(mi,l[i+1])
            ma = max(ma,l[i+1])
    if mi == float('inf') and ma == -float('inf'):
        print(0,0)
        continue
    elif mi == float('inf'):
        print(ma,0)
        continue
    elif ma == float('inf'):
        print(mi,0)
        continue
    # print('test',mi,ma)
    ans = (mi + ma)//2
    for i in range(n):
        if l[i] == -1:l[i] = ans
    # print(l)
    print(max(abs(l[i] - l[i-1]) for i in range(1,n)),ans)
