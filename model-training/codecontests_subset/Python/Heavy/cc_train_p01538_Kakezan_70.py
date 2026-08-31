import sys
from collections import defaultdict, Counter, deque
from itertools import accumulate, permutations, combinations
from operator import itemgetter
from bisect import bisect_left, bisect_right, bisect
from heapq import heappop, heappush
from fractions import gcd
from math import ceil, floor, sqrt, cos, sin, pi
from copy import deepcopy

def main():
    Q = int(input())
    for _ in range(Q):
        n = input()
        count = 0
        while len(n) > 1:
            if count == 1000000:
                count = -1
                break
            tmp = 0
            for i in range(1,len(n)):
                tmp = max(tmp, int(n[:i])*int(n[i:]))
            count += 1
            n = str(tmp)
        print(count) 

if __name__ == '__main__':
    main()

