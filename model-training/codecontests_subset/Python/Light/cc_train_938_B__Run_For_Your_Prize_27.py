#!/usr/bin/env python3

import sys

n = int(sys.stdin.readline().strip())
ais = list(map(int, sys.stdin.readline().strip().split()))

pmin = 1
pmax = 10**6

ais.append(pmax)

thrs = (pmin + pmax) // 2

lr = [a <= thrs for a in ais]

hpos = lr.index(False)
if not lr[0]:
    t = pmax - ais[0]
elif hpos == n:
    t = ais[n - 1] - pmin
else:
    t = max(pmax - ais[hpos], ais[hpos - 1] - pmin)

print (t)

