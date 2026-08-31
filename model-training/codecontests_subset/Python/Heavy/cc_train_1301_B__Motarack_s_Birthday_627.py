from math import gcd
import bisect
import collections
import copy
import functools
import heapq
import itertools
import math
import random
import re
import sys
import time
import string
from typing import List
sys.setrecursionlimit(99999)


t, = map(int,input().split())
for _ in range(t):
    n, = map(int,input().split())
    arr = list(map(int,input().split()))

    m1,m2=float("inf"),float("-inf")
    for i in range(n):
        if arr[i]==-1:
            if i<n-1 and arr[i+1]!=-1:
                m1 = min(m1,arr[i+1])
                m2 = max(m2,arr[i+1])
            if i and arr[i-1]!=-1:
                m1 = min(m1,arr[i-1])
                m2 = max(m2,arr[i-1])
    mx = 2
    if m1>m2:
        mx = 2
    elif m1==m2:
        mx = m1
    else:
        mx = (m1+m2)//2
    mspace = 0
    for i in range(n):
        if arr[i] == -1:
            arr[i]=mx
        if i:
            mspace = max(mspace,abs(arr[i]-arr[i-1]))
    print(mspace,mx)
            
