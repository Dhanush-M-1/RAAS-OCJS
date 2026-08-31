# from collections import defaultdict, Counter, deque
# from heapq import heappop, heappush, heapify
# from functools import lru_cache, reduce
# import bisect
# from itertools import permutations, combinations, combinations_with_replacement
# from math import factorial as f, sqrt, inf, gcd
import sys

def input(): return sys.stdin.buffer.readline().rstrip()
def inputa(): return list(map(int, input().split()))
def out(var): sys.stdout.write(str(var)+"\n")
def outa(*var): sys.stdout.write(' '.join(map(str, var))+'\n')
# buffer may be optional
# could be import io and input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

def setup():
    import os
    dir_path = os.path.dirname(os.path.realpath(__file__))
    sys.stdin = open(os.path.join(dir_path, "input.txt"), 'r')
    sys.stdout = open(os.path.join(dir_path, "output.txt"), 'w')
#setup()

for _ in range(int(input())):
    n = int(input())
    rows = inputa()
    cols = inputa()
    arr = [(1,1)] + sorted( [(rows[i], cols[i]) for i in range(n)] )

    cost = 0
    # even: go left, odd: go right
    for i in range(1,n+1):
        r0, c0 = arr[i-1]
        r1, c1 = arr[i]

        # same diagonal
        if r1 - c1 == r0 - c0:
            if (r1 - c1) % 2 == 0:
                cost += (r1 - r0)
            continue

        diff = (r1 - c1) - (r0 - c0)
        # always: curr ≥ prev
        if (r0 - c0) % 2 == 0:
            cost += diff//2
        else:
            cost += (diff + 1)//2    
    out(cost)


# Test cases
'''
'''
