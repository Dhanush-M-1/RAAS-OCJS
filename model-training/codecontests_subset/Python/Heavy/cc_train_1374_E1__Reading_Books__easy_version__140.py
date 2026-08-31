#!/bin/python3

import math
import os
import random
import re
import sys
from collections import defaultdict


a = [int(x) for x in  input().split() ]
n, k = a[0], a[1]
ara = []
for i in range(n):
    ara.append([int(x) for x in  input().split() ])
ara = sorted(ara,key=lambda x: x[0])

newAra = []
tmpAra1 = []
tmpAra2 = []
for i in range(n):
    if ara[i][1] == 1 and ara[i][2] == 1:
        newAra.append(ara[i])
    elif ara[i][1] == 1:
        tmpAra1.append(ara[i])
    elif ara[i][2] == 1:
        tmpAra2.append(ara[i])
for i in range( min(len(tmpAra1), len(tmpAra2))):
    newAra.append([ tmpAra1[i][0] + tmpAra2[i][0], 1, 1 ])

newAra = sorted(newAra,key=lambda x: x[0])

if len(newAra) < k:
    print(-1)
else:
    cnt = 0
    for i in range(k):
        cnt += newAra[i][0]
    print(cnt)
