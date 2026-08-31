#!/usr/bin/python3

import sys
from itertools import product
from functools import reduce
import math

s1, s2 = input().strip().split(' ')
print('{} {}'.format(s1,s2))

N = int(input().strip())
for n in range(N):
    killed, cand = input().strip().split(' ')
    if s1 == killed:
        s1 = cand
    else:
        s2 = cand
    print('{} {}'.format(s1,s2))
