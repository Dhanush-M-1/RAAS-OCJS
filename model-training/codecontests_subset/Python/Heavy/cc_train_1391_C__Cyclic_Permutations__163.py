#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Aug  9 19:55:54 2020

@author: divyarth
"""

import sys
import heapq
import math

#sys.setrecursionlimit(100007)
#input=sys.stdin.readline
#print=sys.stdout.write

from collections import deque
from collections import defaultdict
from collections import Counter

modH=int(10**9)+7
I=lambda : list(map(int,input().split(' ')))
def PRINT(lst,sep=' '): print(sep.join(map(str,lst)))



n=int(input())
if n>=4:
    dp=[0]*(n+1)
    mem=[0]*(n+1)
    mem[0]=1
    for i in range(1,n+1):
        mem[i]=((mem[i-1]%modH)*(i%modH))%modH
    dp[3]=2
    m=n
    for n in range(4,m+1):            
        dp[n]= (((n-2)%modH)*(mem[n-1]%modH)+ ((2%modH)*(dp[n-1]%modH))%modH)%modH
    print(dp[-1])
elif n==3:
    print(2)
else:
    print(0)