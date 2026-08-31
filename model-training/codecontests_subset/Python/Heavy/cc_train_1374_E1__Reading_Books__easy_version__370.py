
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
    n,k = [int(x) for x in input().split()]
    onlya = []
    onlyb = []
    both = []
    for i in range(n):
        t,a,b = [int(x) for x in input().split()]
        if a and b:
            both.append(t)
        elif b:
            onlyb.append(t)
        elif a:
            onlya.append(t)
    onlya = deque(sorted(onlya))
    both = deque(sorted(both))
    onlyb = deque(sorted(onlyb))
    ans = 0
    for i in range(k):
        if len(both) == 0 and (len(onlya)*len(onlyb)==0):
            print(-1)
            return
        if not (len(onlya)*len(onlyb)) or len(both) and both[0]<=onlya[0]+onlyb[0]:
            ans+= both.popleft()
        else:
            if len(onlya)*len(onlyb)==0:
                print(-1)
                return
            ans+=onlya.popleft()
            ans+=onlyb.popleft()
    print(ans)
            
            
tt = 1#int(input())
for test in range(tt):
    solve()

 


 
 
 
 
 
 
 
 
 
 
 
 
#
