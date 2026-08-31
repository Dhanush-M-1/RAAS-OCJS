from sys import stdin, stdout
import heapq
import cProfile
from collections import Counter, defaultdict, deque
from functools import reduce
import math
from bisect import bisect,bisect_right,bisect_left

def get_int():
    return int(stdin.readline().strip())


def get_tuple():
    return map(int, stdin.readline().split())


def get_list():
    return list(map(int, stdin.readline().split()))


def solve():
    n = get_int()
    c = 0
    f = 1
    while n>1:
        if n%6==0:
            n = n//6
        elif n%3==0:
            n = n*2
        else:
            f = 0
            break
        c += 1
    return c if f else -1

def main():
    print(solve())


TestCases = True

if TestCases:
    for i in range(get_int()):
        main()
else:
    main()
