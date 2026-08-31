
from collections import Counter,defaultdict,deque
#from heapq import *
#import itertools
#from operator import itemgetter
#from itertools import count, islice
#from functools import reduce
#alph = 'abcdefghijklmnopqrstuvwxyz'
#dirs = [[1,0],[0,1],[-1,0],[0,-1]]
#from math import factorial as fact
#a,b = [int(x) for x in input().split()]
#sarr = [x for x in input().strip().split()]
#import math
from math import *
import sys
input=sys.stdin.readline
#sys.setrecursionlimit(2**30)



def solve():
    n = int(input())
    p,c = [int(x) for x in input().split()]
    fail = False
    if p<c:
        fail = True
    p0 = p
    c0 = c
    for i in range(1,n):
        p,c = [int(x) for x in input().split()]
        dc = c-c0
        dp = p-p0
        if dc<0 or p0<0 or dp<dc:
            fail = True
        p0 = p
        c0 = c
    if fail:
        print('NO')
    else:
        print('YES')
    
 
tt = int(input())
for test in range(tt):
    solve()
 
 


 
 
 
 
 
 
 
 
 
 
 
 
#
