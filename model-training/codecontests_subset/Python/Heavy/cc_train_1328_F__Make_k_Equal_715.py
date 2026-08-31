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


n,k = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()
mp = collections.defaultdict(int)
dp = collections.defaultdict(int)
ans = float("inf")
for i,cr in enumerate(arr):
    c = cr
    sc = 0
    while c:
        mp[c]+=1
        if mp[c]<=k:
            dp[c]+=sc
        if mp[c]==k:
            ans = min(ans,dp[c])
        c//=2
        sc+=1

print(ans)