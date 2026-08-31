#!/usr/bin/python3

import sys
import itertools

s = next(sys.stdin).rstrip()
n = len(s)
a = 0
succ = [[] for i in range(n)]
d = {0: 0}

def getStep(a):
    ret = None
    for alt in itertools.chain([1 << rot for rot in range(26)], [0]):
        x = a ^ alt
        if x in d and (ret is None or d[x] + 1 < ret):
            ret = d[x] + 1
    return ret

for i, c in enumerate(s):
    ac = ord(c) - 0x61
    br = 1 << ac
    a = a ^ br
    s = getStep(a)
    if s is None: raise ValueError
    if a not in d or s < d[a]: d[a] = s
print(getStep(a))

