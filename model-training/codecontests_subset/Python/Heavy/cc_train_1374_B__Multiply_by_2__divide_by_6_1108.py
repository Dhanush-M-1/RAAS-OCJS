
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
def primes(n):
    i = 2
    factors = []
    while i * i <= n:
        if n % i:
            i += 1
        else:
            n //= i
            factors.append(i)
    if n > 1:
        factors.append(n)
    return factors

def solve():
    n = int(input())
    two = 0
    three = 0
    while n%2==0:
        n//=2
        two+=1
    while n%3==0:
        n//=3
        three+=1
    if n!=1 or two>three:
        print(-1)
        return
    print(three-two+three)
    
    
tt = int(input())
for test in range(tt):
    solve()

 


 
 
 
 
 
 
 
 
 
 
 
 
#
