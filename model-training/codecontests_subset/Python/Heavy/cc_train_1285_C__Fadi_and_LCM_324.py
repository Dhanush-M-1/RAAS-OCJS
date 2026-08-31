#                                               |
#   _` |  __ \    _` |   __|   _ \   __ \    _` |   _` |
#  (   |  |   |  (   |  (     (   |  |   |  (   |  (   |
# \__,_| _|  _| \__,_| \___| \___/  _|  _| \__,_| \__,_|

import sys
import math

def read_line():
	return sys.stdin.readline()[:-1]
 
def read_int():
	return int(sys.stdin.readline())
	
def read_int_line():
	return [int(v) for v in sys.stdin.readline().split()]

def read_float_line():
	return [float(v) for v in sys.stdin.readline().split()]

def gcd(a,b): 
    if a == 0: 
        return b 
    return gcd(b % a, a)

def printDivisors(n): 
    i = 1
    a,b = 0,0
    while i <= math.sqrt(n): 
        if (n % i == 0) : 
            if gcd(i,n//i)==1:
            	a = i
            	b = n//i
        i = i + 1
    return (a,b)

x =read_int()
ans = printDivisors(x)
print(*ans)

