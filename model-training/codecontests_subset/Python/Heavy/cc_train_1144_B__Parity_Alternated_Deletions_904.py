import math
import os
import random
import re
import sys
import functools
from operator import itemgetter, attrgetter
from collections import Counter

if __name__ == '__main__':
    Y = lambda: list(map(int, input().split()))
    N = lambda: int(input())
    even, odd = list(), list()

    n = N()
    a = Y()
    a.sort()

    even = list(filter(lambda x: x % 2 == 0, a))
    odd = list(filter(lambda y: y % 2 == 1, a))
    h = len(even) - len(odd)

    if h == 0 or h == 1:
        print(0)
    else:
        print(sum(i for i in even[:h - 1]) if h > 0 else sum(i for i in odd[:(h*-1) - 1]))