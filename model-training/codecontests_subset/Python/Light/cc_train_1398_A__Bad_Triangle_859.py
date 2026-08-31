#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Aug 14 19:55:00 2020

@author: divyarth
"""

import sys
import heapq
import math

#sys.setrecursionlimit(100000)
#input=sys.stdin.readline
#print=sys.stdout.write

from collections import deque
from collections import defaultdict
from collections import Counter

modH=int(10**9)+7
I=lambda : list(map(int,input().split(' ')))
def PRINT(lst,sep=' '): print(sep.join(map(str,lst)))

for _ in range(int(input())):
    n=int(input())    
    lst=I()
    if lst[-1]>=lst[0]+lst[1]:
        ans=[1,2,n]
        PRINT(ans)
    else:
        print(-1)
        