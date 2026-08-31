
from collections import Counter,defaultdict,deque
#from heapq import *
#from itertools import *
#from operator import itemgetter
#from itertools import count, islice
#from functools import reduce
#alph = 'abcdefghijklmnopqrstuvwxyz'
#dirs = [[1,0],[0,1],[-1,0],[0,-1]]
#from math import factorial as fact
#a,b = [int(x) for x in input().split()]
#sarr = [x for x in input().strip().split()]
#import math
#from math import *

import sys
input=sys.stdin.readline
#sys.setrecursionlimit(2**30)
#MOD = 10**9+7

def solve():
    n,m = [int(x) for x in input().split()]
    a = set([int(x) for x in input().split()])
    b = set([int(x) for x in input().split()])
    s = a&b
    if len(s):
        print('YES')
        print(1,s.pop())
    else:
        print('NO')
    
tt = int(input())
for test in range(tt):
    solve()

 


 
 
 
 
 
 
 
 
 
 
 
 
#
