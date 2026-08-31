# -*- coding: utf-8 -*-
import sys
# from operator import itemgetter
# from fractions import gcd
# from math import ceil, floor
# from copy import deepcopy
# from itertools import accumulate
# from collections import Counter
# import math
# from functools import reduce
input = sys.stdin.readline
def ii(): return int(input())
def mi(): return map(int, input().rstrip().split())
def lmi(): return list(map(int, input().rstrip().split()))
def li(): return list(input().rstrip())
# template


def main():
    n = ii()
    s = li()
    s1 = s.count('1')
    s0 = s.count('0')
    # print(s1, s0)
    if n == 1:
        print(1)
        print(s[0])
        sys.exit()
    if s1 == s0:
        print(2)
        print(s[0], ''.join(s[1:]))
    else:
        print(1)
        print(''.join(s))


if __name__ == '__main__':
    main()
