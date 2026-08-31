from sys import stdin, stdout
import heapq
import cProfile
from collections import Counter, defaultdict, deque
from functools import reduce
import math


def get_int():
    return int(stdin.readline().strip())


def get_tuple():
    return map(int, stdin.readline().split())


def get_list():
    return list(map(int, stdin.readline().split()))


def solve():
    n,m = get_tuple()
    a = get_list()
    b = get_list()
    freq_dic = Counter(b)
    for val in a:
        if val in freq_dic:
            print("YES")
            print(1,val)
            return
    print("NO")


def main():
    solve()


TestCases = True

if TestCases:
    for i in range(get_int()):
        main()
else:
    main()
