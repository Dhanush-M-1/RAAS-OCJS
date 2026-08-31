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

for _ in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    if n<5:
        print("0 0 0")
        continue
    g,s,b=0,0,0
    score = [[arr[0],1]]
    for c in arr[1:]:
        if c== score[-1][0]:
            score[-1][1]+=1
        else:
            score.append([c,1])

    g = score[0][1]
    j = 1
    while s<=g and j<len(score):
        s+= score[j][1]
        j+=1
    while j<len(score) and  (g+s+b+score[j][1])<= n//2 :
        b+= score[j][1]
        j+=1
    if g>0 and s>0 and b>0 and g<s and g<b:
        print(g,s,b)
        continue
    else:
        print("0 0 0")
        continue
