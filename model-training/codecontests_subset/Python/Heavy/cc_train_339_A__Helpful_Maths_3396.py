import sys
from sys import stdin,stdout
import math
import random
import heapq
from collections import Counter
from functools import lru_cache
#@lru_cache(maxsize=None) #for optimizing the execution time of callable objects/functions(placed above callable functions)
try:
    for _ in range(1):
        s=list(input().split("+"))
        s.sort()
        for i in range(len(s)):
            print(s[i],end="")
            if i!=len(s)-1:
                print("+",end="")
        






    
except EOFError as e:
    print(e)
