import sys

# import math
from collections import deque

# import heapq

# from math import inf
# from math import gcd

# print(help(deque))
# 26
pprint = lambda s: print(' '.join(map(lambda x: str(x), s)))
input = lambda: sys.stdin.readline().strip()
ipnut = input
mod = 1000000007
for _ in range(1):
    # z1, o1, t1 = map(int, input().split())
    n = int(input())
    # a = list(map(int, input().split()))
    factorial = 1
    step = 1
    for i in range(n):
        factorial = factorial*(i+1)%mod
        if i >= 1:
            step = step*2%mod
    print((factorial-step)%mod)