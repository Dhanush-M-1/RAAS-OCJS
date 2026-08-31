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
    P = lambda: map(int, input().split())
    N = lambda: int(input())

    p, ans = 0, 0

    try:
        while True:
            t = input()
            c = t.find(":")
            if c != -1:
                ans += p * (len(t) - c - 1)
            else:
                p += 1 if t[0] == "+" else -1
    except:
        pass
    print(ans)