import itertools
import functools
import math
import sys
from collections import defaultdict
import sys

 
def stdinWrapper():
    data = '''5 2
1 3
2 4
3 5
4 6
5 7
'''
   
    
    for line in data.split('\n'):
        yield line
 
if '--debug' not in sys.argv:
    def stdinWrapper():
        while True:
            yield sys.stdin.readline()
 
inputs = stdinWrapper()
 
def inputWrapper():
    return next(inputs)
 
def getType(_type):
    return _type(inputWrapper())
 
def getArray(_type):
    return [_type(x) for x in inputWrapper().split()]
 
 
 
''' Solution '''

def solve(b, k):
    LIMIT = 998244353

    # precompute
    N = 3*100000 + 5

    fact = [0] * N
    fact[0] = 1
    for i in range(1, N):
        fact[i] = fact[i-1] * i % LIMIT


    def fastpow(a, b):
        res = 1
        a %= LIMIT
        while b > 0:
            if b & 1:
                res = res * a % LIMIT
            a = a * a % LIMIT
 
            b >>= 1
 
        return res
    
    def choices(n, k):
        return (fact[n] * fastpow((fact[k] * fact[n - k]) % LIMIT, LIMIT - 2)) % LIMIT
 
    events = []
    for start, end in b:
        events.append(start*2)
        events.append(end*2+1)


    events.sort()
 

    w = 0
    s = 0
    for e in events:
        if e % 2:
            s -= 1
            
        else:
            if s >= k-1:
                w += choices(s, k-1)
                w %= LIMIT

            s += 1
            

        

    return (w + LIMIT) % LIMIT

    
    

n, k = getArray(int)

bulbs = [getArray(int) for _ in range(n)]


res = solve(bulbs, k)
print(res)


