from fractions import gcd
from datetime import date, timedelta
from heapq import*
import math
from collections import defaultdict, Counter, deque
import sys
from bisect import *
import itertools
import copy
sys.setrecursionlimit(10 ** 7)
MOD = 10 ** 9 + 7


def main():
    n = int(input())
    for i in range(n):
        a, b, c = map(int, input().split())
        ans = 0
        k = min(b, c // 2)
        b -= k
        c -= 2 * k
        t = min(a, b // 2)
        print(k + 2*k + t + 2*t)
        
    

    

if __name__ == '__main__':
    main()
