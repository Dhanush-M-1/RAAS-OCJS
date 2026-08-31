from bisect import bisect_left as bl
from bisect import bisect_right as br
import heapq
import math
from collections import *
from functools import reduce,cmp_to_key
import sys

input = sys.stdin.readline
M = mod = 10**9 + 7
def factors(n):return sorted(list(set(reduce(list.__add__,([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))))
def inv_mod(n):return pow(n, mod - 2, mod)

def li():return [int(i) for i in input().rstrip('\n').split(' ')]
def st():return input().rstrip('\n')
def val():return int(input())
def li2():return [i for i in input().rstrip('\n').split(' ')]
def li3():return [int(i) for i in input().rstrip('\n')]


n,m=li()
a = li()
b = li()
ans = float('inf')
cnt = Counter(b)
if sorted(a) == sorted(b):
    print(0)
    exit()
for i in range(n):
    if b[i]>a[0]:
        temp = b[i] - a[0]
    else:
        temp = m - a[0] + b[i]
    cnt2 = Counter()
    for j in range(n):
        cnt2[(a[j] + temp)%m] += 1
    if cnt == cnt2:
        ans = min(ans,temp)
    # print(cnt,cnt2)
print(ans)