############## importing libraries ############################

from math import log2, ceil, floor
from collections import defaultdict, OrderedDict, Counter, deque
from heapq import heappush, heappop, heapify
import re

############### input functions ###############################
def inp():
    return input()
def list_inp():
    return list(map(int,input().split()))
def map_inp():
    return map(int,input().split())
def int_inp():
    return int(input())
def float_int():
    return float(input())
    
################# important functions ############################
def isprime(n):
    if (n <= 1) : 
        return False
    if (n <= 3) : 
        return True
    if (n % 2 == 0 or n % 3 == 0) : 
        return False
    i = 5
    while(i * i <= n) : 
        if (n % i == 0 or n % (i + 2) == 0) : 
            return False
        i = i + 6
    return True

################## my code ######################################

for _ in range(int_inp()):
    n,m = map_inp()
    a = list_inp()
    b = list_inp()
    c =-1
    if n<=m:
        l = 0
        ran = n
    else:
        l =1
        ran = m
    # sm = min(n,m)
    # lg = max(n,m)
    for i in range(ran):
        if l ==0:
            if a[i] in b:
                c = a[i]
                break
        else:
            if b[i] in a:
                c = b[i]
                break
    if c==-1:
        print("No")
    else:
        print("Yes")
        print(1,c)